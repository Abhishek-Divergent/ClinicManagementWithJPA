package com.divergent.clinicmanagementsystem;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagementsystem.service.AdminService;
import com.divergent.clinicmanagementsystem.service.DoctorService;
import com.divergent.clinicmanagementsystem.service.LoginService;

/**
 * This is menu class this will contain Menu Option of this Application
 * 
 * @author JAI MAHAKAL
 *
 */
@Component
public class MenuImpl implements Menu {
	private static final Logger myLogger = LoggerFactory.getLogger(MenuImpl.class.getName());
	private static Scanner scobj = new Scanner(System.in);
	@Autowired
	private AdminService adminService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private LoginService loginService;

	@Override
	public void menu() {
		while (true) {
			myLogger.info("**************Clinic Management System**************\n");
			System.out.println("Select Option\n");
			System.out.println("1. Admin : \n2. Doctor : \n3. Exit : ");
			int choice = 0;
			System.out.println("\nEnter Choice The Option----: ");
			choice = scobj.nextInt();
			admin: switch (choice) {
			case 1: {
				if (loginService.adminLogin()) {
					myLogger.info("\n------ Login Auccessfull ------ \n");
					adminService.adminPanel();
					break admin;
				} else {
					myLogger.warn(" \n------ Login Faild Try Again ------");
					myLogger.info("\n------ Press Y Then Enter Continue------ \n");
				}
				scobj.next().charAt(0);
				break;
			}
			case 2: {
				if (loginService.doctorLogin()) {
					myLogger.info("\n------ Login Auccessfull ------ \n");
					doctorService.doctorPanel();
					break admin;
				} else {
					myLogger.warn("Login Faild Try Again : ");
					myLogger.info("\n------Press Y Then Enter Continue------  \n");
				}
				scobj.next().charAt(0);
				break;
			}
			case 3:
				myLogger.info("\n------Thank you!  Application Has Shut Down Run Again ");
				System.exit(0);
			default:
				myLogger.warn("--- -Worng Choioce---- \n");
				continue;
			}
		}
	}

}
