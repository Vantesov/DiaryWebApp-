<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Utils.DBRecordsService" %>

<head>
	<meta charset="utf-8">
	<style type="text/css">
		<%@include file="/views/style.css"%>
	</style>
</head>	
<body>
	<form method="post" action="/Diary/pool/editing">
		<div class="body">
			<div class="editing">
					<h1>Diary</h1>

					<%if(request.getParameter("check") == "InsertError"){%>
					<h2>InsertError</h2>
					<%}%>

					<%
					    boolean isUpdating = (boolean) session.getAttribute("isUpdating");
					    if(isUpdating == true){ 
					    	int id = (int) session.getAttribute("updatingId");
					        ResultSet rs = DBRecordsService.selectRecordById(id);
						    String text = "";
						    try {
						        while (rs.next()){
						            text = rs.getString(3);
						        }

						    } catch (SQLException e) {
						        throw new RuntimeException(e);
						    }
					%>
					<textarea cols="60" rows="50" name="record"><%=text%></textarea>
					<%} else {%>
					<textarea cols="60" rows="50" name="record"></textarea>
					<%}%> 
					<p><button type="submit">Save</button></p>
			</div>
		</div>
	</form>
</body>