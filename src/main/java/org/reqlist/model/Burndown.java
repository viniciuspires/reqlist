/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.reqlist.entity.view.DataFinalizacao;

/**
 *
 * @author Vinicius
 */
public final class Burndown {
//    private Integer totalTarefas;
//
//    private List<DataFinalizacao> planejamento;
//    private List<DataFinalizacao> realizacao;
//    private List<DataFinalizacao> estimativa;
//
//    public Burndown(List<DataFinalizacao> planejamento, List<DataFinalizacao> realizacao) {
//        this.planejamento = planejamento;
//        this.realizacao = realizacao;
//        getEstimativa();
//    }
//
//    public List<DataFinalizacao> getPlanejamento() {
//        return planejamento;
//    }
//
//    public void setPlanejamento(List<DataFinalizacao> planejamento) {
//        this.planejamento = planejamento;
//    }
//
//    public List<DataFinalizacao> getRealizacao() {
//        return realizacao;
//    }
//
//    public void setRealizacao(List<DataFinalizacao> realizacao) {
//        this.realizacao = realizacao;
//    }
//
//    public List<DataFinalizacao> getEstimativa() {
//        if (estimativa == null) {
//            estimativa = makeEstimativa();
//        }
//        return estimativa;
//    }
//
//    public void setEstimativa(List<DataFinalizacao> estimativa) {
//        this.estimativa = estimativa;
//    }
//    
//    public Integer getTotalTarefas() {
//        if ( totalTarefas == null ) {
//            totalTarefas = 0;
//            for (DataFinalizacao dataFinalizacao : planejamento) {
//                totalTarefas += dataFinalizacao.getTarefasConcluidas();
//            }
//        }
//        return totalTarefas;
//    }
//
//    public void setTotalTarefas(Integer totalTarefas) {
//        this.totalTarefas = totalTarefas;
//    }
//    
//    private List<DataFinalizacao> makeEstimativa(){
//        float media = mediaTarefasPorDia();
//        Calendar inicio = Calendar.getInstance();
//        inicio.setTime( planejamento.get(0).getFinalizacao() );
//        
//        int tarefasRestantes = getTotalTarefas();
//        
//        List<DataFinalizacao> estimativaList = new ArrayList<>();
//        while ( tarefasRestantes > 0 ) {
//            DataFinalizacao item = new DataFinalizacao();
//            
//            tarefasRestantes = Math.round( tarefasRestantes - media );
//            
//            item.setTarefasConcluidas( Math.round( media ) );
//            
//            inicio.add(Calendar.DAY_OF_MONTH, 1);
//            item.setFinalizacao( inicio.getTime() );
//            
//            estimativaList.add(item);
//        }
//        
//        return estimativaList;
//    }
//    
//    private float mediaTarefasPorDia() {
//        int total = this.getTotalTarefas();
//        return total / planejamento.size();
//    }
}
