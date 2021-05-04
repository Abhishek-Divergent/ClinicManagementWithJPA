package com.divergent.clinicmanagementsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.divergent.clinicmanagementsystem.config.JavaConfig;

/**
 * Hello world!
 *
 */
public class ClinicManagementSystem {
	private static final Logger myLogger = LoggerFactory.getLogger(ClinicManagementSystem.class.getName());

	public static void main(String[] args) {
		myLogger.info("********** Clinic Management Start ***************");
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Menu menu = context.getBean(MenuImpl.class);
		menu.menu();
	}
}
