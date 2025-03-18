package poo2.uniderp.agencia.fakedb;

import java.util.ArrayList;

import poo2.uniderp.agencia.pojo.Colaborador;

public class ColaboradorFakeDB {
    
    private ArrayList <Colaborador> instancia;

    
    public ArrayList<Colaborador> getInstancia (){
        if(this.instancia == null){
            this.instancia = new ArrayList<>();
        }
        return instancia;
    }
        
    public ColaboradorFakeDB() {
        this.instancia = new ArrayList<>();
        this.preencherInstancia();
    }

    private void preencherInstancia(){
        this.instancia.add(new Colaborador(1L, "Leonardo", "12083167615"));
        this.instancia.add(new Colaborador(2L, "Andrei", "06978912345"));
        this.instancia.add(new Colaborador(3L, "João", "05440293164"));
        this.instancia.add(new Colaborador(4L, "Matheus Plinio", "01421356164"));
        this.instancia.add(new Colaborador(5L, "Fernando", "08492112032"));
    }

    public Colaborador obterPorID(Long id){
        for (Colaborador item : this.instancia) {
            if (item.getCodigo() == id) {
                return item;
            }
        }
        return null;
    }

}
