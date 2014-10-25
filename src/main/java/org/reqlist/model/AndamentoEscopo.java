/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.reqlist.entity.view.AndamentoProjeto;

/**
 *
 * @author Vinicius
 */
public class AndamentoEscopo {
    private Integer id;
    private String titulo;
    
    private BigInteger horasPlanejadas;
    private BigInteger horasRealizadas;
    private BigInteger tarefas;
    private BigInteger tarefasFinalizadas;
    
    private List<AndamentoRequisito> requisitos;

    public AndamentoEscopo(Integer id, String titulo, List<AndamentoProjeto> andamentoProjetoList) {
        this.id = id;
        this.titulo = titulo;
        this.requisitos = new ArrayList<>();
        
        for (AndamentoProjeto andamentoProjeto : andamentoProjetoList) {
            if ( andamentoProjeto.getEscopoId() == this.id ) {
                AndamentoRequisito requisito = new AndamentoRequisito(andamentoProjeto);
                this.requisitos.add( requisito );
            }
        }
        
        this.horasPlanejadas = calculaTotalHorasPlanejadas();
        this.horasRealizadas = calculaTotalHorasRealizadas();
        this.tarefas = calculaTotalTarefas();
        this.tarefasFinalizadas = calculaTotalTarefasFinalizadas();
    }
    
    private BigInteger calculaTotalHorasPlanejadas(){
        BigInteger total = new BigInteger("0");
        
        for (AndamentoRequisito requisito : requisitos) {
            total = requisito.getHorasPlanejadas().add(total);
        }
        
        return total;
    }
    private BigInteger calculaTotalHorasRealizadas(){
        BigInteger total = new BigInteger("0");
        
        for (AndamentoRequisito requisito : requisitos) {
            total = requisito.getHorasRealizadas().add(total);
        }
        
        return total;
    }
    private BigInteger calculaTotalTarefas(){
        BigInteger total = new BigInteger("0");
        
        for (AndamentoRequisito requisito : requisitos) {
            total = requisito.getTarefas().add(total);
        }
        
        return total;
    }
    private BigInteger calculaTotalTarefasFinalizadas(){
        BigInteger total = new BigInteger("0");
        
        for (AndamentoRequisito requisito : requisitos) {
            total = requisito.getTarefasFinalizadas().add(total);
        }
        
        return total;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigInteger getHorasPlanejadas() {
        return horasPlanejadas;
    }

    public void setHorasPlanejadas(BigInteger horasPlanejadas) {
        this.horasPlanejadas = horasPlanejadas;
    }

    public BigInteger getHorasRealizadas() {
        return horasRealizadas;
    }

    public void setHorasRealizadas(BigInteger horasRealizadas) {
        this.horasRealizadas = horasRealizadas;
    }

    public BigInteger getTarefas() {
        return tarefas;
    }

    public void setTarefas(BigInteger tarefas) {
        this.tarefas = tarefas;
    }

    public BigInteger getTarefasFinalizadas() {
        return tarefasFinalizadas;
    }

    public void setTarefasFinalizadas(BigInteger tarefasFinalizadas) {
        this.tarefasFinalizadas = tarefasFinalizadas;
    }
}
