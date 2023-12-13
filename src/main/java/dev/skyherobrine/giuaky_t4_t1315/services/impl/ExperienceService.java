package dev.skyherobrine.giuaky_t4_t1315.services.impl;

import dev.skyherobrine.giuaky_t4_t1315.enums.Roles;
import dev.skyherobrine.giuaky_t4_t1315.models.Experience;
import dev.skyherobrine.giuaky_t4_t1315.repositories.impl.ExperienceRepository;
import dev.skyherobrine.giuaky_t4_t1315.services.IServices;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

public class ExperienceService implements IServices<Experience> {
    @Override
    public boolean insert(Experience experience) {
        return new ExperienceRepository().insert(experience);
    }

    @Override
    public boolean update(Experience experience) {
        return false;
    }

    @Override
    public boolean delete(Experience experience) {
        return false;
    }

    @Override
    public Optional<Experience> findById(String id) {
        return Optional.of(new ExperienceRepository().findById(id).get());
    }

    @Override
    public List<Experience> findAll() {
        return new ExperienceRepository().findAll();
    }

    public List<Experience> findByRole(Roles role) {
        return new ExperienceRepository().findByRole(role);
    }
}
