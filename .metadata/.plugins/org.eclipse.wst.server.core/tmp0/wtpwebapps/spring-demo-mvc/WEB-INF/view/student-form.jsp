<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Form</title>
</head>

<body>
<form:form action="processForm" modelAttribute="student">

First Name: <form:input path ="firstName" />

<br><br>

Last Name: <form:input path ="lastName" />
<br><br>
<form:select path="city">
	<form:options items="${student.cityOptions }"></form:options>
</form:select>

<br><br>
Favorite Language:

Java <form:radiobutton path="favoriteLanguage" value="Java" />

C# <form:radiobutton path="favoriteLanguage" value="C#" />

PHP <form:radiobutton path="favoriteLanguage" value="PHP" />

Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />
<br><br>
Operating System:

Linux <form:checkbox path="operatingSystem" value="Java" />

MacOS <form:checkbox path="operatingSystem" value="C#" />

Microsoft <form:checkbox path="operatingSystem" value="PHP" />


<br><br>

<input type="submit" value="Bam de"/>

</form:form>


</body>
</html>