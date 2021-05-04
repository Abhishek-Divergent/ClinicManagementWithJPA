package com.divergent.clinicmanagementsystem.data;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagementsystem.entity.Appointment;
import com.divergent.clinicmanagementsystem.service.AppointmentService;

@Component
public class AppointmentCrud {

	private static final Logger myLogger = LoggerFactory.getLogger(AppointmentCrud.class.getName());
	private Scanner scobj = new Scanner(System.in);
	@Autowired
	private AppointmentService appointmentService;

	public void appoinmentPanel() {
		myLogger.info("\n************************Appoinment CRUD************************\n");
		p_panel: while (true) {
			System.out.println("1: Appoinment Create");
			System.out.println("2: Appoinment Read");
			System.out.println("3: Appoinment Delete");
			System.out.println("4: Appoinment Update");
			System.out.println("5: Patient Detail By Id");
			System.out.println("6: Exit \n");
			System.out.print("\nEnter Choice The Option----  ");
			int choice = scobj.nextInt();
			switch (choice) {
			case 1:
				myLogger.info("Appoinment Create");
				create();
				break;
			case 2:
				myLogger.info("Appoinment Read");
				read();
				break;

			case 3:
				myLogger.info("Appoinment Delete");

				delete();
				break;
			case 4:
				myLogger.info("Appoinment Update");

				update();
				break;
			case 5:
				myLogger.info("Patient Detail By Id");
				findById();
				break;
			case 6:
				break p_panel;
			default:
				myLogger.warn(("--- -Worng Choioce---- \n"));
				continue;
			}

		}

	}

	public void create() {
		System.out.print("\nEnter  Doctor Id  --");
		int doctor_id = scobj.nextInt();
		System.out.print("\nEnter  Patient Id  --");
		int patient_id = scobj.nextInt();
		scobj.nextLine();
		System.out.print("\nEnter  Doctor Name  --");
		String doctor_name = scobj.nextLine().trim();
		System.out.print("\nEnter  Patient Name  --");
		String patient_name = scobj.nextLine().trim();
		System.out.print("\nEnter  Problem  --");
		String problem = scobj.nextLine().trim();
		System.out.print("\nEnter  Date  --");
		String date = scobj.nextLine().trim();
		System.out.print("\nEnter  Time  --");
		String time = scobj.nextLine();
		try {
			Appointment appointment = new Appointment();
			appointment.setDoctor_id(doctor_id);
			appointment.setPatient_id(patient_id);
			appointment.setDoctor_name(doctor_name);
			appointment.setPatient_name(patient_name);
			appointment.setTime(time);
			appointment.setProblem(problem);
			appointment.setDate(date);
			appointmentService.create(appointment);
			myLogger.info("\n-------Value Has Inserted-------");
		} catch (Exception e) {
			myLogger.info("\n-------Value Has Not Inserted-------");
			myLogger.warn(e.getMessage());
		}

	}

	public void delete() {
		System.out.print("\n----Enter Appoinment ID  To Delete Appoinment--");
		int deleteid = scobj.nextInt();
		if (appointmentService.remove(deleteid)) {
			myLogger.info("\n----Appoinment Delete----\n");
		} else {
			myLogger.info("\n---- Appoinment Not Delete----\n");
		}
	}

	public void update() {
		System.out.print("\n----Enter Appoinment ID  To Update Appoinment--");
		int updateid = scobj.nextInt();

		System.out.println("\n----Appoinment Id is ------" + updateid);
		System.out.print("\nEnter  Doctor Id  --");
		int doctor_id = scobj.nextInt();
		System.out.print("\nEnter  Patient Id  --");
		int patient_id = scobj.nextInt();
		scobj.nextLine();
		System.out.print("\nEnter  Doctor Name  --");
		String doctor_name = scobj.nextLine().trim();
		System.out.print("\nEnter  Patient Name  --");
		String patient_name = scobj.nextLine().trim();
		System.out.print("\nEnter  Problem  --");
		String problem = scobj.nextLine().trim();
		System.out.print("\nEnter  Date  --");
		String date = scobj.nextLine().trim();
		System.out.print("\nEnter  Time  --");
		String time = scobj.nextLine();
		if (appointmentService.update(updateid, doctor_id, patient_id, doctor_name, patient_name, problem, date,
				time)) {
			myLogger.info("\n----Appoinment Update----\n");
		} else {
			myLogger.info("\n---- Appoinment Not Update----\n");
		}
	}

	public void read() {
		List<Appointment> list = appointmentService.read();
		for (Appointment appointment : list) {
			System.out.println(appointment + " ");
		}
	}

	public void findById() {
		System.out.println("Enter Patient Id to Fetch Data");
		int id = scobj.nextInt();
		List<Appointment> list = appointmentService.read();
		for (Appointment appointment : list) {
			if (id == appointment.getPatient_id()) {
				System.out.println(appointment);
			}
		}
	}
}
