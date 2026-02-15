package com.mycompany.shop_ao_quan.dao;

import com.mycompany.shop_ao_quan.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDAOImpl implements WriteInterface<Product> {

    @Override
    public void save(Product p) throws Exception {
        String sql = """
            INSERT INTO product(name, category, image_url)
            VALUES (?, ?, ?)
        """;

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getCategory());
            ps.setString(3, p.getImageUrl());

            ps.executeUpdate();
        }
    }

    @Override
    public Product update(Product p) throws Exception {

        String sql = """
            UPDATE product
            SET name = ?, category = ?, image_url = ?
            WHERE product_id = ?
        """;

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getCategory());
            ps.setString(3, p.getImageUrl());
            ps.setInt(4, p.getProductId());

            ps.executeUpdate();
        }

        return p;
    }

    @Override
    public Boolean delete(int id) throws Exception {

        String sql = "DELETE FROM product WHERE product_id = ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
