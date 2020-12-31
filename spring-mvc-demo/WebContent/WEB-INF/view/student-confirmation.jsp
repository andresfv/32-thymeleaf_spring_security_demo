<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<title>Pantalla de Confirmacion</title>
</head>
<body>
       El estudiante ${student.firstName} ${student.lastName} de ${student.country} fue ingresado correctamente
       
       <br><br>
       
       Lenguage de programación favorito: ${student.language}
       
        <br><br>
       
      Sistemas Operativos:
      <ul>
        <c:forEach var="temp" items="${student.operationSystem }">
         <li>${temp}</li>
        </c:forEach>
      </ul>
       
</body>
</html>