package com.divergent.clinicmanagementsystem.doa;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Patient;

public interface PatientDoa {
	void create(Patient patient);

	List<Patient> read();

	void delete(Patient patient);

	void update(Patient patient);

	Patient findById(long id);

}
