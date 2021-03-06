package com.HuangZhiCheng.controller;

import com.HuangZhiCheng.dao.ProductDao;
import com.HuangZhiCheng.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : hzc
 * @date: 2021/5/14 - 05 - 14 - 19:16
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "ProductListServlet",value = "/admin/productList")
public class ProductListServlet extends HttpServlet {
    private Connection con;
    private static final long serialVersionUID = 9197585364289265302L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        week12
        ProductDao productDao = new ProductDao();
        try {
            List<Product> productList = productDao.findAll(con);
            request.setAttribute("productList",productList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String path = "/WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection)getServletContext().getAttribute("con");
    }
}
