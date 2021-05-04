package com.divergent.clinicmanagementsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergent.clinicmanagementsystem.doa.DrugDao;
import com.divergent.clinicmanagementsystem.entity.Drugs;

@Service
public class DrugsImpl implements DrugsService {

	@Autowired
	private DrugDao drugDao;

	@Transactional
	@Override
	public void create(Drugs drugs) {
		drugDao.create(drugs);
	}

	@Override
	public List<Drugs> read() {
		return drugDao.read();
	}

	@Transactional
	@Override
	public boolean delete(int deleteid) {
		Drugs drugs = findById(deleteid);
		if (drugs != null) {
			drugDao.delete(drugs);
			return true;
		} else {
			return false;
		}

	}

	@Transactional
	@Override
	public boolean update(int updateid, String name, String description) {
		Drugs drugs = findById(updateid);
		if (drugs != null) {
			drugs.setId(updateid);
			drugs.setName(name);
			drugs.setDescription(description);
			drugDao.update(drugs);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Drugs findById(long id) {
		return drugDao.findById(id);
	}

}