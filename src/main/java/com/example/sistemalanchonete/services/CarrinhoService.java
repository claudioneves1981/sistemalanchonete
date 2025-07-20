package com.example.sistemalanchonete.services;

import com.example.sistemalanchonete.dto.PrecoDto;
import com.example.sistemalanchonete.models.Carrinho;
import com.example.sistemalanchonete.models.Item;
import com.example.sistemalanchonete.repositories.CarrinhoRepository;
import com.example.sistemalanchonete.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ItemRepository itemRepository;

    public PrecoDto calcularPreco(Long id){

        double valor = 0;
        Carrinho carrinho = carrinhoRepository.findById(id).get();
        List<Item> itens = carrinho.getItens();
        for(Item item : itens){

            valor += item.getPreco();

        }


        return new PrecoDto("R$ " + String.format(String.valueOf(valor), "%.2f"));


    }

    public void adicionarItem(Long id, Item item){

        List<Item> itens = new ArrayList<>();
        Optional<Carrinho> optCarrinho = carrinhoRepository.findById(id);
        Carrinho carrinho = new Carrinho();

        if(optCarrinho.isPresent()){
            carrinho = optCarrinho.get();
            itens = carrinho.getItens();
        }

        itens.add(item);
        carrinho.setItens(itens);
        carrinhoRepository.save(carrinho);


    }

    public void removerItem(Long id_carrinho, Long id_item){
        Carrinho carrinho = carrinhoRepository.findById(id_carrinho).get();
        Item item = itemRepository.findById(id_item).get();
        carrinho.getItens().remove(item);
        carrinhoRepository.save(carrinho);
    }





}
