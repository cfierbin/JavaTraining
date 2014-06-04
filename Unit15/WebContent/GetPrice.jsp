<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page errorPage = "quoteErrors.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stock Prices</title>
</head>
<body>

    <jsp:useBean 
      id = "Quote"
      class = "com.practicaljava.lesson28.beans.QuoteBean">
      <jsp:setProperty name="Quote" property="*" />
    </jsp:useBean>
    
    <%
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumFractionDigits(2);
    nf.setMinimumFractionDigits(2);
	%>

	The price for
	<font color=red> <jsp:getProperty name="Quote" property="symbol" />
	</font> is:
	<font color=red> <jsp:getProperty name="Quote" property="price" />
	</font>

</body>
</html>