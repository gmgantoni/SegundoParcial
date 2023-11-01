
package com.emergentes.DAO;

import com.emergentes.clase.Categoria;
import java.util.List;


public interface CategoriaDAO {
    public void insert(Categoria cat) throws Exception;
    public void update(Categoria cat) throws Exception;
    public void delete(int id) throws Exception;
    public List<Categoria> getAll() throws Exception;
    public Categoria getById(int id) throws Exception;
}
