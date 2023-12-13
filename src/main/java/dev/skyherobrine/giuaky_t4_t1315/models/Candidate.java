package dev.skyherobrine.giuaky_t4_t1315.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Candidate")
@NamedQueries({
        @NamedQuery(name = "Candidate.findById", query = "from Candidate c where c.id =: id"),
        @NamedQuery(name = "Candidate.findAll", query = "from Candidate"),
        @NamedQuery(name = "Candidate.findByEmail", query = "from Candidate c where c.email != null")
})
public class Candidate {
    @Id
    @Column(name = "can_id", nullable = false)
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(name = "full_name", length = 255, nullable = false)
    private String fullName;
    @Column(name = "email", length = 255)
    private String email;
    @Column(length = 15, nullable = false)
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidate")
    private List<Experience> experiences;

    public Candidate() {
    }

    public Candidate(String fullName, String email, String phone) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }
}
