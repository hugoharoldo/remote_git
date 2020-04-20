/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.daos.teste;

import com.hugo.atena.model.CompraGas;
import com.hugo.atena.daos.EntityManagerUtil;
import com.hugo.atena.model.People;
import com.hugo.atena.utils.HNumber;
import com.hugo.atena.view.TableModel;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author hugo
 */
public class TestePersistirPessoa {
    
    public static void main(String[] args) {
        
        try {
            
            EntityManager em = EntityManagerUtil.getEntityManager();
            
            People people = new People();
            
            people.setCPFCNPJ("048.230.719-64");
            people.setName("Hugo Haroldo Swarowsky");
            people.setEmail("hugoharoldo@gmail.com");
            people.setFone("(47) 99921-3422");
            CompraGas cg = new CompraGas();
            cg.setDataCompra(new GregorianCalendar());
            cg.setValorPago(2.34);
            
            em.getTransaction().begin();
            em.persist(people);
//            em.persist(cg);
            em.getTransaction().commit();
            
            em.close();
            
        } catch (Exception e) {
            System.out.println("Erro" + e.getMessage());
        }
    }
    
}
