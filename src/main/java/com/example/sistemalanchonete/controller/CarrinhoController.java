package com.example.sistemalanchonete.controller;

import com.example.sistemalanchonete.dto.PrecoDto;
import com.example.sistemalanchonete.models.Carrinho;
import com.example.sistemalanchonete.models.Item;
import com.example.sistemalanchonete.repositories.CarrinhoRepository;
import com.example.sistemalanchonete.services.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping
    public ResponseEntity<Void> adicionarItem(@RequestBody Item item){

        List<Item> itens = new ArrayList<>();
        Carrinho carrinho = new Carrinho();
        itens.add(item);
        carrinho.setItens(itens);
        carrinhoRepository.save(carrinho);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> removerItem(@PathVariable Long codigo){
        carrinhoRepository.deleteItens(codigo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/preco/{codigo}")
    public ResponseEntity<PrecoDto> calcularPreco(@PathVariable Long codigo){
        return ResponseEntity.ok(carrinhoService.calcularPreco(codigo));
    }
}
