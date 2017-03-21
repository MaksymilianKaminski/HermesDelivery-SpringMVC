<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<%@ include file="/WEB-INF/include/navbar.jsp"%>

<c:url var="createPackUrl" value="/pack/save" />

<div class="container">

	<h1>Add pack</h1>

	<div class="row">
		<form:form commandName="pack" action="${createPackUrl}" method="post"
			role="form" class="form-horizontal">
			<form:hidden path="id" />
			<div class="form-group">
				<label class="control-label col-sm-2" for="country">Country:</label>
				<div class="col-sm-6">
					<form:input path="country" type="text" id="country"
						class="form-control" placeholder="Enter country"
						autofocus="autofocus" />
					<form:errors path="country" cssStyle="color: red" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="area">Area:</label>
				<div class="col-sm-6">
					<form:input path="area" type="text" id="area" class="form-control"
						placeholder="Enter area" />
					<form:errors path="area" cssStyle="color: red" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="available">Count:</label>
				<div class="col-sm-6">
					<form:input path="available" type="number" id="available"
						class="form-control" placeholder="Enter available" />
					<form:errors path="available" cssStyle="color: red" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-6">
					<button type="submit" class="btn btn-primary">Save</button>
					<a href="${packsUrl}" class="btn btn-danger">Cancel</a>
				</div>
			</div>
		</form:form>
	</div>

</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>