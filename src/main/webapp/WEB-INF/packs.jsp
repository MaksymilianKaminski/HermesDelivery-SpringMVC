<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<%@ include file="/WEB-INF/include/navbar.jsp"%>

<c:url value="/pack/edit" var="editPackUrl" />
<c:url value="/pack/delete" var="deletePackUrl" />

<c:url value="/order/pack" var="orderUrl" />

<div class="container">

	<h1>All packages</h1>

	<div class="list-group row">
		<div class="col-md-12">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center col-md-1">Id</th>
						<th class="text-center">Area</th>
						<th class="text-center">Country</th>
						<th class="text-center col-md-1">Count</th>
						<th class="text-center col-md-1">Edit</th>
						<th class="text-center col-md-1">Delete</th>
						<th class="text-center col-md-1">Order</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="pack" items="${packList}">
						<tr>
							<td>${pack.id}</td>
							<td>${pack.area}</td>
							<td>${pack.country}</td>
							<td>${pack.available}</td>
							<td class="text-center"><a href="${editPackUrl}/${pack.id}"
								class="btn btn-sm btn-primary">Edit</a></td>
							<td class="text-center"><a
								href="${deletePackUrl}/${pack.id}"
								class="btn btn-sm btn-danger delete-button">Delete</a></td>

							<td class="text-center"><c:choose>
									<c:when test="${pack.available > 0}">
										<a href="${orderUrl}/${pack.id}" class="btn btn-info btn-sm">Order</a>
									</c:when>
									<c:otherwise>
                                empty
                            </c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>

<script>
	$(function() {
		$('.delete-button').on('click', function(event) {
			console.log(event);
			event.preventDefault();
			var url = event.target.href;
			$.post(url).done(function() {
				location.reload();
			});
		});
	});
</script>

<%@ include file="/WEB-INF/include/footer.jsp"%>