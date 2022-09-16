package com.artion.springboot.app.models.dao;

import com.artion.springboot.app.models.entity.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao{

    //va a usar JPA
    @PersistenceContext
    private EntityManager em;

    /**
     *  @Transactional() envolvera el metodo en un contexto de tx
     *
     */
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }
}
