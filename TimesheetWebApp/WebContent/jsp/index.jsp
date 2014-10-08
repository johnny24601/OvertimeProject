<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:master>
	<c:if test="${empty loggedInUser }">
		<div class="center">
		    <form class="loginForm" method="POST" action="../LoginController">
		  		<label for="username">Username</label>
		  		<input id="username" type="text" name="username">
		  		<label for="password">Password</label>
		  		<input id="password" type="password" name="password">
		  		<input class="loginButton" type="submit" name="login" value="login">
			</form>
		</div>
	</c:if>
</t:master>	
	