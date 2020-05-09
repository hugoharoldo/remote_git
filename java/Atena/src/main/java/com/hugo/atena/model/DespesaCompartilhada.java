/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.model;

import com.hugo.atena.controler.enums.TipoDespesa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author hugo
 */
@Entity
@Table(name = "despesa_compartilhada")
public class DespesaCompartilhada implements Serializable, Cloneable {
    
    @Id
    @SequenceGenerator(name = "dsc_id", sequenceName = "seq_despesa_compartilhada_id", allocationSize = 1)
    @GeneratedValue(generator = "dsc_id", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "dsc_descricao", nullable = false)
    private String descricao;
    @ManyToOne()
    @JoinColumn(name = "dsc_competencia", referencedColumnName = "id", nullable = false)
    private Competencia competencia;
    @Column(name = "dsc_parcelas", nullable = false)
    private int parcelas;
    @Column(name = "dsc_tipo", nullable = false)
    private int tipoDespesa;
    @Column(name = "dsc_valor", nullable = false)
    private double valor;
    
    public DespesaCompartilhada() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the competencia
     */
    public Competencia getCompetencia() {
        return competencia;
    }

    /**
     * @param competencia the competencia to set
     */
    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    /**
     * @return the parcelas
     */
    public int getParcelas() {
        return parcelas;
    }

    /**
     * @param parcelas the parcelas to set
     */
    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    /**
     * @return the tipoDespesa
     */
    public int getTipoDespesa() {
        return tipoDespesa;
    }

    /**
     * @param tipoDespesa the tipoDespesa to set
     */
    public void setTipoDespesa(int tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DespesaCompartilhada other = (DespesaCompartilhada) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public TipoDespesa getTipoDespesaa() {

        return TipoDespesa.get(getTipoDespesa());

    }

    public void setTipoDespesaa(TipoDespesa despesa) {

        setTipoDespesa(despesa.getTipo());

    }

    @Override
    public DespesaCompartilhada clone() throws CloneNotSupportedException {
        return (DespesaCompartilhada) super.clone();
    }
}
