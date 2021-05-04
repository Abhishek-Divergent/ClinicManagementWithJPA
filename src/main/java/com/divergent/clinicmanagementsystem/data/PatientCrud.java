package com.divergent.clinicmanagementsystem.data;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagementsystem.entity.Patient;
import com.divergent.clinicmanagementsystem.service.PatientService;

@Component
public class PatientCrud {
	private static final Logger myLogger = LoggerFactory.getLogger(PatientCrud.class.getName());
	private static Scanner scobj = new Scanner(System.in);
	@Autowired
	PatientService patientService;

	public void patientPanel() {
		p_panel: while (true) {
			myLogger.info("\n************************Patient CRUD************************\n");
			System.out.println("1. Patient Create");
			System.out.println("2. Patient Read");
			System.out.println("3. Patient Update");
			System.out.println("4. Patient Delete");
			System.out.println("5. Exit \n");
			System.out.print("\nEnter Choice The Option----  ");
			int choice = scobj.nextInt();
			switch (choice) {
			case 1:
				myLogger.info("Patient Create");
				create();
				break;
			case 2:
				myLogger.info("Patient Read");
				read();
				break;
			case 3:
				myLogger.info("Patient Update");
				update();
				break;
			case 4:
				myLogger.info("Patient Delete");
				delete();
				break;
			case 5:
				break p_panel;
			default:
				myLogger.warn("--- -Worng Choioce---- \n");
				continue;
			}
		}
	}

	public void create() {
		scobj.nextLine();
		System.out.print("\nEnter Patient Name  --");
		String name = scobj.nextLine().trim();
		System.out.print("\nEnter Patient Gender  --");
		String gender = scobj.nextLine().trim();
		System.out.print("\nEnter Patient Age  --");
		int age = scobj.nextInt();
		System.out.print("\nEnter Patient Weight  --");
		int weight = scobj.nextInt();
		scobj.nextLine();
		System.out.print("\nEnter Patient Address  --");
		String address = scobj.nextLine().trim();
		System.out.print("\nEnter Patient Contact  --");
		String contact = scobj.nextLine().trim();
		Patient patient = new Patient();
		patient.setName(name);
		patient.setGender(gender);
		patient.setContact(contact);
		patient.setAge(age);
		patient.setWeight(weight);
		patient.setAddress(address);

		patientService.create(patient);
		myLogger.info(" Value is inserted ");
	}

	public void delete() {
		myLogger.info("\n----Enter Patient ID  To Delete Patient --");
		int deleteid = scobj.nextInt();
		if (patientService.delete(deleteid)) {
			System.out.println("\n-------Patient Deleted--------");
		} else {
			System.out.println("\n-------Patient Not Deleted--------");
		}
	}

	public void update() {
		read();
		myLogger.info("\n----Enter Patient ID Which You Want to UPDATE --");
		int updateid = scobj.nextInt();
		scobj.nextLine();
		System.out.print("\nPatient Id----: " + updateid);
		System.out.print("\nEnter Patient Name  --");
		String name = scobj.nextLine().trim();
		System.out.print("\nEnter Patient Gender  --");
		String gender = scobj.nextLine().trim();
		System.out.print("\nEnter Patient Age  --");
		int age = scobj.nextInt();
		System.out.print("\nEnter Patient Weight  --");
		int weight = scobj.nextInt();
		scobj.nextLine();
		System.out.print("\nEnter Patient Address  --");
		String address = scobj.nextLine().trim();
		System.out.print("\nEnter Patient Contact  --");
		String contact = scobj.nextLine().trim();
		if (patientService.update(updateid, name, gender, age, weight, contact, address)) {
			myLogger.info("\n-------Value Has Updated-------");
		} else {
			myLogger.warn("\n-------Value NOT Updated-------");
		}
	}

	public void read() {
		List<Patient> list = patientService.read();
		for (Patient patient : list) {
			System.out.println(patient + " ");
		}
	}

}
