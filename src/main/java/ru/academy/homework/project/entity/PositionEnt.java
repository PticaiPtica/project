package ru.academy.homework.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "positions", indexes = {
        @Index(name = "idx_position_name", columnList = "positionName")
})
public class PositionEnt extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String positionName;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private BigDecimal minSalary;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private BigDecimal maxSalary;

    @Lob
    private String duties;

    @Lob
    private String requirements;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkerEnt> workers = new ArrayList<>();

    // getters, setters, toString()

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public BigDecimal getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public List<WorkerEnt> getWorkers() {
        return workers;
    }

    public void setWorkers(List<WorkerEnt> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "PositionEnt{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                ", duties='" + duties + '\'' +
                ", requirements='" + requirements + '\'' +
                ", workers=" + workers +
                '}';
    }
}
