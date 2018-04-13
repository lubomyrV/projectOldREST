package ua.laptop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.laptop.dao.ProductDAO;
import ua.laptop.models.Product;
import ua.laptop.services.ProductService;
import ua.laptop.utils.ListPages;

import java.util.*;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public void add(Product product) {
        productDAO.save(product);
    }

    @Override
    public void updatePrice(int id, double price) {
        productDAO.updateModel(id,price);
    }

    @Override
    public void deleteProductById(int id) { productDAO.delete(id); }

    @Override
    public List<Product> findProductByModel(String laptopModel) {
        return productDAO.findProductByModel(laptopModel);
    }

    @Override
    public Product findOneProductByModel(String laptopModel) {
        return productDAO.findOneProductByModel(laptopModel);
    }

    @Override
    public Product findProductById(int id) {
        return productDAO.findOne(id);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<Product> findLessPrice(double price) {
        return productDAO.findLessPrice(price);
    }

    @Override
    public List<Product> priceLessToBig() {
        return productDAO.priceLessToBig();
    }

    @Override
    public List<Product> findProduct(String typeProcessorAmd, String typeProcessorIntel) {
        return productDAO.findProduct(typeProcessorAmd, typeProcessorIntel);
    }

    @Override
    public void update(Product product) {
        int id = product.getId();
        String laptopModel = product.getLaptopModel();
        double price = product.getPrice();
        String producer = product.getProducer();
        String processor = product.getProcessor();
        String typeProcessor = product.getTypeProcessor();
        String screenDiagonal = product.getScreenDiagonal();
        String amountOfRAM = product.getAmountOfRAM();
        String numberOfslotsForRAM = product.getNumberOfslotsForRAM();
        String typeOfRAM = product.getTypeOfRAM();
        String driveCapacity = product.getDriveCapacity();
        String chipset = product.getChipset();
        String graphicAdapter = product.getGraphicAdapter();
        String networkAdapters = product.getNetworkAdapters();
        String ioConnectorsAndPorts = product.getIoConnectorsAndPorts();
        String battery = product.getBattery();
        String batteryFeatures = product.getBatteryFeatures();
        String briefCharacteristics = product.getBriefCharacteristics();
        String image = product.getImage();
        productDAO.update(id,laptopModel,price,producer,processor,typeProcessor,screenDiagonal,amountOfRAM,numberOfslotsForRAM,typeOfRAM,driveCapacity,chipset,
                graphicAdapter,networkAdapters,ioConnectorsAndPorts,battery,batteryFeatures,briefCharacteristics,image);
    }

    @Override
    public Page productPage(Pageable pageable) {
        Page<Product> currentpage = productDAO.findAll(pageable);
        return currentpage;
    }

    @Override
    public List<Object> productPageList(int numbrPage, int sizePage) {
        List<Object> objectList = new ArrayList<>();
        int pageNumber = numbrPage;
        int sizePages = sizePage;
        int totalPages = 0;

        if(totalPages == 0){
            Page productPage = productPage(new PageRequest(pageNumber, sizePages));
            totalPages = productPage.getTotalPages();
        }
        if (pageNumber < 0) {
            pageNumber++;
        } else if(pageNumber >= totalPages ){
            pageNumber--;
        }

        Page productPage = productPage(new PageRequest(pageNumber, sizePages));

        totalPages = productPage.getTotalPages();
        ListPages listPagesSort = new ListPages(totalPages);
        pageNumber = productPage.getNumber();
        List pageContent = productPage.getContent();


        TreeSet<Integer> listPages = listPagesSort.pages(totalPages);

        objectList.add(pageNumber);
        objectList.add(pageContent);
        objectList.add(listPages);
        objectList.add(totalPages);
        return objectList;
    }

    @Override
    public List<Object> productPageList(int numbrPage, int sizePage, boolean sort) {
        List<Object> objectList = new ArrayList<>();
        int pageNumber = numbrPage;
        int sizePages = sizePage;
        int totalPages = 0;
        int firstId = 0;
        int lastId = 0;
        int totalElements = 0;

        if(totalPages == 0){
            Page productPage = productPage(new PageRequest(pageNumber, sizePages));
            totalPages = productPage.getTotalPages();
        }
        if (pageNumber < 0) {
            pageNumber++;
        } else if(pageNumber >= totalPages ){
            pageNumber--;
        }

        Page productPage = productPage(new PageRequest(pageNumber, sizePages));
        totalPages = productPage.getTotalPages();
        ListPages listPagesSort = new ListPages(totalPages);
        pageNumber = productPage.getNumber();
        List pageContent = productPage.getContent();
        TreeSet<Integer> listPages = listPagesSort.pages(totalPages);
//        totalElements = (int) productPage.getTotalElements();
//        System.out.println("totalElements: "+totalElements);
        if(sort == true){
            for (int i = 0; i < productPage.getNumberOfElements(); i++) {
                if(i == 0){
                    Product product = (Product) productPage.getContent().get(i);
                    firstId = product.getId();
                }
                if(i == productPage.getNumberOfElements()-1){
                    Product product = (Product) productPage.getContent().get(i);
                    lastId = product.getId();
                }
            }
        }

        List<Product> productsSort = productDAO.priceLessToBig(firstId, lastId);

//        List<Product> productList;
//
//        productList = productDAO.findAll();
//        for (int i = 0; i < productList.size(); i++) {
//            Product product = productList.get(i);
//            System.out.print(" "+product.getPrice());
//        }
//
//        Collections.sort(productList, Product.Comparators.PRICE);
//        System.out.println();
//        for (int i = 0; i < productList.size(); i++) {
//            Product product = productList.get(i);
//            System.out.print(" "+product.getPrice());
//        }

//        List<Product> productsSort = productDAO.priceLessToBig();
        List contentSort = productsSort;

        objectList.add(pageNumber);
        objectList.add(contentSort);
        objectList.add(listPages);
        objectList.add(totalPages);
        return objectList;
    }

}
