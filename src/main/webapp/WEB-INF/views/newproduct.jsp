<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add laptop</title>
    <meta charset="UTF-8"/>
</head>
<body>

    <form action="/addProduct" method="post" enctype="multipart/form-data">
        <p>Add new laptop</p>
        <input type="text" name="laptopModel" placeholder="laptop model" pattern="[A-Za-z0-9_-]+" title=" A-Za-z0-9_- " required/>
        <input type="text" name="price" placeholder="price" pattern="[0-9.]+" title="0-9." required/>
        <input type="text" name="producer" placeholder="producer" pattern="[A-Za-z0-9_-]+" title=" A-Za-z0-9_- " />
        <select name="typeProcessor">
            <option value="Intel" selected>Intel</option>
            <option value="AMD">AMD</option>
        </select>
        <input type="text" name="processor" placeholder="processor" pattern="[0-9.]+" title=" 0-9. " />
        <input type="text" name="screenDiagonal" placeholder="screen diagonal " pattern="[0-9.]+" title=" 0-9. "/>
        <br/>
        <input type="text" name="amountOfRAM" placeholder="amount of RAM" pattern="[0-9]+" title=" 0-9 " />
        <input type="text" name="numberOfslotsForRAM" placeholder="number Of slots For RAM" pattern="[0-9]+" title=" 0-9 "/>
        <input type="text" name="typeOfRAM" placeholder="type Of RAM" pattern="[A-Za-z0-9_-]+" title=" A-Za-z0-9_- " />
        <input type="text" name="driveCapacity" placeholder="drive capacity" pattern="[0-9]+" title=" 0-9 "/>
        <input type="text" name="chipset" placeholder="chipset" pattern="[A-Za-z0-9_-]+" title=" A-Za-z0-9_- " />
        <br/>
        <input type="text" name="graphicAdapter" placeholder="graphic adapter" pattern="[A-Za-z0-9_-]+" title=" A-Za-z0-9_- " />
        <input type="text" name="networkAdapters" placeholder="network Adapters" pattern="[A-Za-z0-9, _-]+" title=" A-Za-z0-9, _- " />
        <input type="text" name="ioConnectorsAndPorts" placeholder="io Connectors And Ports" pattern="[A-Za-z0-9, _-]+" title=" A-Za-z0-9, _- " />
        <input type="text" name="battery" placeholder="battery" pattern="[A-Za-z0-9_-]+" title="A-Za-z0-9_-"/>
        <input type="text" name="batteryFeatures" placeholder="battery features" pattern="[A-Za-z0-9_-]+" title=" A-Za-z0-9_- "/>
        <br/>
        <textarea rows="5" cols="55" name="briefCharacteristics" placeholder="descripton" maxlength="250" pattern="[A-Za-z0-9,. _-]+" title=" A-Za-z0-9,. _- " required></textarea>
        <br />
        <input type="file" name="file">
        <br/>
        <input type="submit" value="Add"/>
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>

    <a href="/admin"> admin page </a>
    <br />
    <a href="/"> index page </a>
</body>
</html>
