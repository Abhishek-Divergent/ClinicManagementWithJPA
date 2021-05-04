package com.divergent.clinicmanagementsystem.doa;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Labtest;

public interface LabTestDoa {
	public void create(Labtest Labtest);

	public void update(Labtest Labtest);

	public List<Labtest> read();

	void delete(Labtest Labtest);

	Labtest findById(long id);

}
