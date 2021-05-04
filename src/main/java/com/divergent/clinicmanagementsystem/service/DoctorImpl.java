package com.divergent.clinicmanagementsystem.service;

import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergent.clinicmanagementsystem.doa.ApplicationDao;
import com.divergent.clinicmanagementsystem.entity.Appointment;
import com.divergent.clinicmanagementsystem.entity.Priscription;

/**
 * This is Doctor class Contain doctor_Logins to login doctor And Doctor Panel
 * Contain All Operation Performed By Doctor
 * 
 * @author JAI MAHAKAL
 *
 */
@Service
public class DoctorImpl implements DoctorService {
	private static final Logger myLogger = LoggerFactory.getLogger(DoctorImpl.class.getName());
	private Scanner scobj = new Scanner(System.in);
	private long doctorid;

	@Override
	public void setDoctortid(long id) {
		this.doctorid = id;
	}

	@Autowired
	private ApplicationDao applicationDao;

	@Override
	public void doctorPanel() {

		myLogger.info("Panel For Doctor To Select  Option :");
		doctorpanel: while (true) {
			System.out.print("\n1. List of Appointed  Patient \n" + "2. Add Prescription And Notes For  Patient\n"
					+ "3. Exit\n");
			System.out.print("\nEnter Choice The Option----  :");
			int choice = scobj.nextInt();
			switch (choice) {
			case 1:
				myLogger.info(" Patient List :");
				readPatientList();
				break;
			case 2:
				myLogger.info(" Patient Prescription :");
				createPrescription();
				break;
			case 3:

				break doctorpanel;
			default:
				myLogger.warn("----- Worng Choioce -----\n");
				continue;
			}
		}

	}

	@Transactional
	public void readPatientList() {
		List<Appointment> list = applicationDao.readPatientList();
		myLogger.info(" Patient List Allocated to Doctor");
		for (Appointment appointment : list) {
			if (this.doctorid == appointment.getDoctor_id()) {
				System.out.println("\n" + appointment);
			}
		}

	}

	@Transactional
	public void createPrescription() {
		System.out.print("\nEnter Priscription Id  --:");
		// int id = scobj.nextInt();
		System.out.print("\nEnter Doctor Id  --:");
		int doctor_id = scobj.nextInt();
		System.out.print("\nEnter Patient Id  --:");
		int patient_id = scobj.nextInt();
		scobj.nextLine();
		System.out.print("\n Enter Note Name  --:");
		String note = scobj.nextLine().trim();
		System.out.print("\nEnter  Priscription  --:");
		String priscriptions = scobj.nextLine().trim();
		Priscription priscription = new Priscription();
		// priscription.setId(id);
		priscription.setDoctor_id(doctor_id);
		priscription.setPatient_id(patient_id);
		priscription.setPriscription(priscriptions);
		priscription.setNote(note);
		applicationDao.createPriscription(priscription);
	}

}
