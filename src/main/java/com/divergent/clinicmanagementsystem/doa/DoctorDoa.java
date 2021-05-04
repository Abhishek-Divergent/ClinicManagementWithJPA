package com.divergent.clinicmanagementsystem.doa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.divergent.clinicmanagementsystem.entity.Doctor;

@Repository
public interface DoctorDoa {
	void create(Doctor doctor);

	List<Doctor> read();

	void delete(Doctor doctor);

	void update(Doctor doctor);

	Doctor findById(long id);
}
