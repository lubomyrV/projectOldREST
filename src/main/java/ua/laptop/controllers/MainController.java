package ua.laptop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.laptop.models.Product;
import ua.laptop.services.ProductService;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index () {
        return "index";
    }

    @GetMapping("/{laptopModel}")
    public String laptop(@PathVariable("laptopModel") String laptopModel, Model model){
        Product product = productService.findOneProductByModel(laptopModel);
        model.addAttribute("product", product);
        return "laptop";
    }


}
