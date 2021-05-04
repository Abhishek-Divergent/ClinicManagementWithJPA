package com.divergent.clinicmanagementsystem.service;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Labtest;

public interface LabTestService {
	public void create(Labtest Labtest);

	public boolean update(int updateid,String name,int price);

	public List<Labtest> read();

	public boolean delete(int deleteid);

	public Labtest findById(long id);
}
