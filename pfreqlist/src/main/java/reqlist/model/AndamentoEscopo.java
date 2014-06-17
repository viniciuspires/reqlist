/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import reqlist.entity.view.AndamentoProjeto;

/**
 *
 * @author Vinicius
 */
public class AndamentoEscopo {
    private String titulo;
    private Integer horasPlanejadas;
    private Integer horasRealizadas;
    private Integer tarefas;
    private Integer tarefasFinalizadas;
    
    private List<AndamentoRequisito> requisitos;

    public AndamentoEscopo(List<AndamentoProjeto> andamentoProjetoList) {
        this.titulo = andamentoProjetoList.get(0).getEscopoTitulo();
        
        this.requisitos = new ArrayList<AndamentoRequisito>();
        for (AndamentoProjeto andamentoProjeto : andamentoProjetoList) {
            AndamentoRequisito requisito = new AndamentoRequisito();
            requisito.setTitulo(andamentoProjeto.getRequisitoTitulo());
            requisito.setTarefas( BigInteger.valueOf( andamentoProjeto.getTarefas() ) );
            requisito.setTarefasFinalizadas( andamentoProjeto.getTarefasRealizadas() );
            requisito.setHorasPlanejadas( andamentoProjeto.getHorasPlanejadas() );
            requisito.setHorasRealizadas( andamentoProjeto.getHorasRealizadas() );
            
            this.requisitos.add(requisito);
        }
        
        // TODO Inicializar contagem do escopo
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<AndamentoRequisito> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(List<AndamentoRequisito> requisitos) {
        this.requisitos = requisitos;
    }

    public Integer getHorasPlanejadas() {
        return horasPlanejadas;
    }

    public void setHorasPlanejadas(Integer horasPlanejadas) {
        this.horasPlanejadas = horasPlanejadas;
    }

    public Integer getHorasRealizadas() {
        return horasRealizadas;
    }

    public void setHorasRealizadas(Integer horasRealizadas) {
        this.horasRealizadas = horasRealizadas;
    }

    public Integer getTarefas() {
        return tarefas;
    }

    public void setTarefas(Integer tarefas) {
        this.tarefas = tarefas;
    }

    public Integer getTarefasFinalizadas() {
        return tarefasFinalizadas;
    }

    public void setTarefasFinalizadas(Integer tarefasFinalizadas) {
        this.tarefasFinalizadas = tarefasFinalizadas;
    }
}
