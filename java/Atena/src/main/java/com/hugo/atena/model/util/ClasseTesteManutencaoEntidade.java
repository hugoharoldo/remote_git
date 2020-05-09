/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.model.util;

import com.hugo.atena.model.Apartamento;
import com.hugo.atena.model.DespesaCompartilhada;
import com.hugo.atena.model.LancamentoCondominio;
import com.hugo.atena.model.LancamentoCondominioDespesa;
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
        
            despesas();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void despesas() throws Exception {
        
        
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        LancamentoCondominio l = new LancamentoCondominio();
        
        DespesaCompartilhada compartilhada_38 = em.find(DespesaCompartilhada.class, 38);
        DespesaCompartilhada compartilhada_39 = em.find(DespesaCompartilhada.class, 39);
        
        LancamentoCondominioDespesa ld1 = new LancamentoCondominioDespesa();
        ld1.setValorCorrespondente(17);
        ld1.setCompartilhada(compartilhada_39);

        LancamentoCondominioDespesa ld2 = new LancamentoCondominioDespesa();
        ld2.setValorCorrespondente(18);
        ld2.setCompartilhada(compartilhada_38);
       
        
//        l.addDespesa(ld1);
//        l.addDespesa(ld2);
//        
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        
    }
    
    
    private void addApartamento() throws Exception {

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
    }
}
