/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.shop_ao_quan.dao;

import com.mycompany.shop_ao_quan.model.HomeProduct;
import java.sql.*;
import java.util.*;

public class HomeDAO {

    public List<HomeProduct> getMenProducts() {
        return getProducts("vw_home_men");
    }

    public List<HomeProduct> getWomenProducts() {
        return getProducts("vw_home_women");
    }

    private List<HomeProduct> getProducts(String viewName) {
        List<HomeProduct> list = new ArrayList<>();
        String sql = "SELECT * FROM " + viewName;

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                HomeProduct p = new HomeProduct(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("image_url"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                );
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}