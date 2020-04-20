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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author hugo
 */
@Entity
@Table(name = "usuario_sitema")
public class UsuarioSistema implements Serializable {

    @Id
    @SequenceGenerator(name = "usu_id", sequenceName = "seq_usuario_sistema_id", allocationSize = 1)
    @GeneratedValue(generator = "usu_id", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "uss_nome", nullable = false, length = 90, unique = true)
    private String nome;
    @Column(name = "uss_senha", nullable = false, length = 90)
    private String senha;

    public UsuarioSistema() {
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.getId();
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
        final UsuarioSistema other = (UsuarioSistema) obj;
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
