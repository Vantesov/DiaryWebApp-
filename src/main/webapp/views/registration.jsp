<html>
<body>
<%
    if(request.getAttribute("check")!= null){
        if(request.getAttribute("check") == "userError"){out.println("User creation error!");}
        if(request.getAttribute("check") == "loginError"){out.println("This password is already used!");}
    }
%>
<form method="post" action="/Diary/sign_up">
	<input type="text" name="login">
	<input type="password" name="password">
	<button type="submit">Sign up</button>
</form>
</body>
</html>