package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "API REST PRODUTO ")
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @ApiOperation(value = "Responsável por retornar uma mensagem de boas-vindas.")
    @GetMapping("/welcome")
    public String welcome(){
        return "BEM VINDO À PRODUCT REST API";
    }

    @ApiOperation(value = "Responsável por adicionar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 10, message = "Required fields not informed.")
    })
    @PostMapping("/addProduct")
    public Product addProduct(Product novoProduto){
        return productRepository.addProduct(novoProduto);
    }

    @ApiOperation(value = "Responsável por retornar uma lista de produtos")
    @ApiResponses(value = {
            @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    })
    @GetMapping("/allProducts")
    public List<Product> allProducts() {
        return productRepository.getAllProducts();
    }

    @ApiOperation(value = "Reponsável por atualizar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    })
    @PutMapping("/updateProduct")
    public Product updateProduct(){
        Product produto = new Product();
        return productRepository.updateProduct(produto);
    }

    @ApiOperation(value = "Responsável por retornar um produto pelo id.")
    @ApiResponses(value = {
            @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    })
    @GetMapping("/findProductById/{id}")
    public Product findProductById(@PathVariable Long id){
        return productRepository.getProductById(id);
    }

    @ApiOperation(value = "Responsável por remover um produto")
    @ApiResponses(value = {
            @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    })
    @DeleteMapping("/removeProduct")
    public String removeProduct(){
        Product produto = new Product();
        return productRepository.removeProduct(produto);
    }
}
