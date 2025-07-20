package com.example.sistemalanchonete.repositories;

import com.example.sistemalanchonete.models.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    //@Query("DELETE from Carrinho c where c.id =: carrinho and Item.id =: item")
    //void deleteItens(@Param("carrinho") Long carrinho , @Param ("item") Long item);


}
