package com.emergentes.DAO;

import com.emergentes.clase.Categoria;
import com.emergentes.conexion.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOimp extends ConexionBD implements CategoriaDAO {

    @Override
    public void insert(Categoria cat) throws Exception {
        String sql = "insert into categorias(categoria) values(?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cat.getCategoria());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Categoria cat) throws Exception {
        String sql = "update categorias set categoria=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cat.getCategoria());
        ps.setInt(2, cat.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from categorias where id =?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Categoria> getAll() throws Exception {
        List<Categoria> lista = null;
        String sql = "select *from categorias";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Categoria>();
        while (rs.next()) {
            Categoria cat = new Categoria();
            cat.setId(rs.getInt("id"));
            cat.setCategoria(rs.getString("categoria"));


            lista.add(cat);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public Categoria getById(int id) throws Exception {
        Categoria cat = new Categoria();
        try {
            String sql = "select *from categorias where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cat.setId(rs.getInt("id"));
                cat.setCategoria(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
        }
        this.desconectar();
        return cat;
    }

}
