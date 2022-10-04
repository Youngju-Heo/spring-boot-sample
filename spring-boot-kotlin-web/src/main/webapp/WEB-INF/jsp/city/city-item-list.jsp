<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cityItems" scope="request" type="java.util.List"/>
<h3><fmt:message key="${param.name}"/></h3>
<div class="flex-grow-1">
  <table class="table table-bordered table-hover">
    <thead>
    <tr>
      <th scope="col"><fmt:message key="entity.city.id"/></th>
      <th scope="col"><fmt:message key="entity.city.country"/></th>
      <th scope="col"><fmt:message key="entity.city.state"/></th>
      <th scope="col"><fmt:message key="entity.city.name"/></th>
      <th scope="col"><fmt:message key="entity.city.insTime"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${cityItems}">
      <tr>
        <td><c:out value="${item.id}"/></td>
        <td><c:out value="${item.country}"/></td>
        <td><c:out value="${item.state}"/></td>
        <td><c:out value="${item.name}"/></td>
        <td><c:out value="${item.insTime}"/></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

mode: <c:out value="${param.mode}"/>
