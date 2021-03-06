<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<c:url value="/couriers" var="couriersURL" />
<c:url value="/create-courier" var="createCourierURL" />
<c:url value="/logout" var="logoutURL" />

<c:url value="/packs" var="packsUrl" />
<c:url value="/pack/create" var="createPackUrl" />

<c:url value="/orders" var="ordersUrl" />
<c:url value="upload" var="uploadUrl" />
<c:url value="uploadMulti" var="uploadMultiUrl" />

<c:url value="/" var="mainURL" />
<c:url value="/account" var="accountURL" />
<c:url value="/updateAdmin" var="updateAdminURL" />

<div>
	<form class="nav navbar-nav navbar-left">
		<li><a href="${mainURL}" class="btn btn-primary btn btn-default">Hermes
				Delivery</a></li>
	</form>
	
</div>

	<div>
		<form action="${updateAdminURL}" method="post" class="nav navbar-nav navbar-left">	
			<button class="btn btn-primary"
				type="submit" >SET ADMIN</button>
		</form>	
</div>

<nav class="nav navbar-nav navbar-right ">
	<ul class="nav navbar-nav">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"></a>
			</div>
	</ul>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">

			<sec:authorize access="hasRole('ADMIN')">
				<li class="dropdown"><a href="#"
					class="dropdown-toggle btn btn-danger btn btn-default"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Couriers <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${createCourierURL}">New courier</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="${couriersURL}">Couriers list</a></li>
					</ul></li>
			</sec:authorize>
			<li class="dropdown"><a href="#"
				class="dropdown-toggle btn btn-warning btn btn-default "
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false">Packages <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${createPackUrl}">New package</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="${packsUrl}">Packages list</a></li>
				</ul></li>
			<li><a href="${ordersUrl}" class="btn btn-info btn btn-default">Courier's
					orders</a></li>
									
					<li class="dropdown"><a href="#"
				class="dropdown-toggle btn btn-success btn btn-default "
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false">Attachments <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${uploadUrl}">One file</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="${uploadMultiUrl}">Many files</a></li>
				</ul></li>
									
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false"> 
				<span class="glyphicon glyphicon-user" aria-hidden="true"></span> 
					<sec:authentication property="principal.username" /> <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${accountURL}"}">Courier account</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="${logoutURL}">Logout</a></li>
				</ul></li>
		</ul>
	</div>
	</div>
</nav>
