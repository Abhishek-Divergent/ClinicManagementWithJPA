package com.divergent.clinicmanagementsystem.doa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.divergent.clinicmanagementsystem.entity.Admin;
import com.divergent.clinicmanagementsystem.entity.Appointment;
import com.divergent.clinicmanagementsystem.entity.Doctor;
import com.divergent.clinicmanagementsystem.entity.Priscription;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public String adminLogin(String username) {
		Admin admin = em.find(Admin.class, username);
		return admin.getPassword();
	}

	@Override
	public List<String> doctorLogin(Long i) {
		Doctor doctor=em.find(Doctor.class, i);
      List<String> list=new ArrayList<String>();
        list.add(doctor.getUsername());
	   	list.add(doctor.getPassword());
        return list;
	}
   @Transactional
	@Override
	public void createPriscription(Priscription priscription) {
		em.persist(priscription);
	}

	@Override
	public int findIdByUsername() {

		return 0;
	}

	@Override
	public List<Appointment> readPatientList() {
		CriteriaQuery<Appointment> criteriaQuery = em.getCriteriaBuilder().createQuery(Appointment.class);
		@SuppressWarnings("unused")
		Root<Appointment> root = criteriaQuery.from(Appointment.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

}
