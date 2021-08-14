<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

First Name: ${student.firstName}
<br><br>
Last Name: ${student.lastName}
<br><br>
City: ${student.city }
<br><br>
Favorite Language: ${student.favoriteLanguage }

<br><br>

Operating System: 

<ul>
	<c:forEach var="temp" items="${student.operatingSystem}">
	<li>${temp}</li>
	</c:forEach>
</ul>
</body>
</html>