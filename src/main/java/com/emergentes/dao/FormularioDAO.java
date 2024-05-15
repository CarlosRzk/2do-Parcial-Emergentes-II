package com.emergentes.dao;

import com.emergentes.modelo.Formulario;
import java.util.List;

public interface FormularioDAO {
    public void insert(Formulario formulario) throws Exception;
    public void update(Formulario formulario) throws Exception;
    public void delete(int id) throws Exception;
    public List<Formulario> getAll() throws Exception;
    public Formulario getById(int id) throws Exception;
}
