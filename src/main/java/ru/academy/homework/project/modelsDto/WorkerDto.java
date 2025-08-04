package ru.academy.homework.project.modelsDto;


import ru.academy.homework.project.model.Position;

public class WorkerDto {

    private String name ;
    private String email;
    private Position position;

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
