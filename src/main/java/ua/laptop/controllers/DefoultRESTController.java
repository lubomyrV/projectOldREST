package ua.laptop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.laptop.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DefoultRESTController {
    @Autowired
    private ProductService productService;
    private int totalPages = 0;
    private int pageNumber = 0;
    private int sizePage = 3;
    private boolean sortPrice = false;
    ArrayList<Integer> listPages = new ArrayList<>();

//    @GetMapping("/page-{page}")
//    public List<Object> pages(@PathVariable("page") int page, Model model){
//        List<Object> objectList = productService.productPageList(page, 1);
//        return objectList;
//    }

    @PostMapping("/sortPrice")
    public boolean sortPrice (@RequestBody String sort) {
        sortPrice = Boolean.parseBoolean(sort);
        return sortPrice;
    }

    @GetMapping("/allProducts")
    public List<Object> indexProducts () {
        if(sortPrice){
            List<Object> objectList = productService.productPageList(pageNumber,sizePage,sortPrice);
            objectList.add(sortPrice);
            return objectList;
        }
        List<Object> objectList = productService.productPageList(pageNumber, sizePage);
        objectList.add(sortPrice);
        pageNumber = (int) objectList.get(0);
        totalPages = (int) objectList.get(3);
        return objectList;
    }

    @GetMapping("/prev")
    public List<Object> prevPage () {
        pageNumber--;
        if(pageNumber < 0 ){
            pageNumber++;
        } else if(pageNumber >= totalPages ){
            pageNumber--;
        }
        if(sortPrice){
            return productService.productPageList(pageNumber,sizePage,sortPrice);
        }
        List<Object> objectList = productService.productPageList(pageNumber, sizePage);
        return objectList;
    }

    @GetMapping("/next")
    public List<Object> nextPage () {
        pageNumber++;
        if(pageNumber < 0 ){
            pageNumber++;
        } else if(pageNumber >= totalPages ){
            pageNumber--;
        }
        if(sortPrice){
            return productService.productPageList(pageNumber,sizePage,sortPrice);
        }
        List<Object> objectList = productService.productPageList(pageNumber, sizePage);
        return objectList;
    }

    @GetMapping("/more")
    public List<Object> more () {

        if(pageNumber <= totalPages ){
            pageNumber++;
        } else {
            pageNumber--;
        }
        if(sortPrice){
            List<Object> objectList = productService.productPageList(pageNumber,sizePage,sortPrice);
            return objectList;
        }
        List<Object> objectList = productService.productPageList(pageNumber, sizePage);
        System.out.println();
        System.out.println(objectList);
        System.out.println();
        return objectList;
    }

    @GetMapping("/sort")
    public List<Object> products() {
        return productService.productPageList(pageNumber,sizePage,sortPrice);
    }

}