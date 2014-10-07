<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage = "quoteErrors.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Stock Price</title>
</head>

<body>

 Enter a stock symbol:
 
 <%--<jsp:useBean id="Quote" class="com.practicaljava.lesson28.beans.QuoteBean" />--%>
 
 <%--<Form action=http://localhost:8081/lesson27/GetQuote method=Get> --%>
 <Form action=GetPrice.jsp method=post>
 <input type=Text name = symbol>
 <input type=Submit value="Get price">
 </Form>
 
</body>
</html>