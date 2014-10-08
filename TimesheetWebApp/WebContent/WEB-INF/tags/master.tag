<%@tag description="Master Tag Template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/overtime.css" />
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js" type="text/javascript"></script>
		<title>TP Overtime App</title>
	</head>
	<body class="page-homepage">
		<header>
			<p style="font-size: 16px">This is the header</p>
			${loggedInUser}
			<c:if test="${ not empty loggedInUser}">
				<p><a href="#" id="ajax_logout">Logout</a></p>
			</c:if>
		</header>
		<jsp:doBody/>
		<footer><p style="font-size: 16px">This is the footer</p>	
		</footer>
		
		<script type="text/javascript">
		
		$("#ajax_logout").click(function(e) {
			
			e.preventDefault();
			$.ajax({
			  type: "GET",	
			  url: 'LogoutController',
			  cache: false
			}).done(function() {
			  window.location = "${pageContext.request.contextPath}/jsp/index.jsp";
			});
		});
		</script>
	</body>
</html>