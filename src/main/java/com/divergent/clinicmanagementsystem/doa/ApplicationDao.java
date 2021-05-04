package com.divergent.clinicmanagementsystem.doa;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Appointment;
import com.divergent.clinicmanagementsystem.entity.Priscription;

public interface ApplicationDao {

	public String adminLogin(String username);

	public List<String> doctorLogin(Long id);

	void createPriscription(Priscription priscription);

	int findIdByUsername();

	List<Appointment> readPatientList();

}
