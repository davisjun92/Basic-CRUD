package com.projectalpha.quickstart.controller;

import com.projectalpha.quickstart.model.Product;
import com.projectalpha.quickstart.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String list(Model model) {
        return viewPage(model, 1);
    }

    @GetMapping("/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum) {

        Page<Product> page = productService.getProductList(pageNum);

        List<Product> listProducts = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("products", listProducts);

        return "product_list";
    }

//    @GetMapping(path = "/products")
//    public String productList(Model model) {
//        model.addAttribute("products", productService.getProductList(1));
//        return "product_list";
//    }

    @GetMapping(path="/product/add")
    public String addProduct(Model model){

        Product product = new Product();
        model.addAttribute("product", product);
        return "add_product";
    }

    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "edit_product";
    }

    @PostMapping("/product/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute("product") Product product, Model model) {
        Product existingProduct = productService.getProductById(id);
        existingProduct.setId(id);
        existingProduct.setType(product.getType());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setDesc(product.getDesc());
        existingProduct.setCode(product.getCode());
        existingProduct.setName(product.getName());

        productService.updateProduct(existingProduct);
        return "redirect:/products";
    }

    @GetMapping("/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }


}
