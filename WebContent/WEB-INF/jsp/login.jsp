<%@ include file="includes/header.jsp" %>

<body>
	<a name="top" id="top"></a>
	<center>
		<div id="menu"></div>
	
	<h1>Login</h1>
	
	<c:if test="${!empty param.login_error}">
		<h2> <span class="error"> <spring:message code="login.invalid"/> </span></h2>
	</c:if>
	
	
	<form action="<c:url value='/j_spring_security_check'/>" method="post">
		<table>
			<tr>
				<td>Email Address:</td>
				<td><input type="text" name="j_username"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="j_password"/></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="Login"/></td>
			</tr>
		</table>
	</form>
	
	</div>
</body>

<%@ include file="includes/footer.jsp" %>