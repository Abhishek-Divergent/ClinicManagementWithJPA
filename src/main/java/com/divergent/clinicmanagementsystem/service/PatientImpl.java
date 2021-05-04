package com.divergent.clinicmanagementsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergent.clinicmanagementsystem.doa.PatientDoa;
import com.divergent.clinicmanagementsystem.entity.Patient;

@Service
public class PatientImpl implements PatientService {
	@Autowired
	PatientDoa patientDoa;

	@Transactional
	public void create(Patient patient) {
		patientDoa.create(patient);
	}

	public List<Patient> read() {
		return patientDoa.read();
	}

	@Transactional
	public boolean delete(long Id) {
		Patient patient = findById(Id);
		if (patient != null) {
			patientDoa.delete(patient);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Patient findById(long id) {
		return patientDoa.findById(id);
	}

	@Transactional
	@Override
	public boolean update(int updateid, String name, String gender, int age, int weight, String contact,
			String address) {
		Patient patient = findById(updateid);
		if (patient != null) {
			patient.setId(updateid);
			patient.setName(name);
			patient.setGender(gender);
			patient.setContact(contact);
			patient.setAge(age);
			patient.setWeight(weight);
			patient.setAddress(address);
			patientDoa.update(patient);
			return true;
		} else {
			return false;
		}

	}
}
