package com.example.sistemalanchonete.repositories;

import com.example.sistemalanchonete.models.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {


    @Query("DELETE from Carrinho c where c.itens.id =: id")
    void deleteItens(@Param ("id") Long id);


}
