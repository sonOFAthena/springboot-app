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

    @Override
    @Transactional
    public void save(Cliente cliente) {

        if ( cliente.getId() != null && cliente.getId() > 0){
            em.merge(cliente);
        } else {
            em.persist(cliente);
        }
    }

    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class, id);
    }
}
