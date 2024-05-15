package com.emergentes.controlador;

import com.emergentes.dao.FormularioDAO;
import com.emergentes.dao.FormularioDAOimp;
import com.emergentes.modelo.Formulario;
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

@WebServlet(name = "FormularioController", urlPatterns = {"/FormularioController"})
public class FormularioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FormularioDAO dao = new FormularioDAOimp();

        Formulario avi = new Formulario();
        int id;
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        switch (action) {
            case "add":
                request.setAttribute("formulario", avi);
                request.getRequestDispatcher("frmformulario.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    avi = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Error al obtener registro " + ex.getMessage());
                }
                request.setAttribute("formulario", avi);
                request.getRequestDispatcher("frmformulario.jsp").forward(request, response);

                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar: " + ex.getMessage());
                }
                response.sendRedirect("FormularioController");
                break;
            case "view":
                List<Formulario> lista = new ArrayList<Formulario>( );
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar "+ex.getMessage());
                }
                request.setAttribute("formularios", lista);
                request.getRequestDispatcher("formularios.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String seminario = request.getParameter("seminario");
        int confirmados = Integer.parseInt(request.getParameter("confirmados"));
        String fechainscripcion = request.getParameter("fechainscripcion");
        
        Formulario avi = new Formulario();
        
        avi.setId(id);
        avi.setNombres(nombres);
        avi.setApellidos(apellidos);
        avi.setSeminario(seminario);
        avi.setConfirmados(confirmados);
        avi.setFechainscripcion(fechainscripcion);
        
        FormularioDAO dao = new FormularioDAOimp();
        
        if (id == 0){
            try {
                dao.insert(avi);
            } catch (Exception ex) {
                System.out.println("Error al insertar"+ ex.getMessage());
            }
        }
        else{
            try {
                dao.update(avi);
            } catch (Exception ex) {
                System.out.println("Error al editar"+ ex.getMessage());
            }
        }
        response.sendRedirect("FormularioController");
    }
}
