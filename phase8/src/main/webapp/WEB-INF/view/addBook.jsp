<%@ include file="/WEB-INF/view/include/header.jsp"%>
<section>
	<h3>Selected User:</h3>
	<table class="table table-hover">
		<tr>
			<th><spring:message code="user.name"/></th>
			<th>Email</th>
			<th><spring:message code="user.telephone"/></th>
		</tr>
		<tr>
			<td>${user.lastname},${user.firstname}</td>
			<td>${user.email}</td>
			<td>${user.telephone}</td>
		</tr>
	</table>
</section>
<section class="container">
	<form:form method="post"
		action="/phase8/admin/detail/book/add/${user.id}" commandName="book"
		class="form-horizontal">
		<!-- <form:errors path="*" cssClass="alert alert-danger" element="div" /> -->
		<fieldset>
			<legend><spring:message code="book.header"/></legend>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="userId"><spring:message code="book.title"/></label>
				<div class="col-lg-10">
					<form:hidden path="id" />
					<form:input id="title" path="title" type="text"
						class="form:input-large" />
					<form:errors path="title" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="userId"><spring:message code="book.description"/></label>
				<div class="col-lg-10">
					<form:input id="description" path="description" type="text"
						class="form:input-large" />
					<form:errors path="description" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value=<spring:message code="book.addsubmit"/> />
				</div>
			</div>
		</fieldset>
	</form:form>
	<a
		href="<spring:url value="/admin/detail/{id}"><spring:param name="id" value="${user.id}" /></spring:url>"
		class="btn btn-info btn-md"></span><spring:message code="back"/></a>
</section>

<%@ include file="/WEB-INF/view/include/footer.jsp"%>
