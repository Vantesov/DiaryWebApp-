<html>
<body>
<%
    if(request.getAttribute("check")!= null){
        if(request.getAttribute("check") == "loginError"){out.println("Login or password is wrong!");}
    }
%>
<form method="post" action="/Diary/authorization">
	<input type="text" name="login">
	<input type="password" name="password">
	<button type="submit">Log in</button>
</form>
<p><a href="/Diary/sign_up">sign up</a></p>
</body>
</html>