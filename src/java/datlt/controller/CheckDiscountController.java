/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datlt.controller;

import datlt.daos.BookDAO;
import datlt.daos.DiscountDAO;
import datlt.daos.OrderDAO;
import datlt.dtos.AccountDTO;
import datlt.dtos.CartDTO;
import datlt.dtos.DiscountCodeDTO;
import datlt.dtos.OrderBookDTO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CheckDiscountController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            ArrayList<CartDTO> shoppingCart = (ArrayList<CartDTO>) session.getAttribute("shoppingCart");
            AccountDTO account = (AccountDTO) session.getAttribute("account");
            String discountName = request.getParameter("discountName");
            DiscountDAO disDao = new DiscountDAO();
            OrderDAO orderDAO = new OrderDAO();
            BookDAO bookDAO = new BookDAO();
            OrderBookDTO orderBook = null;
            boolean updated = false;

            float totalPrice = 0;
            for (CartDTO cartDTO : shoppingCart) {
                totalPrice += cartDTO.getPrice() * cartDTO.getBuyingQuantity();
            }

            if (!discountName.isEmpty()) {
                DiscountCodeDTO discount = disDao.findDiscountByDisName(discountName);
                if (discount != null) {
                    if (disDao.checkDiscount(discount.getDisId(), account.getUserId())) {
                        request.setAttribute("invalidDiscount", "Invalid! This Discount is used!");
                    } else {
                        float newTotal = (totalPrice - ((totalPrice * discount.getDisPercent()) / 100));
                        orderBook = new OrderBookDTO(account.getUserId(), newTotal, discount.getDisId());
                        int orderId = orderDAO.addOrderReturnId(orderBook);
                        int length = orderDAO.addOrderDetailReturnId(shoppingCart, orderId);
                        boolean used = disDao.insertIntoDiscountUsed(account.getUserId(), discount.getDisId());
                        for (CartDTO cartDTO : shoppingCart) {
                            updated = bookDAO.updateQuantity(cartDTO.getBookId(), (cartDTO.getQuantity() - cartDTO.getBuyingQuantity()));
                        }

                        if (length > 0 && used != false) {
                            request.setAttribute("done", "Thanks for paying!");
                            request.setAttribute("totalBill", newTotal);
                        } else {
                            request.setAttribute("error", "Error!");
                        }

                    }
                } else {
                    request.setAttribute("notFound", "Invalid! This discount is invalid!");
                }
            } else if (discountName.isEmpty()) {
                orderBook = new OrderBookDTO(account.getUserId(), totalPrice, 4);
                int orderId = orderDAO.addOrderReturnId(orderBook);
                int length = orderDAO.addOrderDetailReturnId(shoppingCart, orderId);
                for (CartDTO cartDTO : shoppingCart) {
                    updated = bookDAO.updateQuantity(cartDTO.getBookId(), (cartDTO.getQuantity() - cartDTO.getBuyingQuantity()));
                }

                if (length > 0) {
                    request.setAttribute("done", "Thanks for paying!");
                    request.setAttribute("totalBill", totalPrice);
                } else {
                    request.setAttribute("error", "Error!");
                }

            }

        } catch (Exception e) {
            log("ERROR at CheckDiscountController: " + e.getMessage());
        } finally {

            request.getRequestDispatcher("discount.jsp").forward(request, response);
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
