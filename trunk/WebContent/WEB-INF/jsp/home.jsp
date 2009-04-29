<%@ include file="includes/header.jsp"%>

<script type="text/javascript">
	function updateCharCounter() {
		var field = document.getElementById("body");
		var count = document.getElementById("charsLeft");
		var max = 140;
		if (field.value.length > max)
			count.value=field.value.substring(0, max);
		else
			count.value=max - field.value.length;
	}
</script>

<body class="account replyable firefox" id="home">
	<%@ include file="includes/logout-fragment.jsp"%>

	<div id="container" class="subpage">
		<span id="loader" style="display: none">
			<img alt="Loader" src="http://assets0.twitter.com/images/loader.gif" />
		</span>

		<h1 id="header">
			<a href="/home" title="Twitter: home" accesskey="1" id="logo">
				<img alt="Twitter.com" height="36" src="images/logo.png" width="155" />
			</a>
		</h1>

	<div class="content-bubble-arrow"></div>
	
	<table cellspacing="0" class="columns">
		<tbody>
	
			<tr>
				<td id="content" class="round-left column">
					<div class="wrapper">
				
					<%--form action="http://twitter.com/status/update" class="status-update-form" id="status_update_form" method="post"--%>
					<form:form commandName="post" cssClass="status-update-form" id="status_update_form">
						<div style="margin: 0; padding: 0">
							
						<fieldset class="common-form standard-form">
							<div class="bar">
							<h3><label for="status" class="doing">What are you doing?</label></h3>
							<span id="chars_left_notice" class="numeric"> <strong
								id="status-field-char-counter" class="char-counter"></strong> </span></div>
							<div class="info"><textarea cols="40" rows="2" id="status"
								name="status" accesskey="u"></textarea>

								<div class="status-btn">
									<input type="submit" name="update" value="update" id="update-submit" class="status-btn round-btn" />
								</div>
								<div id="currently">
									<strong>Latest:</strong><br />
	
									<c:forEach var="post" items="${model.posts}">
										<span id="latest_text_full">
											<span class="status-text">
												<c:out value="${post.body}" />
											</span>
											
											<span class="entry-meta">
												<a href="userDetails.htm?id=${post.author.id}" class="entry-date" rel="bookmark">
													<span class="published">by &#64;<c:out value="${post.author.screenName}" /></span>
												</a>
												<a href="status.htm?id=${post.id}" class="entry-date" rel="bookmark">
													<span class="published">on <c:out value="${post.dateString}" /></span>
												</a>
												<span>from web</span>
											</span>
										</span>
										<br /><br />
									</c:forEach>
								</div>
							</div>
						</fieldset>
					</form:form>
				
		
					<div class="tab">
						<ol class="statuses" id="timeline">
							
							<c:forEach var="post" items="${model.posts}">
								<li>
									<span id="latest_text_full">
										<span class="status-text">
											<c:out value="${post.body}" />
										</span>
										
										<span class="entry-meta">
											<a href="userDetails.htm?id=${post.author.id}" class="entry-date" rel="bookmark">
												<span class="published">by &#64;<c:out value="${post.author.screenName}" /></span>
											</a>
											<a href="status.htm?id=${post.id}" class="entry-date" rel="bookmark">
												<span class="published">on <c:out value="${post.dateString}" /></span>
											</a>
											<span>from web</span>
										</span>
									</span>
								</li>
							</c:forEach>
						</ol>
						
						<div class="bottom-nav">
					    <div id="pagination">
					    	<%--a href="/home?max_id=1644126710&amp;page=2&amp;twttr=true" class="round more" id="more" rel="next">more</a--%>
					    </div>
					  </div>
					</div>
		
					<img alt="Icon_star_full" src="images/icon_star_full.gif" style="display:none;" />
			   
			     <td id="side_base" class="column round-right">
			       <div id="side">
							<div id="profile" class="section">
								<div class="user_icon">
			    				<a href="http://twitter.com/gnubie" class="url" rel="contact" title="gnubie">
			    					<img alt="gnubie" class="side_thumb photo fn" height="48" src="http://s3.amazonaws.com/twitter_production/profile_images/53784458/Me_normal.jpg" width="48" />
			    				</a>
			    				<p id="me_name">gnubie</p>
								</div>
								
								<div class="stats">
								  <table>
								    <tr>
								      <td>
												<a href="/friends" id="following_count_link" class="link-following_page" rel="me" title="See who youre following">
								  				<span id="following_count" class="stats_count numeric">10 </span>
								  				<span class="label">Following</span>
												</a>
											</td>
								      <td>
												<a href="/followers" id="follower_count_link" class="link-followers_page" rel="me" title="See whos following you">
												  <span id="follower_count" class="stats_count numeric">6 </span>
												  <span class="label">Followers</span>
												</a>								
											</td>
											<td>
												<a href="/gnubie" class="link-updates" title="See all your updates" rel="me">
													<span id="update_count" class="stats_count numeric">15</span>
													<span class="label">updates</span>
      									</a>
      								</td>
									  </tr>
									</table>
								</div>
								
								<ul id="tabMenu">
								  <li><a href="/home" id="home_tab">Home</a></li>
								  <li><a href="/replies" id="replies_tab">@gnubie</a></li>
								  <li><a href="/direct_messages" id="direct_messages_tab"><span id="message_count" class="stat_count">1</span> Direct Messages</a></li>
								  <li><a href="/favorites" id="favorites_tab">Favorites</a></li>
								
								  <li><a href="/public_timeline" id="public_timeline_tab">Everyone</a></li>
								</ul>
								
							</div>
						</div>
					</td>
					
				</tr>
			</tbody>
		</table>			

