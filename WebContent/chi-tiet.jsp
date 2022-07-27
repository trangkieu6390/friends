<%@page import="model.bean.DanhSachBanBe"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp"%>

<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">
				 <div class="content-grid">
				 <%
				 	DanhSachBanBe objBB = (DanhSachBanBe)request.getAttribute("objBB");
				 	DanhMucBanBe danhMucBanBe = (DanhMucBanBe)request.getAttribute("danhMucBanBe");
				 	ArrayList<DanhSachBanBe> listBB = (ArrayList<DanhSachBanBe>)request.getAttribute("listFrd");
				 %>
					 <div class="content-grid-head">
					
						 <h3><%=danhMucBanBe.getFlname() %></h3>
						 <h4>Đăng ngày: <%=objBB.getDate_create() %> - Lượt xem: <%=objBB.getCount_number() %></h4>
						 <div class="clearfix"></div>
					 </div>
					 <div class="content-grid-single">
					 <%
				 			if(objBB != null){
						 %>
						 <h3><%=objBB.getFlname() %></h3>
						 <div class="detail_text">
							 <span><%=objBB.getPreview_text() %></span>
							 <img class="single-pic" src="images/anh1.jpg" alt="">
							 <p><%=objBB.getDetail()%></p>
						 </div>
					<%} %>
						 <div class="comments">
							 <h3>Bạn thân khác của tôi</h3>
							 
							 <div class="comment-grid">
							 <%
				 
								if(listBB!=null){
					 			for(DanhSachBanBe objBB2: listBB){
				
							 %>
								 <img src="images/anh2.jpg" alt="">
								 <div class="comment-info">
								 <h4><a href="<%=request.getContextPath()%>/chi-tiet?did=<%=objBB2.getFid()%>&fl_id=<%=objBB2.getFl_id()%>"><%=objBB2.getFlname() %></a></h4>
								 <p><%=objBB2.getPreview_text() %></p>
								 </div>
								  <%}}%>
								 <div class="clearfix"></div>
								
							 </div>
							 
						
						</div>
					  </div>
					 
				 </div>			 			 
			 </div>
			 
					 <%@include file="/inc/left_bar.jsp"%>

		 </div>
	 </div>
</div>

<%@include file="/inc/footer.jsp"%>
