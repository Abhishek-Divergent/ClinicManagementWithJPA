package com.divergent.clinicmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`drugs`")
public class Drugs {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private long id;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Drugs() {
		super();
	}

	@Override
	public String toString() {
		return "Drugs [     id=     " + id + "     , name=     " + name + "     , description=     " + description + "     ]";
	}

}
