<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pantalla de confirmaci�n de cliente</title>
</head>
<body>

Nombre: ${customer.firstName}

<br><br>
       
Apellido: ${customer.lastName}

<br><br>
       
Pases Gratis: ${customer.freePasses}

<br><br>
       
C�digo Postal: ${customer.postalCode}

<br><br>
       
C�digo del Curso: ${customer.courseCode}


</body>
</html>