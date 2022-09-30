<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="now" class="java.util.Date"/>
<c:set var="title" value="Main"/>
<html>
<%@ include file="./common/header.jsp" %>
<body>
<c:set var="jspMessage">
    <fmt:message key="label.jsp"/>
</c:set>

<h3>${message}</h3>
<h2><fmt:message key="label.welcome">
    <fmt:param>
        ${fn:toUpperCase(jspMessage)}
    </fmt:param>
    <fmt:param>
        <fmt:message key="label.sample"/>
    </fmt:param>
</fmt:message></h2>
<fmt:formatDate var="year" value="${now}" pattern="yyyy"/>
<p>Current year: ${year}</p>
<p>Previous year: ${year - 1}</p>
<c:forEach var="i" begin="1" end="10" step="1">
    <c:out value="${i}"/>
    <br/>
</c:forEach>
<div id="powered">
    Powered by <img src="images/kotlin.svg" height="32px" alt="JAVA logo"/> and <img src="images/bootstrap.svg"
                                                                                     height="32px"
                                                                                     alt="Bootstrap logo"/>
</div>
<button id="show" style="display: none;">undo</button>

</body>
</html>
<script>
    $(window).resize(function () {
        console.log("resized windows", window.innerWidth, window.innerHeight);
    });
    $("#powered").click((evt) => {
        console.log(`click`, evt);
        $("#powered").hide();
        $("#show").show();
    })
    $("#show").click(() => {
        $("#powered").show();
        $("#show").hide();
    })
</script>
