package ru.academy.homework.proect.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class PositionEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String type;


    @OneToMany(mappedBy = "positions")
    private List<WorkerEnt> workers;

    public PositionEnt(Long id, String type, List<WorkerEnt> workers) {
        this.id = id;
        this.type = type;
        this.workers = workers;
    }
    public PositionEnt() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<WorkerEnt> getWorkers() {
        return workers;
    }

    public void setWorkers(List<WorkerEnt> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return   type;
    }
}
