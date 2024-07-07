package org.pl.mscustomer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDto {

    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF inválido")
    @NotNull(message = "CPF é obrigatório")
    private String cpf;

    @NotNull(message = "Nome é obrigatório")
    @Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
    private String name;

    private String gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @Email(message = "Email inválido")
    @NotNull(message = "Email é obrigatório")
    private String email;

    private Long points;

    @NotNull(message = "URL da foto é obrigatória")
    private String urlPhoto;



}
