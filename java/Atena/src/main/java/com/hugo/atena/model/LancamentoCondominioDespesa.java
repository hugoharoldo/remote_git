/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.model;

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
@Table(name = "lancamento_condominio_despesa")
public class LancamentoCondominioDespesa implements Serializable {

    @Id
    @SequenceGenerator(name = "lcd_id", sequenceName = "seq_lancamento_despesas_id", allocationSize = 1)
    @GeneratedValue(generator = "lcd_id", strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "despesa_id", referencedColumnName = "id", nullable = false)
    private DespesaCompartilhada compartilhada;
    
    @Column(name = "lcd_valor_correspondente", precision = 2)
    private double valorCorrespondente;

    @ManyToOne
    @JoinColumn(name = "lancamento_id", referencedColumnName = "id", nullable = false)
    private LancamentoCondominio lancto;

    public LancamentoCondominioDespesa() {

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.getId();
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
        final LancamentoCondominioDespesa other = (LancamentoCondominioDespesa) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        return true;
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
     * @return the compartilhada
     */
    public DespesaCompartilhada getCompartilhada() {
        return compartilhada;
    }

    /**
     * @param compartilhada the compartilhada to set
     */
    public void setCompartilhada(DespesaCompartilhada compartilhada) {
        this.compartilhada = compartilhada;
    }

    /**
     * @return the valorCorrespondente
     */
    public double getValorCorrespondente() {
        return valorCorrespondente;
    }

    /**
     * @param valorCorrespondente the valorCorrespondente to set
     */
    public void setValorCorrespondente(double valorCorrespondente) {
        this.valorCorrespondente = valorCorrespondente;
    }

    /**
     * @return the lancto
     */
    public LancamentoCondominio getLancto() {
        return lancto;
    }

    /**
     * @param lancto the lancto to set
     */
    public void setLancto(LancamentoCondominio lancto) {
        this.lancto = lancto;
    }

}
