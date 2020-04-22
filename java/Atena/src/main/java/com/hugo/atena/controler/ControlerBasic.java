/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.controler;

import com.hugo.atena.model.util.EntityManagerUtil;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author hugo
 */
public abstract class ControlerBasic {

    public ControlerBasic() {

    }
    
    public void save(Object object, int idObjeto) {

        try {

            EntityManager em = EntityManagerUtil.getEntityManager();

            em.getTransaction().begin();

            String mensagem;

            if (idObjeto == 0) {
                em.persist(object);
                mensagem = "Registro inserido com sucesso!";
            } else {
                em.merge(object);
                mensagem = "Registro alterado com sucesso!";
            }

            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, mensagem);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void remove(Object object) {
        try {

            EntityManager em = EntityManagerUtil.getEntityManager();

            em.getTransaction().begin();

            em.remove(object);

            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Registro removido");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    /**
     *
     * @param id
     * @param object apenas para referenciar o tipo de classe (verificar no
     * futuro se tem algo como Generics)
     * @return pode ser null
     */
    public Object load(int id, Object object) {

        if (id > 0) {

            try {

                EntityManager em = EntityManagerUtil.getEntityManager();

                return em.find(object.getClass(), id);

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
            }

        }

        return null;
    }
}