<%-- 
			<div id="header"><img alt="Twitter.com" height="36"
				src="images/logo.png" width="155" /></div>

			<div id="content">

			<p class="introduction">Twitter is a free social networking and
			micro-blogging service that allows its users to send and read other
			users' updates</p>

			<div id="sidebar">
			<h1>More Information</h1>
			<div class="submenu"><a href="home.htm">Home</a> <a
				href="http://www.twitter.com">The Real Twitter</a> <a
				href="http://failwhale.com/">The Fail Whale</a></div>
			</div>

			<div id="mainbar"><c:if test="${!empty model.message}">
				<h3 id="message"><c:out value="${model.message}" /></h3>
			</c:if>

			<h2 id="intro">What are you doing?</h2>
			<form:form commandName="post">
				<table>
					<tr>
						<td><input readonly type="text" id="charsLeft" size=2
							maxlength=3 value="140"> characters left
						<td>
					</tr>
					<tr>
						<td>
						<div id="twitterUpdate"
							onKeyDown="javascript:updateCharCounter();"
							onKeyUp="javascript:updateCharCounter();"><form:textarea
							path="body" rows="2" cols="40" /></div>
						</td>
					</tr>
					<tr>
						<td><form:errors path="body" cssClass="error" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Post!" /></td>
					</tr>
				</table>
			</form:form>

			<h2><a name="intro" id="intro"></a>Your Latest Tweets</h2>

			<c:forEach var="post" items="${model.posts}">
				<div class="tweetBox">
				<div class="tweet"><c:out value="${post.body}" /></div>

				<br />
				Posted by: <a href="userDetails.htm?id=${post.author.id}"> <c:out
					value="${post.author.screenName}" /> </a> on <c:out
					value="${post.dateString}" /></div>
			</c:forEach></div>
			</div>
			<%@ include file="includes/footer.jsp"%>
--%>

		<div id="footer"  class="round">
	    <h3 class="offscreen">Footer</h3>
	  
	    <ul>
	      <li class="first">&copy; 2009 Twitter</li>
	      <li><a href="/about#about">About Us</a></li>	
	      <li><a href="/about#contact">Contact</a></li>
	      <li><a href="http://blog.twitter.com">Blog</a></li>
	      <li><a href="http://status.twitter.com">Status</a></li>
        <li><a href="/downloads">Apps</a></li>
        <li><a href="http://apiwiki.twitter.com/">API</a></li>
	      <li><a href="http://search.twitter.com">Search</a></li>
	      <li><a href="http://help.twitter.com">Help</a></li>
	      <li><a href="/jobs">Jobs</a></li>
	      <li><a href="/tos">Terms</a></li>
	      <li><a href="/privacy">Privacy</a></li>
	    </ul>
	  </div>
	  
	  <div id="navigation">
	    <ul class="horizontal-nav top-nav round" style="display:inline">
		    <li><a href="/home" id="home_link">Home</a></li>
		    <li><a href="http://twitter.com/gnubie" id="profile_link">Profile</a></li>
		    <li><a href="http://twitter.com/invitations/find_on_twitter" id="find_people_link">Find People</a></li>
		    <li><a href="/account/settings" id="settings_link">Settings</a></li>
		    <li><a href="http://help.twitter.com" id="help_link">Help</a></li>
		    <li class="last">
		    	<a id="sign_out_link" href="/account/logout" onclick="document.getElementById('sign_out_form').submit(); return false;">Sign out</a>
		    	<%@ include file="includes/logout-fragment.jsp" %>
		    </li>
	    </ul>
  	</div>

  </body>

</html>