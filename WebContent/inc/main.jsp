<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="pages">
	<%
		Object number_page = request.getAttribute("number_page"); 
		Object index_page1 = request.getAttribute("index_page");
		String searchBB = (String)request.getAttribute("searchBB"); 
		if(searchBB == null){ searchBB = "";}
	
		int index_page= Integer.parseInt(index_page1.toString());
		
		if(number_page != null){
			int i = Integer.parseInt(number_page.toString());
			
		
	%>
	<ul style="list-style-type: none; display: inline;">
		<%
			
			if(i >= 1){
			for(int i1 = 1; i1 <= i; i1++) {
				if(index_page == i1){
		
		%>
		<li class="clor"><a
			href="<%=request.getContextPath()%>/tim-kiem?index_page=<%=i1%>&searchBB=<%=searchBB%>"><%=i1 %></a>
		</li>
		<%}else{%>
		<li><a
			href="<%=request.getContextPath()%>/tim-kiem?index_page=<%=i1%>&searchBB=<%=searchBB%>"><%=i1 %></a>
		</li>
		<%}}}else{%>
		<li><a
			href="<%=request.getContextPath()%>/tim-kiem?index_page=<%=1%>&searchBB=<%=searchBB%>"><%=1 %></a>
		</li>
		<%}if(i>= 2){if(index_page>1){ %>
		<li class="cls_li"><a
			href="<%=request.getContextPath()%>/tim-kiem?index_page=<%=(index_page-1)%>&searchBB=<%=searchBB%>">Pre</a>

		</li>
		
		<%}} if(i >= 2){if(index_page>= 1 && index_page < i){%>
		
		<li class="cls_li"><a
			href="<%=request.getContextPath()%>/tim-kiem?index_page=<%=(index_page+1)%>&searchBB=<%=searchBB%>">Next</a>

		</li>
		<%} else if(index_page == 1){%>
		<li class="cls_li"><a
			href="<%=request.getContextPath()%>/tim-kiem?index_page=<%=i%>&searchBB=<%=searchBB%>">Next</a>

		</li>
		<%}} }%>
	
	
</div>