<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<%@ include file="/WEB-INF/include/navbar.jsp"%>

<div class="container">

	<h1>List of orders</h1>

	<div class="row">
		<div class="col-md-12">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center col-md-1">Id</th>
						<th class="text-center">Date of order</th>
						<th class="text-center">Status</th>
						<th class="text-center">Courier</th>
						<th class="text-center">Package</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ordersList}" var="order">
						<tr>
							<td>${order.id}</td>
							<td>${order.createdDate}</td>
							<td>${order.status}</td>
							<td>${order.courier.firstName}${order.courier.lastName}</td>
							<td>${order.pack.country}- ${order.pack.area}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>