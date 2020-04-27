/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.model;

import java.io.Serializable;
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
@Table(name = "people")
public class Pessoa implements Serializable {

    @Id
    @SequenceGenerator(name = "pep_id", sequenceName = "seq_people_id", allocationSize = 1)
    @GeneratedValue(generator = "pep_id", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "pep_cnpjcpf", nullable = false, length = 14, unique = true)
    private String CPFCNPJ;
    @Column(name = "pep_name", nullable = false, length = 90)
    private String name;
    @Column(name = "pep_email", nullable = false, length = 90)
    private String email;
    @Column(name = "pep_telefone", nullable = false, length = 20)
    private String fone;
    @Column(name = "pep_complemento")
    private String complemento;

    public Pessoa() {

    }

    /**
     * @return the CPFCNPJ
     */
    public String getCPFCNPJ() {
        return CPFCNPJ;
    }

    /**
     * @param CPFCNPJ the CPFCNPJ to set
     */
    public void setCPFCNPJ(String CPFCNPJ) {
        this.CPFCNPJ = CPFCNPJ;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.CPFCNPJ);
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
        final Pessoa other = (Pessoa) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    /**
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    @Override
    public String toString(){
    
        if (getId() == 0){
            return "";
        }else{
            return getId() + " - " + getName();
        }
    }
}
