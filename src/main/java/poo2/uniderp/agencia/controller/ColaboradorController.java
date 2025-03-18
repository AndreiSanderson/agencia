package poo2.uniderp.agencia.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poo2.uniderp.agencia.fakedb.ColaboradorFakeDB;
import poo2.uniderp.agencia.pojo.Colaborador;


@RestController
@RequestMapping("/api/agencia/recursoshumanos/colaborador")
public class ColaboradorController {
    private ColaboradorFakeDB fakedb;

    public ColaboradorController() {
        this.fakedb = new ColaboradorFakeDB();
    }

    @GetMapping()
    public ArrayList<Colaborador> get() {
        return this.fakedb.getInstancia();
    }

    @GetMapping("/{codigo}")
    public Colaborador obterPorId(@PathVariable Long codigo) {
        Colaborador unico = this.fakedb.obterPorID(codigo);
        return unico;
    }
    
    
    
}
