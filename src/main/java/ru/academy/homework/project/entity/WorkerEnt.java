package ru.academy.homework.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;

@Entity
@Table(name = "workers", indexes = {
        @Index(name = "idx_worker_email", columnList = "email", unique = true),
        @Index(name = "idx_worker_position", columnList = "position_id")
})
public class WorkerEnt extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private String patronymic;

    @Past
    private LocalDate birthDate;

    @Pattern(regexp = "^\\+?[0-9\\-\\s()]{7,20}$")
    private String phone;

    @Email
    private String email;

    @PastOrPresent
    private LocalDate employmentDate;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", nullable = false)
    private PositionEnt position;


    // getters, setters, toString()

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public @Past LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@Past LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public @Pattern(regexp = "^\\+?[0-9\\-\\s()]{7,20}$") String getPhone() {
        return phone;
    }

    public void setPhone(@Pattern(regexp = "^\\+?[0-9\\-\\s()]{7,20}$") String phone) {
        this.phone = phone;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @PastOrPresent LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(@PastOrPresent LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public PositionEnt getPosition() {
        return position;
    }

    public void setPosition(PositionEnt position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "WorkerEnt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", employmentDate=" + employmentDate +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }
}
