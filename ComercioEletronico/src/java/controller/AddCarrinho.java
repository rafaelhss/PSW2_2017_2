/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Catalogo;
import model.Produto;

/**
 *
 * @author Rafael.Soares
 */
public class AddCarrinho extends HttpServlet {

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
        
        HttpSession sessao = request.getSession(false);
        if(sessao == null){
            request.getRequestDispatcher("informarIdade.html")
                    .forward(request, response);
        } else {
        
            List<Produto> carrinho = (List<Produto>) sessao.getAttribute("carrinho");
            if(carrinho == null){
                carrinho = new ArrayList<>();
            }

            Integer id = Integer.parseInt(request.getParameter("id"));

            String filename = "C:\\Users\\rafael.soares\\Documents\\NetBeansProjects\\ComercioEletronico\\src\\java\\produtos.txt";
            Catalogo catalogo = new Catalogo(filename);
            Produto produto = catalogo.buscarProdutoPorId(id);

            carrinho.add(produto);

            sessao.setAttribute("carrinho", carrinho);

            request.setAttribute("mensagem", "Produto (" + produto.getNome() + ") adicionado com sucesso.");

            request.getRequestDispatcher("ListarProdutos")
                    .forward(request, response);
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
        processRequest(request, response);
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
