
package com.emergentes.DAO;

import com.emergentes.clase.Libro;
import com.emergentes.conexion.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOIMP extends ConexionBD implements LibroDAO{

    @Override
    public void insert(Libro lib) throws Exception {
        String sql = "insert into libros (titulo,autor,disponible,categoria) values(?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, lib.getTitulo());
        ps.setString(2, lib.getAutor());
        ps.setString(3, lib.getDisponible());
        ps.setString(4, lib.getCategoria());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Libro lib) throws Exception {
        String sql = "update libros set titulo=?, autor=?, disponible=?, categoria=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, lib.getTitulo());
        ps.setString(2, lib.getAutor());
        ps.setString(3, lib.getDisponible());
        ps.setString(4, lib.getCategoria());
        ps.setInt(5, lib.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from libros where id =?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Libro> getAll() throws Exception {
        List<Libro> lista = null;
        String sql = "select *from libros";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Libro>();
        while (rs.next()) {
            Libro lib = new Libro();
            lib.setId(rs.getInt("id"));
            lib.setTitulo(rs.getString("titulo"));
            lib.setAutor(rs.getString("autor"));
            lib.setDisponible(rs.getString("disponible"));
            lib.setCategoria(rs.getString("categoria"));

            lista.add(lib);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public Libro getById(int id) throws Exception {
        Libro lib = new Libro();
        try {
            String sql = "select *from libros where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lib.setId(rs.getInt("id"));
                lib.setTitulo(rs.getString("titulo"));
                lib.setAutor(rs.getString("autor"));
                lib.setDisponible(rs.getString("disponible"));
                lib.setCategoria(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            throw e;
        } finally{
        }
        this.desconectar();
        return lib;
    }
    
}
