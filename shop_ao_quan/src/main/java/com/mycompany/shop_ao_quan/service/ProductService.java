package com.mycompany.shop_ao_quan.service;

import com.mycompany.shop_ao_quan.dao.ProductDAOImpl;
import com.mycompany.shop_ao_quan.model.Product;

public class ProductService {

    private ProductDAOImpl productDAO;

    public ProductService() {
        productDAO = new ProductDAOImpl();
    }

    // =============================
    // ADD PRODUCT
    // =============================
    public void addProduct(Product product) throws Exception {

        validateProduct(product);

        product.setName(product.getName().trim());

        productDAO.save(product);
    }

    // =============================
    // UPDATE PRODUCT
    // =============================
    public Product updateProduct(Product product) throws Exception {

        if (product.getProductId() <= 0) {
            throw new Exception("ID sản phẩm không hợp lệ");
        }

        validateProduct(product);

        return productDAO.update(product);
    }

    // =============================
    // DELETE PRODUCT
    // =============================
    public boolean deleteProduct(int productId) throws Exception {

        if (productId <= 0) {
            throw new Exception("ID không hợp lệ");
        }

        // ⚠ nếu có variant → nên xoá trước
        // TODO: gọi VariantDAO xoá variant trước

        return productDAO.delete(productId);
    }

    // =============================
    // VALIDATION
    // =============================
    private void validateProduct(Product p) throws Exception {

        if (p.getName() == null || p.getName().trim().isEmpty()) {
            throw new Exception("Tên sản phẩm không được để trống");
        }

        if (p.getCategory() == null || p.getCategory().isEmpty()) {
            throw new Exception("Danh mục không hợp lệ");
        }
    }
}
