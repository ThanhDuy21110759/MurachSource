<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="styles/main.css" type="text/css">
	<title>404</title>
</head>
<body>
	<h1>404 Error</h1>
	<p>The server was not able to find the file you requested.</p>
	<p>To continue, click the Back button.</p>
	<form action="survey" method="get">
		<input type="hidden" name="action" value="join">
		<input type="submit" value="Return">		
	</form>
</body>
</html>