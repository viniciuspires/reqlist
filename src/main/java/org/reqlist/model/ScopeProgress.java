/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.reqlist.entity.view.ProjectProgress;

/**
 *
 * @author Vinicius
 */
public class ScopeProgress {
//    private Integer id;
//    private String titulo;
//    
//    private BigInteger horasPlanejadas;
//    private BigInteger horasRealizadas;
//    private BigInteger tarefas;
//    private BigInteger tarefasFinalizadas;
//    
//    private List<RequirementProgress> requisitos;
//
//    public ScopeProgress(Integer id, String titulo, List<ProjectProgress> andamentoProjetoList) {
//        this.id = id;
//        this.titulo = titulo;
//        this.requisitos = new ArrayList<>();
//        
//        for (ProjectProgress andamentoProjeto : andamentoProjetoList) {
//            if ( andamentoProjeto.getEscopoId() == this.id ) {
//                RequirementProgress requisito = new RequirementProgress(andamentoProjeto);
//                this.requisitos.add( requisito );
//            }
//        }
//        
//        this.horasPlanejadas = calculaTotalHorasPlanejadas();
//        this.horasRealizadas = calculaTotalHorasRealizadas();
//        this.tarefas = calculaTotalTarefas();
//        this.tarefasFinalizadas = calculaTotalTarefasFinalizadas();
//    }
//    
//    private BigInteger calculaTotalHorasPlanejadas(){
//        BigInteger total = new BigInteger("0");
//        
//        for (RequirementProgress requisito : requisitos) {
//            total = requisito.getHorasPlanejadas().add(total);
//        }
//        
//        return total;
//    }
//    private BigInteger calculaTotalHorasRealizadas(){
//        BigInteger total = new BigInteger("0");
//        
//        for (RequirementProgress requisito : requisitos) {
//            total = requisito.getHorasRealizadas().add(total);
//        }
//        
//        return total;
//    }
//    private BigInteger calculaTotalTarefas(){
//        BigInteger total = new BigInteger("0");
//        
//        for (RequirementProgress requisito : requisitos) {
//            total = requisito.getTarefas().add(total);
//        }
//        
//        return total;
//    }
//    private BigInteger calculaTotalTarefasFinalizadas(){
//        BigInteger total = new BigInteger("0");
//        
//        for (RequirementProgress requisito : requisitos) {
//            total = requisito.getTarefasFinalizadas().add(total);
//        }
//        
//        return total;
//    }
//    
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getTitulo() {
//        return titulo;
//    }
//
//    public void setTitulo(String titulo) {
//        this.titulo = titulo;
//    }
//
//    public List<RequirementProgress> getRequisitos() {
//        return requisitos;
//    }
//
//    public void setRequisitos(List<RequirementProgress> requisitos) {
//        this.requisitos = requisitos;
//    }
//
//    public BigInteger getHorasPlanejadas() {
//        return horasPlanejadas;
//    }
//
//    public void setHorasPlanejadas(BigInteger horasPlanejadas) {
//        this.horasPlanejadas = horasPlanejadas;
//    }
//
//    public BigInteger getHorasRealizadas() {
//        return horasRealizadas;
//    }
//
//    public void setHorasRealizadas(BigInteger horasRealizadas) {
//        this.horasRealizadas = horasRealizadas;
//    }
//
//    public BigInteger getTarefas() {
//        return tarefas;
//    }
//
//    public void setTarefas(BigInteger tarefas) {
//        this.tarefas = tarefas;
//    }
//
//    public BigInteger getTarefasFinalizadas() {
//        return tarefasFinalizadas;
//    }
//
//    public void setTarefasFinalizadas(BigInteger tarefasFinalizadas) {
//        this.tarefasFinalizadas = tarefasFinalizadas;
//    }
}
