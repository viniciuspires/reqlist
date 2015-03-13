/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.model;

import java.math.BigInteger;
import org.reqlist.entity.view.ProjectProgress;

/**
 *
 * @author Vinicius
 */
public class RequirementProgress {
    private Integer id;
    private String titulo;
    
    private BigInteger horasPlanejadas;
    private BigInteger horasRealizadas;
    private BigInteger tarefas;
    private BigInteger tarefasFinalizadas;
    
    public RequirementProgress(ProjectProgress andamentoProjeto) {
        this.id = andamentoProjeto.getRequisitoId();
        this.titulo = andamentoProjeto.getRequisitoTitulo();
        this.tarefas =  BigInteger.valueOf( andamentoProjeto.getTarefas() );
        this.tarefasFinalizadas = andamentoProjeto.getTarefasRealizadas();
        this.horasPlanejadas = andamentoProjeto.getHorasPlanejadas();
        this.horasRealizadas = andamentoProjeto.getHorasRealizadas();
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
