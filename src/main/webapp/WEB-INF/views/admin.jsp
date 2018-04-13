<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
</head>

<body>
    <h2>Admin page</h2>
    <p><a href="/"> index page </a></p>
    <form action="/logout" method="post">
        <input type="submit" value="Sign Out"/>
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
    <br />
    <form action="/newproduct" method="get">
        <button type="submit">add laptop</button><br>
    </form>

    <br/>
    <form action="/findModel" method="post">
        <p>Find laptop by model</p>
        <input type="text" name="laptopModel" placeholder="laptop model" pattern="[A-Za-z0-9_-]+" title="A-Za-z0-9_-" required/>
        <input type="submit" value="find"/>
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
    <form action="/reset" method="get">
        <button type="submit">reset</button>
    </form>
    <br />
    <form action="/sizePage" method="get">
        Size page:<input type="text" name="size" value="${size}" size="3" maxlength="3" pattern="[0-9]+" title=" 0-9 ">
        <input type="submit" value="apply"/>
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
    <br/>
    <a href="/admin/page-${pageNumber-1}"> < </a>
    <c:forEach items="${listPages}" var="page">
        <a href="/admin/page-${page}"> ${page} </a>
    </c:forEach>
    <a href="/admin/page-${pageNumber+1}"> > </a>
    <c:forEach items="${products}" var="product">
        <hr />
        <div>
            <img src="${product.image}" height="100">
            <p>Id: ${product.id}, Laptop model: ${product.laptopModel}, Price: ${product.price}, Processor: ${product.processor}, Type processor: ${product.typeProcessor}</p>
            <p>Screen diagonal: ${product.screenDiagonal}, Amount of RAM: ${product.amountOfRAM}, Number of slots for RAM: ${product.numberOfslotsForRAM}, Type of RAM: ${product.typeOfRAM}, Drive capacity: ${product.driveCapacity}</p>
            <p>Chipset: ${product.chipset}, Graphic adapter: ${product.graphicAdapter}, Network adapters: ${product.networkAdapters}, IO connectors and ports: ${product.ioConnectorsAndPorts}, Battery: ${product.battery}</p>
            <p>Battery features: ${product.batteryFeatures}, Brief characteristics: ${product.briefCharacteristics}</p>
            <p>Date: ${product.date}</p>
            <form action="/edit" method="post">
                <input type="hidden" name="id" value="${product.id}">
                <input type="submit" value="edit">
            </form>
            <form action="/delete" method="post">
                <input type="hidden" name="id" value="${product.id}">
                <input type="submit" value="delete">
            </form>
        </div>
    </c:forEach>
    <br/>
    <br />
    <c:forEach items="${allProducts}" var="product">
        <hr />
        <div>
            <img src="${product.image}" height="100">
            <p>Id: ${product.id}, Laptop model: ${product.laptopModel}, Price: ${product.price}, Processor: ${product.processor}, Type processor: ${product.typeProcessor}</p>
            <p>Screen diagonal: ${product.screenDiagonal}, Amount of RAM: ${product.amountOfRAM}, Number of slots for RAM: ${product.numberOfslotsForRAM}, Type of RAM: ${product.typeOfRAM}, Drive capacity: ${product.driveCapacity}</p>
            <p>Chipset: ${product.chipset}, Graphic adapter: ${product.graphicAdapter}, Network adapters: ${product.networkAdapters}, IO connectors and ports: ${product.ioConnectorsAndPorts}, Battery: ${product.battery}</p>
            <p>Battery features: ${product.batteryFeatures}, Brief characteristics: ${product.briefCharacteristics}</p>
            <p>Date: ${product.date}</p>
            <form action="/edit" method="post">
                <input type="hidden" name="id" value="${product.id}">
                <input type="submit" value="edit">
            </form>
            <form action="/delete" method="post">
                <input type="hidden" name="id" value="${product.id}">
                <input type="submit" value="delete">
            </form>
        </div>
    </c:forEach>

    <a href="/admin/page-${pageNumber-1}"> < </a>
    <c:forEach items="${listPages}" var="page">
        <a href="/admin/page-${page}"> ${page} </a>
    </c:forEach>
    <a href="/admin/page-${pageNumber+1}"> > </a>

</body>
</html>
