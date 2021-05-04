package com.divergent.clinicmanagementsystem.doa;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Appointment;

public interface AppointmentDoa {
	void create(Appointment appointment);

	List<Appointment> read();
	
	void remove(Appointment appointment);
	
	void update(Appointment appointment);

	Appointment findById(Long id);
}
