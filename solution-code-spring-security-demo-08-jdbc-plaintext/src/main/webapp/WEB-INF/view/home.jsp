<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
	<title>Ifisolution Devops Fresher Page</title>
</head>

<body>
	<h2>Ifisolution Devops Fresher Page</h2>
	<hr>
	
	Welcome to the Ifisolution Devops Fresher Page!
	
	<hr>
	<p> 
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	<hr>
	
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for Manager peeps)
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT systems Meeting</a>
			(Only for Admin peeps)
		</p>
	</security:authorize>


	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>

</html>