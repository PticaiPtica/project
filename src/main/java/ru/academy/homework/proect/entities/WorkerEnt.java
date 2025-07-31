package ru.academy.homework.proect.entities;

import jakarta.persistence.*;

import java.util.Comparator;

@Entity
public class WorkerEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "name")
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionEnt positions;

    public WorkerEnt(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public WorkerEnt() {
    }

    public WorkerEnt(String name, String email, PositionEnt positions) {
        this.name = name;
        this.email = email;
        this.positions = positions;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PositionEnt getPosition() {
        return positions;
    }

    public void setPosition(PositionEnt positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "WorkerEnt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", positions=" + positions +
                '}';
    }
    public static class WorkerEntComparator implements Comparator<WorkerEnt> {
        @Override
        public int compare(WorkerEnt o1, WorkerEnt o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
