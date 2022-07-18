package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> produtos = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return produtos;
    }

    public Product getProductById(Long id) {
        for (Product produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public Product addProduct(Product s) {
        produtos.add(s);
        return s;
    }

    public Product updateProduct(Product s) {
        Product antigoProduto = new Product();

        for (Product produto : produtos) {
            if (produto.getId() == s.getId()) {
                antigoProduto = produto;
            }
        }

        antigoProduto.setName(s.getName());
        antigoProduto.setDescription(s.getDescription());
        antigoProduto.setPrice(s.getPrice());
        antigoProduto.setStatus(s.getStatus());

        return getProductById(s.getId());
    }

    public String removeProduct(Product s) {
        produtos.remove(s);
        return "Produto removido com sucesso";
    }
//
//    public void addList(List<Product> listOfProducts) {
//        // TODO Implementar
//    }
}
