package com.divergent.clinicmanagementsystem.service;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Drugs;

public interface DrugsService {
	void create(Drugs drugs);

	List<Drugs> read();

	boolean delete(int deleteid);

	boolean update(int updateid ,String name,String description);

	Drugs findById(long id);
}
