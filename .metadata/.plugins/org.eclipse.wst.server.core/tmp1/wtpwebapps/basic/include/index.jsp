<%@ include file="header.jsp" %>

<div class="content-box">

<h2 class="mb-4">
<i class="ion-ios-person"></i> Add / Update User
</h2>

<form action="${pageContext.request.contextPath}/home" method="post">

<input type="hidden" name="id" value="${id}">
<input type="hidden" name="action"
value="${id != null ? 'UPDATE' : 'INSERT'}">

<div class="mb-3">
<label>Name</label>
<input type="text" name="name"
       value="${name}" class="form-control" required>
</div>

<div class="mb-3">
<label>Email</label>
<input type="email" name="email"
       value="${email}" class="form-control" required>
</div>
<br><br>
<button type="submit" class="btn btn-primary">
Save User
</button>

<a href="${pageContext.request.contextPath}/home"
   class="btn btn-dark">
View Users
</a>

</form>

</div>

<%@ include file="footer.jsp" %>
