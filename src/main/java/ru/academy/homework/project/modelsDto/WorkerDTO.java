package ru.academy.homework.project.modelsDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDTO {
    private Long id;

    @NotBlank(message = "Имя обязательно для заполнения")
    @Size(max = 50, message = "Имя не должно превышать 50 символов")
    private String name;

    @NotBlank(message = "Фамилия обязательна для заполнения")
    @Size(max = 50, message = "Фамилия не должна превышать 50 символов")
    private String surname;

    @Size(max = 50, message = "Отчество не должно превышать 50 символов")
    private String patronymic;

    @Past(message = "Дата рождения должна быть в прошлом")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Pattern(regexp = "^\\+?[0-9\\-\\s()]{7,20}$",
            message = "Некорректный формат телефона")
    private String phone;

    @Email(message = "Некорректный формат email")
    @Size(max = 100, message = "Email не должен превышать 100 символов")
    private String email;

    @PastOrPresent(message = "Дата приема не может быть будущей")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate employmentDate;

    @DecimalMin(value = "0.00", message = "Зарплата не может быть отрицательной")
    @Digits(integer = 10, fraction = 2, message = "Некорректный формат зарплаты")
    private BigDecimal salary;

    @NotNull(message = "ID должности обязательно для заполнения")
    private Long positionId;

    private String positionName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    // Дополнительные методы при необходимости
    public String getFullName() {
        return String.format("%s %s %s", surname, name, patronymic).trim();
    }
}