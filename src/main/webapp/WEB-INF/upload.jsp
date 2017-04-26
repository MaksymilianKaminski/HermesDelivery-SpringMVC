<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<%@ include file="/WEB-INF/include/navbar.jsp"%>

<c:url value="/updateAdmin" var="updateAdminURL" />


<html>

<body>
<div class="container ">
<h1>File upload</h1>

<label class="btn btn-primary" for="my-file-selector">
<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
    <input type="file"  name="file" /><br/>        
    <input type="submit" value="upload" class="btn-success btn-block btn-lg" />
</form>
</label>
</div>
</body>
</html>

<%@ include file="/WEB-INF/include/footer.jsp"%>