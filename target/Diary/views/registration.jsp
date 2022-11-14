<html>
	<head>
		<style type="text/css">
			<%@include file="/views/style.css"%>
		</style>
	</head>
<body>

	<form method="post" action="/Diary/sign_up">
		<div class="body">
			<div class="window">
				<h1>Diary</h1>
				<%
					if(request.getAttribute("check")!= null){
					    if(request.getAttribute("check") == "userError"){out.println("User creation error!");}
					    if(request.getAttribute("check") == "loginError"){out.println("This password is already used!");}
					}
				%>
				<p><input type="text" name="login"></p>
				<p><input type="password" name="password"></p>
				<p><button type="submit">Sign up</button></p>
			</div>
		</div>
	</form>
</body>
</html>