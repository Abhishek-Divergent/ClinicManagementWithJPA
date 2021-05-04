package com.divergent.clinicmanagementsystem.service;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergent.clinicmanagementsystem.data.AppointmentCrud;
import com.divergent.clinicmanagementsystem.data.DoctorCrud;
import com.divergent.clinicmanagementsystem.data.DrugsCrud;
import com.divergent.clinicmanagementsystem.data.LabTestCrud;
import com.divergent.clinicmanagementsystem.data.PatientCrud;
import com.divergent.clinicmanagementsystem.entity.Admin;

/**
 * 
 * @author JAI MAHAKAL
 *
 */
@Service
public class AdminImpl implements AdminService {

	private static final Logger myLogger = LoggerFactory.getLogger(Admin.class.getName());
	private Scanner scobj = new Scanner(System.in);
	@Autowired
	private PatientCrud patientCrud;
	@Autowired
	private DoctorCrud doctorCrud;
	@Autowired
	private DrugsCrud drugsCrud;
	@Autowired
	private LabTestCrud labTestCrud;
	@Autowired
	private AppointmentCrud appointmentCrud;

	@Override
	public boolean adminPanel() {
		myLogger.info("************************ADMIN Opreation PANEL************************\n");
		adminpanel: while (true) {
			System.out.println(" 1. Patient :" + "\n 2. Doctor :" + "\n 3. Drugs : " + "\n 4. Lab Test :"
					+ "\n 5. Appointment" + "\n 6. Exits\n\n");
			System.out.print("\nEnter Choice The Option----");
			int choice = scobj.nextInt();
			switch (choice) {
			case 1: {
				myLogger.info("Patient Crud Operation");
				patientCrud.patientPanel();
				break;
			}
			case 2:
				myLogger.info("Doctor Crud Operation");
				doctorCrud.doctorPanel();
				break;
			case 3:
				myLogger.info("Drugs Crud Operation");
				drugsCrud.drugsPanel();
				break;
			case 4:
				myLogger.info("Labtest Crud Operation");
				labTestCrud.labTestPanel();
				break;
			case 5:
				myLogger.info("Appointment Operation");
				appointmentCrud.appoinmentPanel();
				break;
			case 6:
				break adminpanel;
			default:
				myLogger.warn("----Worng Choioce---- \n");
				continue;
			}
		}

		return true;
	}
}
