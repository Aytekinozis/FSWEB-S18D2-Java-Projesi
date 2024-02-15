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
@Table(name = "vegetable",schema = "fsweb")
public class Vegetable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name")
    @NotNull
    @Size(min = 3,max = 45,message = "min 3 max 45 characters!")
    private String name;

    @Column(name = "price")
    @DecimalMin("10")
    private Double price;

    @Column(name = "is_grown_on_tree")
    private Boolean isGrownOnTree;
}
