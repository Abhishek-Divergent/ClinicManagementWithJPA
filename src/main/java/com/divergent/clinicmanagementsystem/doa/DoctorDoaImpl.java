package com.divergent.clinicmanagementsystem.doa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergent.clinicmanagementsystem.entity.Doctor;

/*
 * This is Doctor DOA class here We will perform all crud operation
 */
@Repository
public class DoctorDoaImpl implements DoctorDoa {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Doctor doctor) {
		em.persist(doctor);
	}

	@Override
	public List<Doctor> read() {
		CriteriaQuery<Doctor> criteriaQuery = em.getCriteriaBuilder().createQuery(Doctor.class);
		@SuppressWarnings("unused")
		Root<Doctor> root = criteriaQuery.from(Doctor.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public void delete(Doctor doctor) {
		em.remove(doctor);
	}

	@Override
	public void update(Doctor doctor) {
		em.persist(doctor);
	}

	@Override
	public Doctor findById(long id) {
		Doctor doctor = em.find(Doctor.class, id);
		return doctor;
	}

}
