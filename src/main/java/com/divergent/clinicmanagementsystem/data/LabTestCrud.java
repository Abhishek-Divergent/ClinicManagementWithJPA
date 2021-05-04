package com.divergent.clinicmanagementsystem.data;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagementsystem.entity.Labtest;
import com.divergent.clinicmanagementsystem.service.LabTestService;

@Component
public class LabTestCrud {

	private static final Logger myLogger = LoggerFactory.getLogger(LabTestCrud.class.getName());
	private Scanner scobj = new Scanner(System.in);
	@Autowired
	private LabTestService labTestService;

	public void labTestPanel() {
		p_panel: while (true) {
			myLogger.info("\n************************LabTest CRUD************************\n");
			System.out.println("1:LabTest Create : ");
			System.out.println("2:LabTest Read : ");
			System.out.println("3:LabTest Update : ");
			System.out.println("4:LabTest Delete : ");
			System.out.println("5:Exit :  \n");
			System.out.print("\nEnter Choice The Option----:  ");
			int choice = scobj.nextInt();
			switch (choice) {
			case 1:
				myLogger.info("Lab Test Create : ");
				create();
				break;
			case 2:
				myLogger.info(" Lab Test Read : ");
				read();
				break;
			case 3:
				myLogger.info("Lab Test Update : ");
				update();
				break;
			case 4:
				myLogger.info("Lab Test Delete : ");
				delete();
				break;
			case 5:
				break p_panel;
			default:
				myLogger.warn("----Worng Choioce----\n");
				continue;
			}
		}

	}

	public void create() {
		System.out.print("\nEnter LabTest Name  --: ");
		String name = scobj.nextLine().trim();
		System.out.print("\nEnter LabTest Price  --: ");
		int price = scobj.nextInt();
		Labtest labtest = new Labtest();
		labtest.setName(name);
		labtest.setPrice(price);
		try {
			labTestService.create(labtest);
			myLogger.info("\n-------Value Has Inserted-------");
		} catch (Exception e) {
			myLogger.error(e.getMessage());
			myLogger.warn(e.getMessage());
			myLogger.info("\n-------Value Has Not Inserted-------");
		}
	}
	public void delete() {
		System.out.print("\n----Enter labtest ID  To Delete Labtest --");
		int deleteid = scobj.nextInt();
		if (labTestService.delete(deleteid)) {
			myLogger.info("\n----Lab Test Delete----\n");
		} else {
			myLogger.info("\n----Lab Test  Not Delete----\n");
		}
	}

	public void update() {
		read();
		System.out.println("Enter  Drugs Id Which You Want to Update : ");
		int updateid = scobj.nextInt();
		System.out.print("\nLabTest Id----: " + updateid);
		scobj.nextLine();
		System.out.print("\nEnter LabTest Name  --: ");
		String name = scobj.nextLine().trim();
		System.out.print("\nEnter LabTest Price  --: ");
		int price = scobj.nextInt();
		if (labTestService.update(updateid, name, price)) {
			myLogger.info("\n-------Value Has Updated-------");
		} else {
			myLogger.info("\n-------Value Has Updated-------");
		}
	}

	public void read() {
		List<Labtest> list = labTestService.read();
		for (Labtest labtest : list) {
			System.out.println(labtest + " ");
		}
	}
}
