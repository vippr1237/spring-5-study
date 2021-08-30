<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
	<title>Ifisolution Devops Fresher Page</title>
</head>

<body>
	<h2>Ifisolution Devops Fresher Page</h2>
	<hr>
	
	Welcome to the Ifisolution Devops Fresher Page!


	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>

</html>