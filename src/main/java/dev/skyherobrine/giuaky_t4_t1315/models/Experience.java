package dev.skyherobrine.giuaky_t4_t1315.models;

import dev.skyherobrine.giuaky_t4_t1315.enums.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
@NamedQueries({
        @NamedQuery(name = "Experience.findById", query = "from Experience e where e.id =: id"),
        @NamedQuery(name = "Experience.findAll", query = "from Experience"),
        @NamedQuery(name = "Experience.findByRole", query = "from Experience e where e.role =: role")
})
public class Experience {
    @Id
    @Column(name = "exp_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "company_name", nullable = false, length = 120)
    private String companyName;
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;
    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role", nullable = false)
    private Roles role;
    @Column(name = "work_desc", length = 400, nullable = false)
    private String workDesc;
    @ManyToOne
    @JoinColumn(name = "can_id", nullable = false)
    private Candidate candidate;

    public Experience() {
    }

    public Experience(String companyName, LocalDate fromDate, LocalDate toDate, Roles role, String workDesc, Candidate candidate) {
        this.companyName = companyName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.role = role;
        this.workDesc = workDesc;
        this.candidate = candidate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
