
package com.emergentes.control;

import com.emergentes.DAO.CategoriaDAO;
import com.emergentes.DAO.CategoriaDAOimp;
import com.emergentes.clase.Categoria;
import com.emergentes.clase.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaDAO dao = new CategoriaDAOimp();
        Categoria cat = new Categoria();
        
        int id;
        
        String op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
        switch (op) {
            case "list":
                List<Categoria> lista = new ArrayList<Categoria>();

                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("categoria.jsp").forward(request, response);

                break;
            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("CategoriaController");
                break;
            case "nuevo":
                request.setAttribute("categoria", cat);
                request.getRequestDispatcher("editarcat.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    cat = dao.getById(id);
                } catch (Exception ex) {
                    Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("categoria", cat);
                request.getRequestDispatcher("editarcat.jsp").forward(request, response);

                break;

        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String categoria = request.getParameter("categoria");
        
        Categoria cat = new Categoria();
        
        cat.setId(id);
        cat.setCategoria(categoria);
        
        CategoriaDAO dao = new CategoriaDAOimp();
        
        if(id == 0){
            try {
                //nuevo
                dao.insert(cat);
            } catch (Exception ex) {
                System.out.println("Eror al insertar. "+ ex.getMessage());
            }
        }else{
            try {
                //edicion
                dao.update(cat);
            } catch (Exception ex) {
                System.out.println("Error al editar: "+ex.getMessage());
            }
        }
        response.sendRedirect("CategoriaController");
        
    }
    

}
