
<%@page import="model.bean.DanhSachBanBe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp"%>
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">				 
				 <h1 class="title">Những người bạn</h1>
				 <%
				 	ArrayList<DanhSachBanBe> listBB = (ArrayList<DanhSachBanBe>)request.getAttribute("listBB");
				 	if(listBB != null){
				 		for(DanhSachBanBe objBB : listBB){
				 %>
				 <div class="content-grid-sec">
					 <div class="content-sec-info">
							 <h3><a href="<%=request.getContextPath()%>/chi-tiet?did=<%=objBB.getFid()%>&fl_id=<%=objBB.getFl_id()%>"><%=objBB.getFlname() %></a></h3>
							 <h4>Đăng ngày: <%=objBB.getDate_create() %> - Lượt xem: <%=objBB.getCount_number() %></h4>
							 <p><%=objBB.getPreview_text() %></p>
							 <img src="images/anh1.jpg" alt=""/>
							 <a class="bttn" href="<%=request.getContextPath()%>/chi-tiet?did=<%=objBB.getFid()%>">Chi tiết bạn tôi</a>
					 </div>
				 </div>
				<%} }%>
				 <%@include file="/inc/main.jsp"%>		 
			 </div>
			 
			 
			 <%@include file="/inc/left_bar.jsp"%>
		 </div>
	 </div>
</div>
<%@include file="/inc/footer.jsp"%>

