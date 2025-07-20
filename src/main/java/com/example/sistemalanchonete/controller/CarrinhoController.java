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
import java.util.Optional;


@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("{carrinho}")
    public ResponseEntity<Void> adicionarItem(@PathVariable Long carrinho, @RequestBody Item item){
        carrinhoService.adicionarItem(carrinho,item);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{carrinho}/item/{item}")
    public ResponseEntity<Void> removerItem(@PathVariable Long carrinho, @PathVariable Long item){
        carrinhoService.removerItem(carrinho, item);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{carrinho}/preco")
    public ResponseEntity<PrecoDto> calcularPreco(@PathVariable Long carrinho){
        return ResponseEntity.ok(carrinhoService.calcularPreco(carrinho));
    }
}
