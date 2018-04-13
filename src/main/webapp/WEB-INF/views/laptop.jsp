<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
</head>
<body>
    <div>
        <img src="${product.image}" height="100px">
        <p>Laptop model: ${product.laptopModel}</p>
        <p>Price: ${product.price}</p>
        <p>Type of processor: ${product.typeProcessor}</p>
        <p>Processor: ${product.processor}</p>
        <p>Screen diagonal: ${product.screenDiagonal}</p>
        <p>Amount of RAM: ${product.amountOfRAM}</p>
        <p>Number of slots for RAM: ${product.numberOfslotsForRAM}</p>
        <p>Type of RAM: ${product.typeOfRAM}</p>
        <p>Drive capacity: ${product.driveCapacity}</p>
        <p>Chipset: ${product.chipset}</p>
        <p>Graphic adapter: ${product.graphicAdapter}</p>
        <p>Network adapters: ${product.networkAdapters}</p>
        <p>IO connectors and ports: ${product.ioConnectorsAndPorts}</p>
        <p>Battery: ${product.battery}</p>
        <p>Battery features: ${product.batteryFeatures}</p>
        <p>Brief characteristics: ${product.briefCharacteristics}</p>
    </div>
    <br/>
    <a href="/"> index page </a>
    <br/>
</body>
</html>
