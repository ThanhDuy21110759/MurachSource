<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.GregorianCalendar, java.util.Calendar"%>
<%
	GregorianCalendar currentDay = new GregorianCalendar();
	int currentYear = currentDay.get(Calendar.YEAR);
%>
	<br>
	<strong>&copy; Copyright <%= currentYear %> Mike Murach &amp; Associates</strong>
</body> 
</html>