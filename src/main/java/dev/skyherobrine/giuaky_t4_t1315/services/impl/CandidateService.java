package dev.skyherobrine.giuaky_t4_t1315.services.impl;

import dev.skyherobrine.giuaky_t4_t1315.models.Candidate;
import dev.skyherobrine.giuaky_t4_t1315.repositories.impl.CandidateRepository;
import dev.skyherobrine.giuaky_t4_t1315.services.IServices;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class CandidateService implements IServices<Candidate> {
    @Override
    public boolean insert(Candidate candidate) {
        return new CandidateRepository().insert(candidate);
    }

    @Override
    public boolean update(Candidate candidate) {
        return false;
    }

    @Override
    public boolean delete(Candidate candidate) {
        return false;
    }

    @Override
    public Optional<Candidate> findById(String id) {
        return Optional.of(new CandidateRepository().findById(id).get());
    }

    @Override
    public List<Candidate> findAll() {
        return new CandidateRepository().findAll();
    }

    public List<Candidate> findCandidateUsingMail() {
        return new CandidateRepository().findCandidateWithUsingEmail();
    }

    public String getDataRowsTable() {
        List<Candidate> candidates = findAll();
        String dataRows = "";
        for(Candidate candidate : candidates) {
            dataRows += ("<tr><td>"+candidate.getId()+"</td><td>"+candidate.getFullName()+"</td><td>"+candidate.getEmail()+"</td><td>"
                    +candidate.getPhone()+"</td><td><form action='pas' method='post'><input type='submit' name='action' value='View Detail "+candidate.getId()+"'></form></td></tr>");
        }
        return dataRows;
    }

    public String getDataRowsTableWithUsingMail(){
        List<Candidate> candidates = findCandidateUsingMail();
        String dataRows = "";
        for(Candidate candidate : candidates) {
            dataRows += "<tr><td>"+candidate.getId()+"</td><td>"+candidate.getFullName()+"</td><td>"+candidate.getEmail()+"</td><td>"+candidate.getPhone()+"</td></tr>";
        }
        return dataRows;
    }
}
