<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="/css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <h2>Index page</h2>
    <a href="/admin"> admin page </a>
    <br />
    <br />
    <input type="checkbox" id="sortPrice">sort by price</input>
    <button id="apply">apply</button>
    <%--<br />--%>
    <%--<button id="sort">sort by price</button>--%>
    <%--<br />--%>
    <%--<br />--%>
    <%--<button id="reset">reset filter</button>--%>
    <br />
    <br />
    <button id="prev">prev</button> <button id="next">next</button>
    <br />
    <br />
    <div id="showPages"></div>
    <div id="showAll"></div>
    <div id="showMore">
        <button  id="more">show more</button>
    </div>
    <br />
    <br />
    <%--<img src="image/spring.jpg">--%>
    <br />
    <script src="/js/main.js"></script>
</body>
</html>
