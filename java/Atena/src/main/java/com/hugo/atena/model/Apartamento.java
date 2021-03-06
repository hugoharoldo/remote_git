/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.model;

import com.hugo.atena.model.util.EntityManagerUtil;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "apartamento")
public class Apartamento implements Serializable, Cloneable {

    @Id
    @SequenceGenerator(name = "apt_id", sequenceName = "seq_apartamento_id", allocationSize = 1)
    @GeneratedValue(generator = "apt_id", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "apt_numero", nullable = false, unique = true)
    private int nrApartamento;
    @Column(name = "apt_sindico", nullable = true)
    private boolean sindico;
    @ManyToOne()
    @JoinColumn(name = "apt_proprietario", referencedColumnName = "id", nullable = false)
    private Pessoa proprietario;
    @ManyToOne()
    @JoinColumn(name = "apt_responsavel", referencedColumnName = "id", nullable = false)
    private Pessoa responsavel;
    @ManyToOne()
    @JoinColumn(name = "apt_tipo", referencedColumnName = "id", nullable = false)
    private TipoApartamento tipoApartamento;

    public Apartamento() {

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
     * @return the nrApartamento
     */
    public int getNrApartamento() {
        return nrApartamento;
    }

    /**
     * @param nrApartamento the nrApartamento to set
     */
    public void setNrApartamento(int nrApartamento) {
        this.nrApartamento = nrApartamento;
    }

    /**
     * @return the proprietario
     */
    public Pessoa getProprietario() {
        return proprietario;
    }

    /**
     * @param proprietario the proprietario to set
     */
    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    /**
     * @return the responsavel
     */
    public Pessoa getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
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
        final Apartamento other = (Apartamento) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public static List<Apartamento> getApartamentos() {

        String jpSql = "from Apartamento order by nrApartamento";

        return EntityManagerUtil.getEntityManager().createQuery(jpSql).getResultList();

    }

    @Override
    public String toString() {

        if (getNrApartamento() > 0) {

            return getNrApartamento()
                    + (getResponsavel() != null ? (" - " + getResponsavel().getName()) : "");

        } else {
            return "";
        }
    }

    /**
     * @return the tipoApartamento
     */
    public TipoApartamento getTipoApartamento() {
        return tipoApartamento;
    }

    /**
     * @param tipoApartamento the tipoApartamento to set
     */
    public void setTipoApartamento(TipoApartamento tipoApartamento) {
        this.tipoApartamento = tipoApartamento;
    }

    /**
     * @return the sindico
     */
    public boolean isSindico() {
        return sindico;
    }

    /**
     * @param sindico the sindico to set
     */
    public void setSindico(boolean sindico) {
        this.sindico = sindico;
    }

    public Apartamento clone() throws CloneNotSupportedException{
        return (Apartamento) super.clone();
    }
}
