package com.divergent.clinicmanagementsystem.doa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergent.clinicmanagementsystem.entity.Labtest;

@Repository
public class LabTestDoaImpl implements LabTestDoa {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Labtest labtest) {
		em.persist(labtest);
	}

	@Override
	public List<Labtest> read() {
		CriteriaQuery<Labtest> criteriaQuery = em.getCriteriaBuilder().createQuery(Labtest.class);
		@SuppressWarnings("unused")
		Root<Labtest> root = criteriaQuery.from(Labtest.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public void delete(Labtest labtest) {
		em.remove(labtest);

	}

	@Override
	public void update(Labtest labtest) {
		em.persist(labtest);

	}

	@Override
	public Labtest findById(long id) {
		Labtest labtest = em.find(Labtest.class, id);
		return labtest;
	}

}
