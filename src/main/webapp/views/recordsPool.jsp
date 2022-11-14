<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="Utils.DBRecordsService" %>


<html>
	<head>
		<style type="text/css">
			<%@include file="/views/style.css"%>
		</style>
	</head>
	<body>
		<%
		    int id = (int) session.getAttribute("user_id");

	        ResultSet rs = DBRecordsService.selectRecordsByUeserId(id);
	        ArrayList<String> list = new ArrayList<>();
	        ArrayList<Integer> idList = new ArrayList<>();
	        try {
	            while (rs.next()){
	                list.add(rs.getString(3));
	                idList.add(rs.getInt(1));
	            }

	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }

		%>
		<form method="post" action="/Diary/pool">
			<input type="hidden" name="form" value="form1">
			<div class="main">
				<div class="pool">

					<div class="add_button" onclick="showModal(0)">+</div>

					<% for (int i = 0; i < list.size(); i++ ) {
					%>
						
					<div class="container" onclick="showModal(<%=idList.get(i)%>)"> 
						<p><%=list.get(i)%></p>
						<div class="container_options">
							<input type="hidden" name="edit" value="<%=idList.get(i)%>">
							<button name="delete" value="<%=idList.get(i)%>" onclick="event.stopPropagation()"><b>+</b></button>
						</div>
						
					</div>
					<%}%>


				</div>
				<div class="aside">
					<button name="exit" value="exit">EXIT</button>
					<!-- <div class="tools">
						<button name="variety" value="add">ADD</button>
						<button name="variety" value="edit">EDIT</button>
						<button name="variety" value="del">DEL</button>	
					</div> -->
				</div>
			</div>
		</form>

		<div id="modal" class="modal">
			<div class="modal_content">
				<form method="post" action="/Diary/pool">
					<input type="hidden" name="form" value="form2">
					<div class="close_modal_button" onclick="hideModal()"><b>+</b></div>
					<input type="hidden" name="record_id" id="record_id_input">
					<textarea  name="record" id="textarea"></textarea>
					<p><button type="submit">Save</button></p>

				</form>
			</div>
		</div>
		<script type="text/javascript">
			<%@include file="/views/JavaScript/recordsPool.js"%>
		</script>
	</body>
</html>