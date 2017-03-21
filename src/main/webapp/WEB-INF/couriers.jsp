<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<%@ include file="/WEB-INF/include/navbar.jsp"%>

<c:url value="/couriers/delete" var="deleteCourierURL" />
<c:url value="/couriers/edit" var="editCourierURL" />

<div class="container">

	<h1>List of couriers</h1>

	<div class="row">
		<div class="col-md-12">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center col-md-1">Id</th>
						<th class="text-center">First Name</th>
						<th class="text-center">Last Name</th>
						<th class="text-center">Email</th>
						<th class="text-center col-md-1">Edit</th>
						<th class="text-center col-md-1">Delete</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${couriersList}" var="courier">
						<tr>
							<td>${courier.id}</td>
							<td>${courier.getFirstName()}</td>
							<td>${courier.lastName}</td>
							<td>${courier.email}</td>
							<td><a href="${editCourierURL}/${courier.id}"							
								class="btn btn-primary">Edit</a></td>
							<td><a href="${deleteCourierURL}/${courier.id}"
								class="btn btn-danger delete-btn">Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>

</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>

<script>
	$(document).ready(
			function() {
				console.log("Page loaded");

				$('.delete-btn').on(
						'click',
						function(event) {
							event.preventDefault();
							console.log("Przycisk klikniety, a jego href to: "
									+ event.target.href);

							// $.
							// jQuery.

							setTimeout(function() {
								$.post(event.target.href).done(function() {
									location.reload();
								});
							}, 1000);
						});
			});
</script>