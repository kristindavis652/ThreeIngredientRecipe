<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<html lang="en">
<head>
<link href="https://fonts.googleapis.com/css?family=Montserrat:200&display=swap" rel="stylesheet">
<title>Three Ingredient Recipe</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: 'Montserrat', sans-serif;
  margin: 0;
}

.header {
  padding: 25px;
  text-align: center;
  background: #262626;
  color: MediumAquaMarine;
  font-size: 35px;
}
.content {padding:20px;}
</style>
</head>
<body>

<div class="header">
  <h1>THREE INGREDIENTS</h1>
  <p>ONE SIMPLE RECIPE.</p>
</div>
  <head>
    <title>${userRecipe.recipeName} ${userRecipe.instructions}</title>
  </head>
  <body>
    <h1>${userRecipe.recipeName}</h2>


    <c:forEach items="${userRecipe.ingredients}" var="ingredient" >
     ${ingredient}
     <br>
    </c:forEach>




    <h3>${userRecipe.instructions}</h3>
  </body>
</html>


