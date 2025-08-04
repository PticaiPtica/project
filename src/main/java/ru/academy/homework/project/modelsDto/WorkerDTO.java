package ru.academy.homework.project.modelsDto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.academy.homework.project.model.Position;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDTO {
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private String patronymic;

    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Pattern(regexp = "^\\+?[0-9\\-\\s()]{7,20}$")
    private String phone;

    @Email
    private String email;

    @PastOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate employmentDate;

    @DecimalMin("0.00")
    private BigDecimal salary;

    @NotNull
    private Long positionId;

    private String positionName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
}