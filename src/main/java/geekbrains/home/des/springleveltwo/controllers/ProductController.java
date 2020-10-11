package geekbrains.home.des.springleveltwo.controllers;

import geekbrains.home.des.springleveltwo.dto.ProductDTO;
import geekbrains.home.des.springleveltwo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAll(Model model){
        List<ProductDTO> products = productService.getAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/{id}/bucket")
    public String addProductInBucket(@PathVariable Long id, Principal principal){
        if (principal == null){
            return "redirect:/products";
        }
        productService.addToUserBucket(id, principal.getName());
        return "redirect:/products";
    }
}
