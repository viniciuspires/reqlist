/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.model;

import java.math.BigInteger;
import java.util.Date;
import reqlist.entity.view.ComparacaoProjeto;

/**
 *
 * @author Vinicius
 */
public class PerformanceProjeto {
    private Integer id;
    private String nome;
    private Date data;
    private BigInteger horasPlanejadas;
    private BigInteger horasRealizadas;
    
    private Integer escopoId;

    public PerformanceProjeto(ComparacaoProjeto comparacaoProjeto) {
        this.id = comparacaoProjeto.getProjetoId();
        this.nome = comparacaoProjeto.getProjetoNome();
        this.data = comparacaoProjeto.getData();
        this.horasPlanejadas = comparacaoProjeto.getHorasPlanejadas();
        this.horasRealizadas = comparacaoProjeto.getHorasRealizadas();
        this.escopoId = comparacaoProjeto.getEscopoId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public Integer getEscopoId() {
        return escopoId;
    }

    public void setEscopoId(Integer escopoId) {
        this.escopoId = escopoId;
    }
}
