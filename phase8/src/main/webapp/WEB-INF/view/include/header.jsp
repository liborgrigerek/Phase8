<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Morosystems phase 8</title>
</head>
<body>
    <%@ include file="/WEB-INF/view/info.jsp" %>
<section>
    <div class="jumbotron">
        <div class="container">
            <h2>User Management Screen</h2>
            <p><spring:message code="header.welcome"/></p>
        </div>
    </div>
</section>
    