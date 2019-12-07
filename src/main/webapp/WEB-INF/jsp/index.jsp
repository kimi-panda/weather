<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="headTag.jsp"/>
<body>
<header>Тестовое задание</header>
<br>
<section>
    <form method="post" action="weatherList">
        Город: <select name="cityId">
        <option value="100000" selected>Якутск</option>
        <option value="100001">Челябинск</option>
    </select>
        Погодный сервис: <select name="weather_resource">
        <option value="100002" selected>Gismeteo</option>
    </select>
        <button type="submit">Выбрать</button>
    </form>
</section>
</body>
</html>