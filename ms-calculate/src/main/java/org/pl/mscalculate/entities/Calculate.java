package org.pl.mscalculate.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Calculate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(nullable = false, unique = true)
    private String category;

    @Column(nullable = false)
    private Integer parity;
}
