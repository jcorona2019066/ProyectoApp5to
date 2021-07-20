 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.Usuario;
import modeloDAO.PersonaDAO;
import modeloDAO.UsuarioDAO;

/**
 *
 * @author Admin
 */
public class Controlador extends HttpServlet {
    
    String listar = "view/listar.jsp";
    String add = "view/add.jsp";
    String edit = "view/editar.jsp";
    String usuaListar = "view/listarUsuario.jsp";
    String ind = "index.jsp";
 
    Persona nuevaPersona = new Persona();
    PersonaDAO nuevaPersonaDao = new PersonaDAO();
    
    Usuario usa = new Usuario();
    UsuarioDAO usaD = new UsuarioDAO();
    int codigoPersona;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");             
        if (action.equalsIgnoreCase("listar")) {         
                acceso = listar;
        }else if(action.equalsIgnoreCase("add")){
            acceso = add;   
        }else if(action.equalsIgnoreCase("Agregar")){
            String DPI= request.getParameter("txtDPI");
            String nombre= request.getParameter("txtNombre");
            nuevaPersona.setDPI(DPI);
            nuevaPersona.setNombrePersona(nombre);
            nuevaPersonaDao.add(nuevaPersona);
            acceso = listar;
           
        }else if(action.equalsIgnoreCase("atras")){
            acceso=ind;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("codPer", request.getParameter("codigoPersona"));
            acceso = edit;
            
        }else if(action.equalsIgnoreCase("Actualizar")){
            codigoPersona = Integer.parseInt(request.getParameter("txtCodigoPersona"));
            String DPI = request.getParameter("txtDPI");
            String nombres = request.getParameter("txtNombre");
            nuevaPersona.setCodigoPersona(codigoPersona);
            nuevaPersona.setDPI(DPI);
            nuevaPersona.setNombrePersona(nombres);
            nuevaPersonaDao.edit(nuevaPersona);
            acceso = listar;    
        }else if(action.equalsIgnoreCase("eliminar")){
            codigoPersona = Integer.parseInt(request.getParameter("codigoPersona"));
            nuevaPersona.setCodigoPersona(codigoPersona);
            nuevaPersonaDao.eliminar(codigoPersona);
            acceso = listar;
        
        }else if(action.equalsIgnoreCase("Ingresar")){
                String validacion;
                String usuario = request.getParameter("txtUsuario");
                String password = request.getParameter("txtPassword");
                int rol = Integer.parseInt(request.getParameter("cmbRol"));
                
                validacion = usaD.validar(usuario, password, rol);
                
                if(validacion.equals("admin")){
                    acceso = listar;
                }else if (validacion.equals("user")){
                    acceso = usuaListar;
                }else{
                    out.println("No ingreso Datos");
                    acceso = ind;
                }
            }
        
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo(){ 
        return "Short description";
    }// </editor-fold>

}