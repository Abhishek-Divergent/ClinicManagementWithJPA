package com.divergent.clinicmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "priscription")
public class Priscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = " priscription")
	private String priscription;
	@Column(name = "note")
	private String note;
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

	public String getPriscription() {
		return priscription;
	}

	public void setPriscription(String priscription) {
		this.priscription = priscription;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public Priscription() {
		super();
	}

	@Override
	public String toString() {
		return "Priscription [     id=     " + id + "     , priscription=     " + priscription + "     , note=     " + note + "     , patient_id=     "
				+ patient_id + "     , doctor_id=     " + doctor_id + "     ]";
	}
	

}
