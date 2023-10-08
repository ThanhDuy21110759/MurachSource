<%@include file="/includes/header.jsp" %>
    <h1>Thanks for taking our survey!</h1>

    <p>Here is the information that you entered:</p>

    <label>Email:</label>
    <span>${user.email}</span><br>
    <label>First Name:</label>
    <span>${user.firstName}</span><br>
    <label>Last Name:</label>
    <span>${user.lastName}</span><br>
    <label>Date of Birth:</label>
    <span>${user.birth}</span><br>
    <label>Heard From:</label>
    <span>${user.heardFrom}</span><br>
    <label>Updates:</label>
    <span>${user.wantsUpdates}</span><br>
    <label>Send mail:</label>
    <span>${user.getWantsSendMail()}</span><br>    
    <!-- Using JSTL for check wantSendMail -->
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	 <c:if test="${user.wantsSendMail == 'Yes'}">
        <label>Contact Via:</label>
        <span>${user.contactVia}</span>
    </c:if>
	<br><br>
	<form action="" method="get">
		<input type="hidden" name="action" value="join">
		<input type="submit" value="Return">		
	</form><br>
<%@include file="/includes/footer.jsp" %>