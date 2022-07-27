<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp"%>
<div class="contact">
	<div class="container">
		<div class="contact-head">
		
			<h3>Liên hệ</h3>
			
			<form action="<%=request.getContextPath()%>/lien-he" method="post">
				<div class="col-md-6 contact-left">
					<input name= "Name" type="text" placeholder="Name" required="" > 
					<input name= "E-mail" type="text" placeholder="E-mail" required="" > 
					<input name= "Phone" type="text" placeholder="Phone" required="" >
				</div>
				<div class="col-md-6 contact-right">
					<textarea name= "Message" placeholder="Message" ></textarea>
					<input type="submit" value="SEND">
				</div>
				<div class="clearfix"></div>
			</form>
			<%
			if(request.getParameter("msg")!=null){
				int msg = Integer.parseInt(request.getParameter("msg"));
				if(msg == 1){
					out.print("<p style = 'color: red;'>Gui TT thanh cong</p>");
				}
			}
		%>
		</div>
	</div>
</div>

<%@include file="/inc/footer.jsp"%>