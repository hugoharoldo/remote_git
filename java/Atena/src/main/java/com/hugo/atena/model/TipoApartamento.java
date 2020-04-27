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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author hugo
 */
@Entity
@Table(name = "tipo_apartamento")
public class TipoApartamento implements Serializable {

    @Id
    @SequenceGenerator(name = "att_id", sequenceName = "seq_tipo_apartamento_id", allocationSize = 1)
    @GeneratedValue(generator = "att_id", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "att_descricao", nullable = false)
    private String descricao;
    @Column(name = "att_vlr_condominio", nullable = false)
    private double vlrCondominio;
    @Column(name = "att_vlr_fundo", nullable = false)
    private double vlrFundoReserva;

    public TipoApartamento() {

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
     * @return the vlrCondominio
     */
    public double getVlrCondominio() {
        return vlrCondominio;
    }

    /**
     * @param vlrCondominio the vlrCondominio to set
     */
    public void setVlrCondominio(double vlrCondominio) {
        this.vlrCondominio = vlrCondominio;
    }

    /**
     * @return the fundoReserva
     */
    public double getVlrFundoReserva() {
        return vlrFundoReserva;
    }

    /**
     * @param fundoReserva the fundoReserva to set
     */
    public void setVlrFundoReserva(double vlrFundoReserva) {
        this.vlrFundoReserva = vlrFundoReserva;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
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
        final TipoApartamento other = (TipoApartamento) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (getId() > 0) {
            return getDescricao();
        } else {
            return "";
        }
    }

    public static List<TipoApartamento> getTipoApartamentos() {

        String jpSql = "from TipoApartamento order";

        return EntityManagerUtil.getEntityManager().createQuery(jpSql).getResultList();

    }
}
