package org.pl.mscustomer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerResponseDto {


    private String cpf;

    private String name;

    private String gender;

    private LocalDate birthDate;

    private String email;

    private String url_photo;

}
