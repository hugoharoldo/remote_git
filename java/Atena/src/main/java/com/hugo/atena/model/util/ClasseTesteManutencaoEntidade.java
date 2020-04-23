/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.model.util;

import com.hugo.atena.model.Apartamento;
import com.hugo.atena.model.Pessoa;
import javax.persistence.EntityManager;

/**
 *
 * @author hugo
 */
public class ClasseTesteManutencaoEntidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {

            EntityManager em = EntityManagerUtil.getEntityManager();

//            Pessoa p = em.find(Pessoa.class, 5);

        Pessoa p = new Pessoa();
        p.setId(5);

            Apartamento a = new Apartamento();
            a.setNrApartamento(102);
            a.setProprietario(p);

            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
