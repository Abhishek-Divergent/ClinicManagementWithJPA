package com.divergent.clinicmanagementsystem.service;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Patient;

public interface PatientService {
	public void create(Patient patient);
	public List<Patient> read();

	boolean delete(long id);

	public Patient findById(long id);

	public boolean update(int updateid, String name, String gender, int age, int weight, String contact, String address);
}
