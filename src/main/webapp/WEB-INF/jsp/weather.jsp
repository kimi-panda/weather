<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://weather.limonova.net/functions" %>
<html>
<jsp:include page="headTag.jsp"/>
<body>
<header>Погода</header>
<br>
<section>

    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Дата, время</th>
            <th>Город</th>
            <th>Сервис</th>
            <th>Температура</th>
        </tr>
        </thead>
        <c:forEach items="${weather}" var="weather">
            <jsp:useBean id="weather" scope="page" type="net.limonova.weather.model.Weather"/>
            <tr>
                <td>${fn:formatDateTime(weather.dateTime)}</td>
                <td>${weather.city.name}</td>
                <td>${weather.service.weatherServiceEnum}</td>
                <td>${weather.temperature}</td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>