package com.divergent.clinicmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "appoinment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "doctor_name")
	private String doctor_name;

	@Column(name = "patient_name")
	private String patient_name;

	@Column(name = "problem")
	private String problem;
	@Column(name = "date")
	private String date;
	@Column(name = "time")
	private String time;
	@Column(name = "patient_id")
	private long patient_id;
	@Column(name = "doctor_id")
	private long doctor_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public long getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}
	public long getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(long doctor_id) {
		this.doctor_id = doctor_id;
	}

	@Override
	public String toString() {
		return "Appointment [id =     " + id + "     , doctor_name=     " + doctor_name + "     , patient_name=     " + patient_name
				+ "     , problem=     " + problem + "     , date=     " + date + "     , time=     " + time + "     , patient_id=" + patient_id
				+ "     , doctor_id=     " + doctor_id + "     ]";
	}
	public Appointment() {
		super();
	}

	
}
