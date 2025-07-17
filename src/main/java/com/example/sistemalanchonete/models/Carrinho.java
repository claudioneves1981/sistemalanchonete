package com.example.sistemalanchonete.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Carrinho {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CARRINHO")
    private Long id;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinTable(
             name="TB_ITEM_CARRINHO",
             joinColumns = @JoinColumn(name = "ID_CARRINHO", referencedColumnName = "ID_CARRINHO"),
             inverseJoinColumns = @JoinColumn(name = "ID_ITEM",referencedColumnName = "ID_ITEM")
     )
    private List<Item> itens;

    public Carrinho(){
        itens = new ArrayList<>();
    }

}
