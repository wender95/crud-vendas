package br.com.wender.relatorio.controller;

import br.com.wender.relatorio.model.Venda;
import br.com.wender.relatorio.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping("/")
    public String teste(){
        return "teste";
    }

    @GetMapping("/relatorio")
    public List relatorio(){
        return (List<Venda>) vendaRepository.findAll();
    }

    @PostMapping("/novavenda")
    @ResponseStatus(HttpStatus.CREATED)
    public Venda novavenda(@RequestBody Venda venda){
        venda.setData(LocalDateTime.now());
        vendaRepository.save(venda);
        return venda;
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Venda> atualizar(@PathVariable Integer id, @RequestBody Venda venda){
        Venda vendaAtualizada = vendaRepository.findById(id).orElseThrow();
        vendaAtualizada.setProduto(venda.getProduto());
        vendaAtualizada.setVendedor(venda.getVendedor());
        vendaAtualizada.setQuantidade(venda.getQuantidade());
        vendaAtualizada.setValorUnitario(venda.getValorUnitario());
        vendaAtualizada.setValorTotal(venda.getValorTotal());
        vendaRepository.save(vendaAtualizada);
        return ResponseEntity.ok(vendaAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Integer id){
        vendaRepository.deleteById(id);
    }


}
