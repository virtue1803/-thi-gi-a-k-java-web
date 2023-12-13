package dev.skyherobrine.giuaky_t4_t1315.repositories.impl;

import dev.skyherobrine.giuaky_t4_t1315.enums.Roles;
import dev.skyherobrine.giuaky_t4_t1315.models.Experience;
import dev.skyherobrine.giuaky_t4_t1315.repositories.IRepositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.management.Query;
import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

public class ExperienceRepository implements IRepositories<Experience> {
    private EntityManager em;
    private EntityTransaction transaction;
    public ExperienceRepository() {
        em = Persistence.createEntityManagerFactory("candidate").createEntityManager();
        transaction = em.getTransaction();
    }
    @Override
    public boolean insert(Experience experience) {
        try {
            transaction.begin();
            em.persist(experience);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(Experience experience) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Optional<Experience> findById(String id) {
        return Optional.of(em.find(Experience.class, id));
    }

    @Override
    public List<Experience> findAll() {
        return em.createNamedQuery("Experience.findAll", Experience.class).getResultList();
    }

    public List<Experience> findByRole(Roles role) {
        return em.createNamedQuery("Experience.findByRole", Experience.class).setParameter("role", role).getResultList();
    }
}
