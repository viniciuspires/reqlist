/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.model;

import java.math.BigInteger;

/**
 *
 * @author Vinicius
 */
public class AndamentoRequisito {
    private String titulo;
    
    private BigInteger horasPlanejadas;
    private BigInteger horasRealizadas;
    private BigInteger tarefas;
    private BigInteger tarefasFinalizadas;

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
