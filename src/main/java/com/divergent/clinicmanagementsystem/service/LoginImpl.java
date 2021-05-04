package com.divergent.clinicmanagementsystem.service;

import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergent.clinicmanagementsystem.doa.ApplicationDao;

@Service
public class LoginImpl implements LoginService {
	private static final Logger myLogger = LoggerFactory.getLogger(LoginImpl.class.getName());
	private Scanner scobj = new Scanner(System.in);
	@Autowired
	DoctorService doctorService;
	@Autowired
	ApplicationDao applicationDao;

	@Override
	@Transactional
	public boolean adminLogin() {
		myLogger.info("\n************************ADMIN  LOGIN PANEL************************\n");
		System.out.println("\nEnter Admin User Name  ");
		String username = scobj.nextLine().trim();
		System.out.println("\nEnter Admin Password   ");
		String password = scobj.nextLine().trim();
		if (password.equals(applicationDao.adminLogin(username))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean doctorLogin() {
		myLogger.info("\n************************DOCTOR LOGIN PANEL************************\n");
		System.out.print("\nEnter Doctor Id :");
		Long id=scobj.nextLong();
		scobj.nextLine();
		System.out.print("\nEnter Doctor User Name :");
		String username = scobj.nextLine().trim();
		System.out.print("\nEnter Doctor Password :");
		String password = scobj.nextLine().trim();
		List<String> list =applicationDao.doctorLogin(id);
	
		if(username.equals( list.get(0))&& password.equals(list.get(1)) ) {
			doctorService.setDoctortid(id);
			return true;
		}else {
			return false;
		}
}
}