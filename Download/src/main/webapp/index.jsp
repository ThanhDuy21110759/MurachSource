<%@include file="/includes/header.jsp" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:if test = "${cookie.emailCookie.value != null}">
        <p>Welcome back: ${cookie.emailCookie.value}</p>
    </c:if>
    
	<h1>List of albums</h1>	
	
	<p>
		<a href="download?action=checkUser&amp;productCode=8601">
			86 (the band) - True Life Songs and Pictures
		</a><br>
		
		<a href="download?action=checkUser&amp;productCode=pf01">
			Paddlefoot - The First CD
		</a><br>
		
		<a href="download?action=checkUser&amp;productCode=pf02">
			Paddlefoot - The Second CD
		</a><br>
		
		<a href="download?action=checkUser&amp;productCode=jr01">
			Joe Rut - Genuine Wood Grained Finish
		</a>
	</p>	
<%@include file="/includes/footer.jsp" %>
