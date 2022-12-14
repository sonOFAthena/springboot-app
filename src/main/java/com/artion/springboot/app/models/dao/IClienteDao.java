package com.artion.springboot.app.models.dao;

import com.artion.springboot.app.models.entity.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IClienteDao {
    public List<Cliente> findAll();
    public void save(Cliente cliente);
    public Cliente findOne(Long id);
    public void delete(Long id);
}
