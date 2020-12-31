<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pantalla de confirmación de cliente</title>
</head>
<body>

Nombre: ${customer.firstName}

<br><br>
       
Apellido: ${customer.lastName}

<br><br>
       
Pases Gratis: ${customer.freePasses}

<br><br>
       
Código Postal: ${customer.postalCode}

<br><br>
       
Código del Curso: ${customer.courseCode}


</body>
</html>