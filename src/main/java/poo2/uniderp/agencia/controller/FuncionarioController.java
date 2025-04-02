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

import poo2.uniderp.agencia.pojo.Funcionario;
import poo2.uniderp.agencia.repository.IFuncionarioRepoJPA;
import poo2.uniderp.agencia.service.FuncionarioService;

@RestController
@RequestMapping("/api/agencia/recursoshumanos/funcionario")
public class FuncionarioController {
 
    private final IFuncionarioRepoJPA IFuncionarioRepoJPA;
    
    @Autowired
    private FuncionarioService servico;

    public FuncionarioController(FuncionarioService srv, IFuncionarioRepoJPA IFuncionarioRepoJPA){
        this.servico = srv;
        this.IFuncionarioRepoJPA = IFuncionarioRepoJPA;
    }

    @GetMapping
    public List<Funcionario> obterTodos(){
        return this.servico.browse();
    }

    @GetMapping("/{codigo}")
    public Funcionario obterPorId(@PathVariable Long codigo) {
        return this.servico.read(codigo);
    }

    @PostMapping
    public Funcionario inserir(@RequestBody Funcionario instancia) {
        return this.servico.add(instancia);
    }

    @PutMapping
    public Funcionario alterar(@RequestBody Funcionario instancia) {
        return this.servico.edit(instancia);
    }

    @DeleteMapping("/{codigo}")
    public Funcionario apagar(@PathVariable Long codigo){
        return this.servico.delete(codigo);
    }
}