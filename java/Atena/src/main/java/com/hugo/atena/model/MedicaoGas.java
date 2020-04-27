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
@Table(name = "medicao_gas")
public class MedicaoGas implements Serializable {

    @Id
    @SequenceGenerator(name = "mdg_id", sequenceName = "mdg_medicao_gas_id", allocationSize = 1)
    @GeneratedValue(generator = "mdg_id", strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne()
    @JoinColumn(name = "apartamento_id", referencedColumnName = "id", nullable = false)
    private Apartamento apartamento;
    @ManyToOne()
    @JoinColumn(name = "competencia_id", referencedColumnName = "id", nullable = false)
    private Competencia competencia;

    @Column(name = "mdg_leitura_atual", nullable = false)
    private int leituraAtual;
    @Column(name = "mdg_leitura_anterior", nullable = false)
    private int leituraAnterior;
    @Column(name = "mdg_preco_gas", nullable = false)
    private double precoMetroCubico;
    @Column(name = "mdg_total_consumo", nullable = false)
    private int totalConsumido;
    @Column(name = "mdg_valor", nullable = false)
    private double valor;

    public MedicaoGas() {

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
     * @return the apartamento
     */
    public Apartamento getApartamento() {
        return apartamento;
    }

    /**
     * @param apartamento the apartamento to set
     */
    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
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
     * @return the leituraAtual
     */
    public int getLeituraAtual() {
        return leituraAtual;
    }

    /**
     * @param leituraAtual the leituraAtual to set
     */
    public void setLeituraAtual(int leituraAtual) {
        this.leituraAtual = leituraAtual;
    }

    /**
     * @return the leituraAnterior
     */
    public int getLeituraAnterior() {
        return leituraAnterior;
    }

    /**
     * @param leituraAnterior the leituraAnterior to set
     */
    public void setLeituraAnterior(int leituraAnterior) {
        this.leituraAnterior = leituraAnterior;
    }

    /**
     * @return the precoMetroCubico
     */
    public double getPrecoMetroCubico() {
        return precoMetroCubico;
    }

    /**
     * @param precoGasData the precoMetroCubico to set
     */
    public void setPrecoMetroCubico(double precoGasData) {
        this.precoMetroCubico = precoGasData;
    }

    /**
     * @return the totalConsumido
     */
    public int getTotalConsumido() {
        return totalConsumido;
    }

    /**
     * @param totalConsumido the totalConsumido to set
     */
    public void setTotalConsumido(int totalConsumido) {
        this.totalConsumido = totalConsumido;
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
        int hash = 3;
        hash = 97 * hash + this.getId();
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
        final MedicaoGas other = (MedicaoGas) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        return true;
    }
}