package org.pl.mscustomer.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF inválido")
    @NotNull(message = "CPF é obrigatório")
    private String cpf;

    @Column(nullable = false)
    @NotNull(message = "Nome é obrigatório")
    private String name;

    private String gender;

    @Column(nullable = true)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    @Email(message = "Email inválido")
    @NotNull(message = "Email é obrigatório")
    private String email;

    @Column
    private Long points;

    @Column(nullable = false)
    @NotNull(message = "URL da foto é obrigatória")
    private String urlPhoto;
}
