<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.DanhMucBanBe"%>
<%@page import="model.dao.DanhMucBanBeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
			<div class="col-md-4 content-main-right">
				 <div class="search">
					<%String search = (String) request.getAttribute("searchBB"); %>
					<h3>TÌM BẠN TÔI</h3>
					<form action="<%=request.getContextPath()%>/tim-kiem" method="post">
						<input name="searchBB" type="text" value="<%if(search!=null){out.print(search);}%>"> 
						<input type="submit" value="">
					</form>

				 </div>
				 
				 <div class="categories">
					 <h3>DANH MỤC BẠN BÈ</h3>
					 <%
					 	DanhMucBanBeDao DanhMucBanBeDao = new DanhMucBanBeDao();
					 	ArrayList<DanhMucBanBe> listCat = DanhMucBanBeDao.getItems();
					 	int index = 0;
					 	for(DanhMucBanBe objDMBB : listCat){
					 	
					 %>
					 <ul>
					 	<li class="cls_li"><a href="<%=request.getContextPath()%>/danh-muc?cid=<%=objDMBB.getFl_id()%>&index_li=<%=index%>"><%=objDMBB.getFlname()%></a></li>
					 </ul>
					 
					 <% index++; }%>
				 </div>
				 
				 <div class="categories">
					 <h3>Video hành trình</h3>
					 <li class="active"><a href="danh-muc.html">Hành trình đèo Hải Vân</a></li>
					 <li><a href="danh-muc.html">Chinh phục đỉnh Fansipan</a></li>
					 <li><a href="danh-muc.html">Vượt thác Thủy Điện</a></li>
				 </div>
				 
				 <div class="archives">
					 <h3>Liên kết VinaEnter</h3>
					 <li class="active"><a href="http://vinaenter.edu.vn/lap-trinh-php-tu-az.html" target="_blank"><img width="100%" src="images/php.png" alt="" /></a></li>
					 <li><a href="http://vinaenter.edu.vn/lap-trinh-java-tu-az.html" target="_blank"><img width="100%" src="images/java.png" alt="" /></a></li>
					 <li><a href="http://vinaenter.edu.vn/lap-trinh-android-tu-az.html" target="_blank"><img width="100%" src="images/android.png" alt="" /></a></li>
				 </div>
			 </div>
			 <div class="clearfix"></div>
		 