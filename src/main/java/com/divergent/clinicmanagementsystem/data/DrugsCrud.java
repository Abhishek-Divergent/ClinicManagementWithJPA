package com.divergent.clinicmanagementsystem.data;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagementsystem.entity.Drugs;
import com.divergent.clinicmanagementsystem.service.DrugsService;

@Component
public class DrugsCrud {
	private static final Logger myLogger = LoggerFactory.getLogger(DrugsCrud.class.getName());
	private Scanner scobj = new Scanner(System.in);
	@Autowired
	private DrugsService drugsService;

	public void drugsPanel() {
		p_panel: while (true) {
			myLogger.info("\n************************Drugs CRUD************************\n");
			System.out.println("1: Drugs Create : ");
			System.out.println("2: Drugs Read : ");
			System.out.println("3: Drugs Update : ");
			System.out.println("4: Drugs Delete : ");
			System.out.println("5: Exit \n");
			System.out.print("\nEnter Choice The Option----: ");
			int choice = scobj.nextInt();
			switch (choice) {
			case 1:
				myLogger.info("Drugd Create : ");
				create();
				break;
			case 2:
				myLogger.info("Drugd Read : ");
				read();
				break;
			case 3:
				myLogger.info("Drugd Update : ");
				update();
				break;
			case 4:
				myLogger.info("Drugd Delete : ");
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
		System.out.print("\nEnter Drug Name  -- : ");
		String name = scobj.nextLine().trim();
		System.out.print("\nEnter  Drugs_description  -- : ");
		String description = scobj.nextLine().trim();
		Drugs drugs = new Drugs();
		drugs.setName(name);
		drugs.setDescription(description);
		try {
			drugsService.create(drugs);
			myLogger.info("\n-------Data Has  Inserted-------");
		} catch (Exception e) {
			myLogger.error(e.getMessage());
			myLogger.warn(e.getMessage());
			myLogger.info("\n-------Data Has Not Inserted-------");
		}

	}

	public void delete() {
		System.out.print("\n----Enter Drug ID  To Delete Drug -- : ");
		int deleteid = scobj.nextInt();
		if (drugsService.delete(deleteid)) {
			myLogger.info("\n---- Drug Delete----\n");
		} else {
			myLogger.info("\n---- Drug Not Delete----\n");
		}
	}

	public void update() {
		read();
		System.out.print("\n----Enter DrugsID Which You Want to UPDATE ----:");
		int updateid = scobj.nextInt();
		scobj.nextLine();
		System.out.print("\nDrug Id Is ---- :" + updateid + " :---- ");
		System.out.print("\nEnter Drug Name  -- : ");
		String name = scobj.nextLine().trim();
		System.out.print("\nEnter  Drugs_description  -- : ");
		String description = scobj.nextLine().trim();
		if (drugsService.update(updateid, name, description)) {
			myLogger.info("\n-------Value Has Updated------- : ");
		} else {
			myLogger.info("\n-------Value Has Updated------- : ");
		}
	}

	public void read() {
		List<Drugs> list = drugsService.read();
		for (Drugs drugs : list) {
			System.out.println(drugs);
		}

	}
}
