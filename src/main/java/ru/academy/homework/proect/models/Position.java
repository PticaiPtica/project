package ru.academy.homework.proect.models;


import java.util.List;


public class Position {
    private Long id;
    private String type;
    private List<Worker> workers;

    public Position(Long id, String type, List<Worker> workers) {
        this.id = id;
        this.type = type;
        this.workers = workers;
    }

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

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
