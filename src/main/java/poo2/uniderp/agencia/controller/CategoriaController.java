package poo2.uniderp.agencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poo2.uniderp.agencia.pojo.Categoria;
import poo2.uniderp.agencia.repository.ICategoriaRepoJPA;
import poo2.uniderp.agencia.service.CategoriaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/agencia/almoxarifado/categoria")
public class CategoriaController {

    private final ICategoriaRepoJPA ICategoriaRepoJPA;
    
    @Autowired
    private CategoriaService servico;

    public CategoriaController(CategoriaService srv, ICategoriaRepoJPA ICategoriaRepoJPA){
        this.servico = srv;
        this.ICategoriaRepoJPA = ICategoriaRepoJPA;
    }

    @GetMapping
    public List<Categoria> obterTodos(){
        return this.servico.browse();
    }

    @GetMapping("/{codigo}")
    public Categoria obterPorId(@PathVariable Long codigo) {
        return this.servico.read(codigo);
    }

    @PostMapping
    public Categoria inserir(@RequestBody Categoria instancia) {
        return this.servico.add(instancia);
    }

    @PutMapping
    public Categoria alterar(@RequestBody Categoria instancia) {
        return this.servico.edit(instancia);
    }

    @DeleteMapping("/{codigo}")
    public Categoria apagar(@PathVariable Long codigo){
        return this.servico.delete(codigo);
    }
}