package ua.laptop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.laptop.models.Product;
import java.util.List;

public interface ProductService {

    void add(Product product);

    void updatePrice(int id, double price);

    void deleteProductById(int id);

    List<Product> findProductByModel(String laptopModel);

    Product findOneProductByModel(String laptopModel);

    Product findProductById(int id);

    List<Product> findAll();

    List<Product> findLessPrice(double price);

    List<Product> priceLessToBig();

    List<Product> findProduct(String typeProcessorAmd, String typeProcessorIntel);

    void update(Product product);

    Page productPage(Pageable pageable);

    List<Object> productPageList(int numbrPage, int sizePage);

    List<Object> productPageList(int numbrPage, int sizePage, boolean sort);
}
