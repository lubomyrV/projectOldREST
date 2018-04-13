package ua.laptop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.laptop.models.Product;
import ua.laptop.services.ProductService;
import ua.laptop.utils.ListPages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AdminControll {

    @Autowired
    private ProductService productService;

    private int pageNumber = 0;
    private int totalPages = 0;
    private int sizePages = 3;

    ListPages listPagesSort = new ListPages(totalPages);

    @GetMapping("/admin")
    public String admin (Model model) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        GregorianCalendar calendar = new GregorianCalendar();
        Date time = calendar.getTime();
        String date = sdf.format(time);
        System.out.println(date);
        System.out.println(time);

        Page productPage = productService.productPage(new PageRequest(0, sizePages));
        this.pageNumber = productPage.getNumber();
        this.totalPages = productPage.getTotalPages();

        List pageContent = productPage.getContent();

        TreeSet<Integer> listPages = listPagesSort.pages(totalPages);

        model.addAttribute("size",sizePages);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("allProducts", pageContent);
        model.addAttribute("listPages", listPages);
        return "/admin";
    }

    @GetMapping("/admin/page-{page}")
    public String laptop(@PathVariable("page") int page, Model model) {

        if (page < 0) {
            page++;
            return "redirect:/admin/page-"+page;
        } else if(page >= totalPages ){
            page--;
            return "redirect:/admin/page-"+page;
        }

        Page productPage = productService.productPage(new PageRequest(page, sizePages));
        this.pageNumber = productPage.getNumber();

        List pageContent = productPage.getContent();

        TreeSet<Integer> listPages = listPagesSort.pages(totalPages);

        model.addAttribute("size",sizePages);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("allProducts", pageContent);
        model.addAttribute("listPages", listPages);
        return "/admin";
    }

    @GetMapping("/sizePage")
    public String sizePage (@RequestParam int size){

        if(size <= 0 ){
            size++;
        }

        this.sizePages = size;
        return "redirect:/admin";
    }

    @GetMapping("/newproduct")
    public String newproduct () {
        return "newproduct";
    }

    @PostMapping("/addProduct")
    public String addProduct (@RequestParam String laptopModel, @RequestParam double price, @RequestParam String producer, @RequestParam String processor, @RequestParam String typeProcessor,
                              @RequestParam String screenDiagonal, @RequestParam String amountOfRAM, @RequestParam String numberOfslotsForRAM, @RequestParam String typeOfRAM,
                              @RequestParam String driveCapacity, @RequestParam String chipset, @RequestParam String graphicAdapter, @RequestParam String networkAdapters,
                              @RequestParam String ioConnectorsAndPorts, @RequestParam String battery, @RequestParam String batteryFeatures, @RequestParam String briefCharacteristics,
                              @RequestParam("file") MultipartFile multipartFile){

        String path = System.getProperty("user.home") + File.separator + "images" + File.separator;
        try {
            multipartFile.transferTo(new File(path+multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println();
        }
        Product product = new Product();
        product.setLaptopModel(laptopModel);
        product.setPrice(price);
        product.setProducer(producer);
        product.setProcessor(processor);
        product.setTypeProcessor(typeProcessor);
        product.setScreenDiagonal(screenDiagonal);
        product.setAmountOfRAM(amountOfRAM);
        product.setNumberOfslotsForRAM(numberOfslotsForRAM);
        product.setTypeOfRAM(typeOfRAM);
        product.setDriveCapacity(driveCapacity);
        product.setChipset(chipset);
        product.setGraphicAdapter(graphicAdapter);
        product.setNetworkAdapters(networkAdapters);
        product.setIoConnectorsAndPorts(ioConnectorsAndPorts);
        product.setBattery(battery);
        product.setBatteryFeatures(batteryFeatures);
        product.setBriefCharacteristics(briefCharacteristics);
        product.setImage(File.separator + "img" + File.separator + multipartFile.getOriginalFilename());

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        GregorianCalendar calendar = new GregorianCalendar();
        Date time = calendar.getTime();
        String date = sdf.format(time);
        product.setDate(date);

        productService.add(product);
        return "redirect:/admin";
    }

    @GetMapping("/reset")
    public String reset () {
        return "redirect:/admin";
    }

    @PostMapping("/findModel")
    public String findModel (@RequestParam String laptopModel, Model model){
        List<Product> products = productService.findProductByModel(laptopModel);
        model.addAttribute("products", products);
        return "/admin";
    }

    @PostMapping("/delProduct")
    public String delProduct (@RequestParam int id){
        productService.deleteProductById(id);
        return "redirect:/admin";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam int id, Model model){
        Product productOld = productService.findProductById(id);
        model.addAttribute("product", productOld);
        return "/edit";
    }

    @PostMapping("/updateLaptop")
    public String updateLaptop (@RequestParam int id, @RequestParam String laptopModel, @RequestParam double price, @RequestParam String producer, @RequestParam String processor, @RequestParam String typeProcessor,
                              @RequestParam String screenDiagonal, @RequestParam String amountOfRAM, @RequestParam String numberOfslotsForRAM, @RequestParam String typeOfRAM,
                              @RequestParam String driveCapacity, @RequestParam String chipset, @RequestParam String graphicAdapter, @RequestParam String networkAdapters,
                              @RequestParam String ioConnectorsAndPorts, @RequestParam String battery, @RequestParam String batteryFeatures, @RequestParam String briefCharacteristics, @RequestParam String image){
        Product product = new Product();
        product.setId(id);
        product.setLaptopModel(laptopModel);
        product.setPrice(price);
        product.setProducer(producer);
        product.setProcessor(processor);
        product.setTypeProcessor(typeProcessor);
        product.setScreenDiagonal(screenDiagonal);
        product.setAmountOfRAM(amountOfRAM);
        product.setNumberOfslotsForRAM(numberOfslotsForRAM);
        product.setTypeOfRAM(typeOfRAM);
        product.setDriveCapacity(driveCapacity);
        product.setChipset(chipset);
        product.setGraphicAdapter(graphicAdapter);
        product.setNetworkAdapters(networkAdapters);
        product.setIoConnectorsAndPorts(ioConnectorsAndPorts);
        product.setBattery(battery);
        product.setBatteryFeatures(batteryFeatures);
        product.setBriefCharacteristics(briefCharacteristics);
        product.setImage(image);
        productService.update(product);
        return "redirect:/admin";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id){
        productService.deleteProductById(id);
        return "redirect:/admin";
    }

    @PostMapping("/updatProductPrice")
    public String updatProductModel (@RequestParam int id, @RequestParam double price){
        productService.updatePrice(id,price);
        return "redirect:/admin";
    }

    @GetMapping("/logout")
    public String logout (){
        return "/index";
    }

    @GetMapping("/login")
    public String login (){
        return "/login";
    }


}
