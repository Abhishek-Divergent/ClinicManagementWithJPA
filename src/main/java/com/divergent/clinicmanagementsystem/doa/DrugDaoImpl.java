package com.divergent.clinicmanagementsystem.doa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergent.clinicmanagementsystem.entity.Drugs;

@Repository
public class DrugDaoImpl implements DrugDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Drugs drugs) {
		em.persist(drugs);
	}

	@Override
	public List<Drugs> read() {
		CriteriaQuery<Drugs> criteriaQuery = em.getCriteriaBuilder().createQuery(Drugs.class);
		@SuppressWarnings("unused")
		Root<Drugs> root = criteriaQuery.from(Drugs.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public void delete(Drugs drugs) {
		em.remove(drugs);
	}

	@Override
	public void update(Drugs drugs) {
		em.persist(drugs);
	}

	@Override
	public Drugs findById(long id) {
		Drugs drugs = em.find(Drugs.class, id);
		return drugs;
	}

}
