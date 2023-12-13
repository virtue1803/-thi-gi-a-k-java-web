package dev.skyherobrine.giuaky_t4_t1315.repositories.impl;

import dev.skyherobrine.giuaky_t4_t1315.models.Candidate;
import dev.skyherobrine.giuaky_t4_t1315.repositories.IRepositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class CandidateRepository implements IRepositories<Candidate> {
    private EntityManager em;
    private EntityTransaction transaction;
    public CandidateRepository() {
        em = Persistence.createEntityManagerFactory("candidate").createEntityManager();
        transaction = em.getTransaction();
    }
    @Override
    public boolean insert(Candidate candidate) {
        try {
            transaction.begin();
            em.persist(candidate);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Candidate candidate) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Optional<Candidate> findById(String id) {
        return Optional.of(em.find(Candidate.class, id));
    }

    @Override
    public List<Candidate> findAll() {
        return em.createNamedQuery("Candidate.findAll", Candidate.class).getResultList();
    }

    public List<Candidate> findCandidateWithUsingEmail() {
        return em.createNamedQuery("Candidate.findByEmail", Candidate.class).getResultList();
    }
}
