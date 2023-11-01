
package com.emergentes.DAO;

import com.emergentes.clase.Libro;
import java.util.List;

public interface LibroDAO {
    public void insert(Libro lib) throws Exception;
    public void update(Libro lib) throws Exception;
    public void delete(int id) throws Exception;
    public List<Libro> getAll() throws Exception;
    public Libro getById(int id) throws Exception;
}
