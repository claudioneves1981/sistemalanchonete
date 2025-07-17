package com.example.sistemalanchonete.services;

import com.example.sistemalanchonete.dto.PrecoDto;
import com.example.sistemalanchonete.models.Carrinho;
import com.example.sistemalanchonete.models.Item;
import com.example.sistemalanchonete.repositories.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public PrecoDto calcularPreco(Long id){

        double valor = 0;
        Carrinho carrinho = carrinhoRepository.findById(id).get();
        List<Item> itens = carrinho.getItens();
        for(Item item : itens){

            valor += item.getPreco();

        }


        return new PrecoDto("R$ " + String.format(String.valueOf(valor), "%.2f"));


    }





}
