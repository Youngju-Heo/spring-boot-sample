<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="city code list(${pageContext.request.contextPath})"/>
<!DOCTYPE html>
<html>
<%@ include file="../common/header.jsp" %>
<body>
<div class="main d-flex flex-column">
  <div>
    <nav class="navbar navbar-expand-lg bg-info p-1">
      <div class="container-fluid">
        <a class="navbar-brand p-0 me-0 me-lg-2" aria-label="System" title="logo"
           href="${pageContext.request.contextPath}/">
          <span style="font-size: 18pt;"><i class="bi bi-bank"></i></span>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">Home</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown"
                 aria-expanded="false">
                Dropdown
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li>
                  <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled">Disabled</a>
            </li>
          </ul>
          <form class="d-flex" role="search">
            <input class="form-control" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success mx-2" type="submit">Search</button>
          </form>
        </div>
      </div>
    </nav>
  </div>

  <jsp:include page="./city-item-list.jsp">
    <jsp:param name="name" value="entity.city.name"/>
    <jsp:param name="mode" value="view"/>
  </jsp:include>
</div>
</body>
</html>
