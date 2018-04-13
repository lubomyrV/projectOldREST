package ua.laptop.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.laptop.models.Product;

import java.util.Collection;
import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer>{

    @Modifying(clearAutomatically = true)
    @Query("update Product p " +
            "set p.price =:price " +
            "where p.id =:id")
    void updateModel(@Param("id") int id, @Param("price") double price);

    @Modifying(clearAutomatically = true)
    @Query("update Product p " +
            "set p.laptopModel=:laptopModel, p.price=:price, p.producer=:producer, p.processor=:processor, " +
            "p.typeProcessor=:typeProcessor, p.screenDiagonal=:screenDiagonal, p.amountOfRAM=:amountOfRAM, p.numberOfslotsForRAM=:numberOfslotsForRAM, " +
            "p.typeOfRAM=:typeOfRAM, p.driveCapacity=:driveCapacity, p.chipset=:chipset, p.graphicAdapter=:graphicAdapter, p.networkAdapters=:networkAdapters, " +
            "p.ioConnectorsAndPorts=:ioConnectorsAndPorts, p.battery=:battery, p.batteryFeatures=:batteryFeatures, p.briefCharacteristics=:briefCharacteristics, " +
            "p.image=:image " +
            "where p.id =:id")
    void update(@Param("id") int id, @Param("laptopModel") String laptopModel, @Param("price") double price, @Param("producer") String producer,
                @Param("processor") String processor, @Param("typeProcessor") String typeProcessor, @Param("screenDiagonal") String screenDiagonal,
                @Param("amountOfRAM") String amountOfRAM, @Param("numberOfslotsForRAM") String numberOfslotsForRAM, @Param("typeOfRAM") String typeOfRAM,
                @Param("driveCapacity") String driveCapacity, @Param("chipset") String chipset, @Param("graphicAdapter") String graphicAdapter,
                @Param("networkAdapters") String networkAdapters, @Param("ioConnectorsAndPorts") String ioConnectorsAndPorts, @Param("battery") String battery,
                @Param("batteryFeatures") String batteryFeatures, @Param("briefCharacteristics") String briefCharacteristics, @Param("image") String image);

    @Query("from Product p where p.laptopModel =:laptopModel")
    List<Product> findProductByModel(@Param("laptopModel") String laptopModel);

    @Query("from Product p where p.laptopModel =:laptopModel")
    Product findOneProductByModel(@Param("laptopModel") String laptopModel);

    @Query("from Product p where p.price<=:price")
    List<Product> findLessPrice(@Param("price") double price);

    @Query("from Product p order by price")
    List<Product> priceLessToBig();

    @Query("from Product p where((p.id>=:first)and(p.id<=:last)) order by price")
    List<Product> priceLessToBig(@Param("first") int first, @Param("last") int last);

    @Query("from Product p " +
            "where( " +
            "((p.amountOfRAM =:typeProcessorAmd)or(p.typeProcessor =:null)) " +
            "and " +
            "((p.typeProcessor =:typeProcessorIntel)or(p.typeProcessor =:null)) )")
    List<Product> findProduct(@Param("typeProcessorAmd") String typeProcessorAmd,@Param("typeProcessorIntel") String typeProcessorIntel );


}
