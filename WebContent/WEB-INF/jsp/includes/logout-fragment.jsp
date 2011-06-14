<div>
	<p>
		<security:authorize ifAllGranted="ROLE_ADMIN">
			<a href="<c:url value="/j_spring_security_logout"/>">Logout</a> (<security:authentication property="principal.username"/>)
		</security:authorize>
	</p>
</div>