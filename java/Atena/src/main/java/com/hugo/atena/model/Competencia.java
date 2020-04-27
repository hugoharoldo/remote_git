/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.model;

import com.hugo.atena.model.util.EntityManagerUtil;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
@Table(name = "competencia")
public class Competencia implements Serializable {

    @Id
    @SequenceGenerator(name = "cpt_id", sequenceName = "seq_competencia_id", allocationSize = 1)
    @GeneratedValue(generator = "cpt_id", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "cpt_ano", nullable = false)
    private int ano;
    @Column(name = "cpt_mes", nullable = false)
    private int mes;

    public Competencia() {
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
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Competencia other = (Competencia) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        if (getId() == 0) {
            return "";
        } else {
            return getAno() + " - " + getMes();
        }
    }

    public static List<Competencia> getCompetencias() {

        String jpSql = "from Competencia order by cpt_ano desc, cpt_mes desc";

        return EntityManagerUtil.getEntityManager().createQuery(jpSql).getResultList();
    }
}
