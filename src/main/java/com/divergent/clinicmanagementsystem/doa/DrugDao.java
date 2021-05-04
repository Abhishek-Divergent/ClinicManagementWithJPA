package com.divergent.clinicmanagementsystem.doa;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Drugs;

public interface DrugDao {
	void create(Drugs drugs);

	List<Drugs> read();

	void delete(Drugs drugs);

	void update(Drugs drugs);

	Drugs findById(long id);
}
