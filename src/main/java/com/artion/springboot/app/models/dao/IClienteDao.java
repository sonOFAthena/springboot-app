package com.artion.springboot.app.models.dao;

import com.artion.springboot.app.models.entity.Cliente;

import java.util.List;

public interface IClienteDao {
    public List<Cliente> findAll();
}