package com.divergent.clinicmanagementsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergent.clinicmanagementsystem.doa.LabTestDoa;
import com.divergent.clinicmanagementsystem.entity.Labtest;

@Service
public class LabTestImpl implements LabTestService {
	@Autowired
	private LabTestDoa labTestDoa;

	@Transactional
	@Override
	public void create(Labtest Labtest) {
		labTestDoa.create(Labtest);
	}

	@Transactional
	@Override
	public boolean update(int updateid, String name, int price) {
		Labtest labtest = findById(updateid);
		if (labtest != null) {
			labtest.setId(updateid);
			labtest.setName(name);
			labtest.setPrice(price);
			labTestDoa.update(labtest);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Labtest> read() {
		return labTestDoa.read();
	}

	@Transactional
	@Override
	public boolean delete(int deleteid) {
		Labtest labtest = findById(deleteid);
		if (labtest != null) {
			labTestDoa.delete(labtest);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Labtest findById(long id) {
		return labTestDoa.findById(id);
	}

}
