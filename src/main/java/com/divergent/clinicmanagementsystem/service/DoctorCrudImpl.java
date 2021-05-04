package com.divergent.clinicmanagementsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergent.clinicmanagementsystem.doa.DoctorDoa;
import com.divergent.clinicmanagementsystem.entity.Doctor;

@Service
public class DoctorCrudImpl implements DoctorCrudService {

	@Autowired
	DoctorDoa doctorDoa;

	@Transactional
	@Override
	public void create(Doctor doctor) {
		doctorDoa.create(doctor);
	}

	@Override
	public List<Doctor> read() {
		return doctorDoa.read();
	}

	@Transactional
	@Override
	public boolean delete(int deleteid) {
		Doctor doctor = findById(deleteid);
		if (doctor != null) {
			doctorDoa.delete(doctor);
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean update(int updateid, String name, String username, String password, String speciality,
			String contact, int fees) {
		Doctor doctor = findById(updateid);

		if (doctor != null) {
			doctor.setId(updateid);
			doctor.setFees(fees);
			doctor.setName(name);
			doctor.setUsername(username);
			doctor.setPassword(password);
			doctor.setSpeciality(speciality);
			doctor.setContact(contact);
			doctorDoa.update(doctor);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Doctor findById(long id) {
		return doctorDoa.findById(id);
	}

}
