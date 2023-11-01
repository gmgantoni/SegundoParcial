
package com.emergentes.control;

import com.emergentes.DAO.LibroDAO;
import com.emergentes.DAO.LibroDAOIMP;
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


@WebServlet(name = "LibroController", urlPatterns = {"/LibroController"})
public class LibroController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         LibroDAO dao = new LibroDAOIMP();
        Libro lib = new Libro();
        int id;

        String op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
        switch (op) {
            case "list":
                List<Libro> lista = new ArrayList<Libro>();

                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("libro.jsp").forward(request, response);

                break;
            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("LibroController");
                break;
            case "nuevo":
                request.setAttribute("libro", lib);
                request.getRequestDispatcher("editarlib.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    lib = dao.getById(id);
                } catch (Exception ex) {
                    Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("libro", lib);
                request.getRequestDispatcher("editarlib.jsp").forward(request, response);

                break;

        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String disponible = request.getParameter("disponible");
        String categoria = request.getParameter("categoria");

        Libro lib = new Libro();

        lib.setId(id);
        lib.setTitulo(titulo);
        lib.setAutor(autor);
        lib.setDisponible(disponible);
        lib.setCategoria(categoria);

        LibroDAO dao = new LibroDAOIMP();

        if (id == 0) {
            try {
                dao.insert(lib);
            } catch (Exception ex) {
                Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                dao.update(lib);
            } catch (Exception ex) {
                Logger.getLogger(LibroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("LibroController");
    }

}
