<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<c:set var="contextRoot" value="${pageContext.request.contextPath }" />



<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>BSonlineshopping-${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'
</script>


<!-- Bootstrap core CSS -->
<link href="${css }/bootstrap.css" rel="stylesheet">

<!-- Bootstrap readable theme -->
<link href="${css }/bootstrap readable theme.css" rel="stylesheet">

<!-- Bootstrap DataTables -->
<link href="${css }/dataTables.bootstrap.css" rel="stylesheet">



<!-- Add custom CSS here -->
<link href="${css }/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		`
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>


		<!-- Page Content -->

		<div class="content">

			<!-- Loading the home content -->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>

			</c:if>

			<!-- Load only when user clicks about -->
			<c:if test="${userClickAbout==true}">
				<%@include file="about.jsp"%>

			</c:if>

			<!-- Load only when user clicks contact -->
			<c:if test="${userClickContact==true}">
				<%@include file="contact.jsp"%>

			</c:if>

			<!-- Load only when user clicks contact -->
			<c:if
				test="${userClickAllProducts==true or userClickCategoryProducts==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			<!-- Load only when user clicks show products -->
			<c:if test="${userClickShowProduct==true}">
				<%@include file="singleProduct.jsp"%>

			</c:if>

			<!-- Load only when user clicks manage products -->
			<c:if test="${userClickManageProducts==true}">
				<%@include file="manageProducts.jsp"%>

			</c:if>

			<!-- Load only when user clicks manage products -->
			<c:if test="${userClickSupplierDetails==true}">
				<%@include file="supplierDetails.jsp"%>

			</c:if>



			<!-- Load only when user clicks manage products -->
			<c:if test="${userClickShowCart==true}">
				<%@include file="cart.jsp"%>

			</c:if>


			<!-- Load only when user clicks checkout -->
			<c:if test="${userClickCheckout==true}">
				<%@include file="thankyou.jsp"%>

			</c:if>


		</div>

		<!-- Footer comes here -->

		<%@include file="./shared/footer.jsp"%>

		<!-- /.container -->

		<!-- JQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- JQuery Validator-->
		<script src="${js}/jquery.validate.js"></script>


		<!-- bootstrap  core java script-->
		<script src="${js}/bootstrap.js"></script>

		<!-- DataTable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- Bootbox -->
		<script src="${js}/bootbox.min.js"></script>



		<!-- self coded java script -->
		<script src="${js}/myapp.js"></script>

	</div>

</body>

</html>
