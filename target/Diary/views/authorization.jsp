<html>
	<head>
		<style type="text/css">
			<%@include file="/views/style.css"%>
		</style>
	</head>
<body>
	<form method="post" action="/Diary/authorization">
		<div class="body">
			<div class="window">
					<h1>Diary</h1>
					<%
					    if(request.getAttribute("check")!= null){
					        if(request.getAttribute("check") == "loginError"){out.println("Login or password is wrong!");}
					    }
					%>
					<p><input type="text" name="login"></p>
					<p><input type="password" name="password"></p>
					<p><button type="submit">Log in</button></p>
				
				<p><a href="/Diary/sign_up">sign up</a></p>
			</div>
		</div>
	</form>
</body>
</html>