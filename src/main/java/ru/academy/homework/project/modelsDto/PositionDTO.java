package ru.academy.homework.project.modelsDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDTO {
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String positionName;

    @DecimalMin("0.00")
    private BigDecimal minSalary;

    @DecimalMin("0.00")
    private BigDecimal maxSalary;

    private String duties;
    private String requirements;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
}