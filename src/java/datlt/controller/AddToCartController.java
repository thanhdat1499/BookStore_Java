/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.controller;

import datlt.daos.BookDAO;

import datlt.dtos.BookDTO;
import datlt.dtos.CartDTO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AddToCartController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            HttpSession session = request.getSession();
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            ArrayList<CartDTO> shoppingCart = (ArrayList<CartDTO>) session.getAttribute("shoppingCart");
            BookDTO book = new BookDAO().findByPrimaryKey(bookId);
            CartDTO cart = new CartDTO(bookId, book.getBookName(), book.getPrice(), book.getQuantity());
            cart.setBuyingQuantity(1);
            
            if(shoppingCart == null){
                shoppingCart = new ArrayList<>();
                shoppingCart.add(cart);
            }else{
                boolean checkExist = false;
                for (CartDTO cartDTO : shoppingCart) {
                    if(cartDTO.getBookId()== bookId){
                        cartDTO.setBuyingQuantity(cartDTO.getBuyingQuantity() + 1);
                        checkExist = true;
                    }
                }if(checkExist == false){
                    shoppingCart.add(cart);
                }
            }
            
            session.setAttribute("shoppingCart", shoppingCart);
        }catch(Exception e){
            log("ERROR at AddToCartController: " + e.getMessage());
        }finally{
            response.sendRedirect("paging");
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
