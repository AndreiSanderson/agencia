package poo2.uniderp.agencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poo2.uniderp.agencia.pojo.Colaborador;
import poo2.uniderp.agencia.repository.IColaboradorRepoJPA;
import poo2.uniderp.agencia.service.ColaboradorService;


@RestController
@RequestMapping("/api/agencia/recursoshumanos/colaborador")
public class ColaboradorController {
 
    private final IColaboradorRepoJPA IColaboradorRepoJPA;
    
    @Autowired
    private ColaboradorService servico;

    public ColaboradorController(ColaboradorService srv, IColaboradorRepoJPA IColaboradorRepoJPA){
        this.servico = srv;
        this.IColaboradorRepoJPA = IColaboradorRepoJPA;
    }

    @GetMapping
    public List<Colaborador> obterTodos(){
        return this.servico.browse();
    }

    @GetMapping("/{codigo}")
    public Colaborador obterPorId(@PathVariable Long codigo) {
        return this.servico.read(codigo);
    }

    @PostMapping
    public Colaborador inserir(@RequestBody Colaborador instancia) {
        return this.servico.add(instancia);
    }

    @PutMapping
    public Colaborador alterar(@RequestBody Colaborador instancia) {
        return this.servico.edit(instancia);
    }

    @DeleteMapping("/{codigo}")
    public Colaborador apagar(@PathVariable Long codigo){
        return this.servico.delete(codigo);
    }
}