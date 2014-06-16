/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.entity.view;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "vw_comparacao_projeto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComparacaoProjeto.findAll", query = "SELECT c FROM ComparacaoProjeto c"),
    @NamedQuery(name = "ComparacaoProjeto.findByProjetoId", query = "SELECT c FROM ComparacaoProjeto c WHERE c.projetoId = :projetoId"),
    @NamedQuery(name = "ComparacaoProjeto.findByProjetoNome", query = "SELECT c FROM ComparacaoProjeto c WHERE c.projetoNome = :projetoNome"),
    @NamedQuery(name = "ComparacaoProjeto.findByEscopoId", query = "SELECT c FROM ComparacaoProjeto c WHERE c.escopoId = :escopoId"),
    @NamedQuery(name = "ComparacaoProjeto.findByEscopoTitulo", query = "SELECT c FROM ComparacaoProjeto c WHERE c.escopoTitulo = :escopoTitulo"),
    @NamedQuery(name = "ComparacaoProjeto.findByData", query = "SELECT c FROM ComparacaoProjeto c WHERE c.data = :data"),
    @NamedQuery(name = "ComparacaoProjeto.findByHorasPlanejadas", query = "SELECT c FROM ComparacaoProjeto c WHERE c.horasPlanejadas = :horasPlanejadas"),
    @NamedQuery(name = "ComparacaoProjeto.findByHorasRealizadas", query = "SELECT c FROM ComparacaoProjeto c WHERE c.horasRealizadas = :horasRealizadas")})
public class ComparacaoProjeto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projeto_id")
    @Id
    private int projetoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "projeto_nome")
    private String projetoNome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "escopo_id")
    private int escopoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "escopo_titulo")
    private String escopoTitulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "horas_planejadas")
    private BigInteger horasPlanejadas;
    @Column(name = "horas_realizadas")
    private BigInteger horasRealizadas;

    public ComparacaoProjeto() {
    }

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    public String getProjetoNome() {
        return projetoNome;
    }

    public void setProjetoNome(String projetoNome) {
        this.projetoNome = projetoNome;
    }

    public int getEscopoId() {
        return escopoId;
    }

    public void setEscopoId(int escopoId) {
        this.escopoId = escopoId;
    }

    public String getEscopoTitulo() {
        return escopoTitulo;
    }

    public void setEscopoTitulo(String escopoTitulo) {
        this.escopoTitulo = escopoTitulo;
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
    
}
