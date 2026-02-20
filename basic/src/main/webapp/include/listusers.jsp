<%@ page import="java.util.List, java.util.Map" %>
<%@ include file="header.jsp" %>

<div class="content-box">

<h2 class="mb-4">
<i class="ion-ios-people"></i> User List
</h2>
<br><br>
<a href="${pageContext.request.contextPath}/include/index.jsp"
   class="btn btn-success mb-3">
Add New User
</a>
<br><br>
<table class="table table-hover table-bordered">
<thead class="table-dark">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Actions</th>
</tr>
</thead>
<tbody>

<%
List<Map<String,String>> list =
(List<Map<String,String>>) request.getAttribute("userList");

if(list != null){
for(Map<String,String> user : list){
%>

<tr>
<td><%= user.get("id") %></td>
<td><%= user.get("name") %></td>
<td><%= user.get("email") %></td>
<td>

<a href="<%= request.getContextPath() %>/home?action=EDIT&id=<%= user.get("id") %>"
   class="btn btn-warning btn-sm">
<i class="ion-edit"></i>
</a>

<a href="<%= request.getContextPath() %>/home?action=DELETE&id=<%= user.get("id") %>"
   class="btn btn-danger btn-sm"
   onclick="return confirm('Delete this user?')">
<i class="ion-trash-a"></i>
</a>

</td>
</tr>

<%
}
}
%>

</tbody>
</table>

</div>

<%@ include file="footer.jsp" %>
