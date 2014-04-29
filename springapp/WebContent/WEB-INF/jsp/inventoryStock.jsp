<html>
<head><title><fmt:message key="title"/></title></head>
<body>
<h1><fmt:message key="heading"/></h1>
<p> <fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
<c:forEach items="${model.products}" var="product">
<p>Je suis passe dans la boucle</p>
<c:out value="${product.description}"/> <i>$<c:out value="${product.price}"/></i> <br><br> 
</c:forEach>
<br>
    <a href="<c:url value="priceincrease.htm"/>">Increase Prices</a>
    <br>
</body>
</html>