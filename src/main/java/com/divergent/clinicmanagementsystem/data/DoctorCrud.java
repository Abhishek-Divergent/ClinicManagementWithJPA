package com.divergent.clinicmanagementsystem.data;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagementsystem.entity.Doctor;
import com.divergent.clinicmanagementsystem.service.DoctorCrudService;

@Component
public class DoctorCrud {
	private static final Logger myLogger = LoggerFactory.getLogger(DoctorCrud.class.getName());
	private Scanner scobj = new Scanner(System.in);
	@Autowired
	private DoctorCrudService DoctorCrudService;

	public void doctorPanel() {
		D_panel: while (true) {
			myLogger.info("\n************************Doctor CRUD************************\n");
			System.out.println("1. Doctor Create : ");
			System.out.println("2. Doctor Read : ");
			System.out.println("3. Doctor Update : ");
			System.out.println("4. Doctor Delete : ");
			System.out.println("5. Exit \n");
			System.out.print("\nEnter Choice The Option -------:");
			int choice = scobj.nextInt();
			switch (choice) {
			case 1:
				myLogger.info("Create A Doctor : ");
				create();
				break;
			case 2:
				myLogger.info("Read A Doctor : ");
				read();
				break;
			case 3:
				myLogger.info("Update A Doctor : ");
				update();
				break;
			case 4:
				myLogger.info("Delete A Doctor : ");
				delete();
				break;
			case 5:
				break D_panel;
			default:
				myLogger.warn(" -----Worng Choioce----- :\n");

				continue;
			}
		}
	}

	public void create() {
		System.out.print("\nEnter Doctor Name  --: ");
		String name = scobj.nextLine().trim();
		System.out.print("\nEnter Doctor Username  --: ");
		String username = scobj.nextLine().trim();
		System.out.print("\nEnter Doctor password --: ");
		String password = scobj.nextLine().trim();
		System.out.print("\nEnter Doctor Speciality  --: ");
		String speciality = scobj.nextLine().trim();
		System.out.print("\nEnter Doctor Contact  --: ");
		String contact = scobj.nextLine().trim();
		System.out.println("\nEnter Doctor Fees  --: ");
		int fees = scobj.nextInt();
		Doctor doctor = new Doctor();
		doctor.setFees(fees);
		doctor.setName(name);
		doctor.setUsername(username);
		doctor.setPassword(password);
		doctor.setSpeciality(speciality);
		doctor.setContact(contact);
		try {
			DoctorCrudService.create(doctor);
			myLogger.info("\n-------Value Has Inserted-------: ");
		} catch (Exception e) {
			myLogger.info("\n-------Value Has Inserted------- :");
		}
	}

	public void delete() {
		System.out.print("\n----Enter Doctor ID  To Delete Doctor ---- : ");
		int deleteid = scobj.nextInt();
		if (DoctorCrudService.delete(deleteid)) {
			myLogger.info("\n----Doctor  Deleted ---- : ");
		} else {
			myLogger.info("\n----Doctor Not Deleted ---- : ");
		}
	}

	public void update() {
		System.out.print("\n----Enter Doctor ID Which You Want To UPDATE ---- : ");
		int updateid = scobj.nextInt();
		scobj.nextLine();
		System.out.println("\n\n  Doctor ID  --: " + updateid);
		System.out.print("\nEnter Doctor Name  --: ");
		String name = scobj.nextLine().trim();
		System.out.print("\nEnter Doctor Username  --: ");
		String username = scobj.nextLine().trim();
		System.out.print("\nEnter Doctor password --: ");
		String password = scobj.nextLine().trim();
		System.out.print("\nEnter Doctor Speciality  --: ");
		String speciality = scobj.nextLine().trim();
		System.out.print("\nEnter Doctor Contact  --: ");
		String contact = scobj.nextLine().trim();
		System.out.println("\nEnter Doctor Fees  --: ");
		int fees = scobj.nextInt();
		if (DoctorCrudService.update(updateid, name, username, password, speciality, contact, fees)) {
			myLogger.info("\n-------Value  Updated------- : ");
		} else {
			myLogger.info("\n-------Value Not Updated------- : ");
		}
	}

	public void read() {
		List<Doctor> list = DoctorCrudService.read();
		for (Doctor doctor : list) {
			System.out.println(doctor + " ");
		}
	}
}