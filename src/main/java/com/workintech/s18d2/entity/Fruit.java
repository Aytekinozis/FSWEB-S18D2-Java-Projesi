package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "fsweb",name = "fruit")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    @NotNull
    @Size(min = 3,max = 45,message = "min 3 max 45 characters!")
    private String name;

    @Column(name = "price")
    @DecimalMin("5")
    private Double price;

    @Column(name = "fruit_type")
    @Enumerated(EnumType.STRING)
    @NotNull
    private FruitType FruitType;
}
