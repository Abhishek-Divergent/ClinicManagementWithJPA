package com.divergent.clinicmanagementsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergent.clinicmanagementsystem.doa.AppointmentDoa;
import com.divergent.clinicmanagementsystem.entity.Appointment;

/**
 * in this is class admin will appoint a doctor to patient
 * 
 * @author JAI MAHAKAL
 *
 */
@Service
public class AppointmentImpl implements AppointmentService {
	@Autowired
	AppointmentDoa appointmentDoa;

	@Transactional
	@Override
	public void create(Appointment appointment) {
		appointmentDoa.create(appointment);
	}

	@Override
	public List<Appointment> read() {
		return appointmentDoa.read();
	}

	@Transactional
	@Override
	public boolean remove(int deleteid) {
		Appointment appointment = findById(deleteid);
		if (appointment != null) {
			appointmentDoa.remove(appointment);
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean update(int updateid, int doctor_id, int patient_id, String doctor_name, String patient_name,
			String problem, String date, String time) {
		Appointment appointment = findById(updateid);
		if (appointment != null) {
			appointment.setId(updateid);
			appointment.setDoctor_id(doctor_id);
			appointment.setPatient_id(patient_id);
			appointment.setDoctor_name(doctor_name);
			appointment.setPatient_name(patient_name);
			appointment.setTime(time);
			appointment.setProblem(problem);
			appointment.setDate(date);
			appointmentDoa.update(appointment);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Appointment findById(long id) {
		return appointmentDoa.findById(id);
	}

}
