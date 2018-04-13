<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <meta charset="UTF-8"/>
</head>
<body>
    <a href="/admin"> admin page </a>
    <br />
    <a href="/"> index page </a>
    <br />
    <sf:form action="/updateLaptop" method="post" modelAttribute="product">
        <p>Update laptop</p>
        <img src="${product.image}" height="100px">
        <p>id <sf:input type="text" path="id" readonly="true" /></p>
        <p>laptop model <sf:input type="text" path="laptopModel" /></p>
        <p>price <sf:input type="text" path="price" /></p>
        <p>producer <sf:input type="text" path="producer"/><p/>
        <p>type processor <sf:select path="typeProcessor">
            <option value="Intel" selected>Intel</option>
            <option value="AMD">AMD</option>
        </sf:select></p>
        <p>processor <sf:input type="text" path="processor"/></p>
        <p>screen diagonal <sf:input type="text" path="screenDiagonal"/></p>
        <p>amount of RAM <sf:input type="text" path="amountOfRAM"/><br />
        <p>number of slots for RAM <sf:input type="text" path="numberOfslotsForRAM"/></p>
        <p>type of RAM <sf:input type="text" path="typeOfRAM"/></p>
        <p>drive capacity <sf:input type="text" path="driveCapacity"/></p>
        <p>chipset <sf:input type="text" path="chipset"/></p>
        <p>graphic adapter <sf:input type="text" path="graphicAdapter"/></p>
        <p>network adapters <sf:input type="text" path="networkAdapters"/></p>
        <p>IO connectors and ports <sf:input type="text" path="ioConnectorsAndPorts"/></p>
        <p>battery <sf:input type="text" path="battery"/></p>
        <p>battery features <sf:input type="text" path="batteryFeatures"/></p>
        <p>characteristics <br /><sf:textarea rows="5" cols="55" path="briefCharacteristics" maxlength="250" ></sf:textarea></p>
        <p>image <sf:input type="text" path="image" readonly="true"/></p>
        <input type="submit" value="save"/>
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </sf:form>
</body>
</html>
