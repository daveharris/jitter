<%@ include file="includes/header.jsp" %>

<body>
	<a name="top" id="top"></a>
	<center>
		<div id="menu"></div>
		
		<%@ include file="includes/logout-fragment.jsp" %>
		
		<div id="header">
			<h1>Welcome to <%= Constants.APPLICATION_NAME %></h1>
			<img src="images/jitter.png" alt="logo" class="logo" />
		</div>
		
		<div id="content">			
			
			<p class="introduction">
				Twitter is a free social networking and micro-blogging service that allows its users to send and read other users' updates
			</p>
			
			<div id="sidebar">
				<h1>More Information</h1>
				<div class="submenu">
					<a href="home">Home</a>				  
					<a href="http://www.jitter.com">The Real Twitter</a>
					<a href="http://failwhale.com/">The Fail Whale</a>
				</div>
			</div>
			
			<div id="mainbar">
				<h2><c:out value="${user.screenName}"/>'s Details</h2>
				
				<form:form commandName="user">
								
				<table>
					<tr>
						<td><form:errors path="*" cssClass="error"/></td>
					</tr>
					<tr>
						<td>Screen Name</td>
						<td><form:input path="screenName" /></td>
						<td><form:errors path="screenName" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Email Address</td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssClass="error" /></td>
					</tr>
					<tr>
						<td>First Name</td>
						<td><form:input path="firstName" /></td>
						<td><form:errors path="firstName" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><form:input path="lastName" /></td>
						<td><form:errors path="lastName" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Avatar</td>
						<td><img src="images/avatars/${user.id}.png" alt="avatar" id="avatarImg" /></td>
						<td><form:errors path="avatar" cssClass="error" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Save Changes" id="submit" /></td>
						<script type="text/javascript"> 
							Spring.addDecoration(new Spring.ValidateAllDecoration({ elementId:'submit', event:'onclick' })); 
						</script>
					</tr>
				</table>
				</form:form>
				
			</div>
	  </div>

<%@ include file="includes/footer.jsp" %>
