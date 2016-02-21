<%@ include file="/WEB-INF/view/include/header.jsp"%>
<section class="container">
	<form:form method="post"
		action="/phase8/admin/detail/account/add/${user.id}"
		commandName="account" class="form-horizontal">
		<!-- <form:errors path="*" cssClass="alert alert-danger" element="div" /> -->
		<fieldset>
			<legend><spring:message code="account.title"/></legend>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="userId"><spring:message code="account.bankname"/></label>
				<div class="col-lg-10">
					<form:hidden path="id" />
					<form:input id="name" path="name" type="text"
						class="form:input-large" />
					<form:errors path="name" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="userId"><spring:message code="account.accountprefix"/></label>
				<div class="col-lg-10">
					<form:input id="accountPrefix" path="accountPrefix" type="text"
						class="form:input-large" />
					<form:errors path="accountPrefix" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="email"><spring:message code="account.accountnumber"/></label>
				<div class="col-lg-10">
					<form:input id="accountNumber" path="accountNumber" type="text"
						class="form:input-large" />
					<form:errors path="accountNumber" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="telephone"><spring:message code="account.bankcode"/></label>
				<div class="col-lg-10">
					<form:input id="bankCode" path="bankCode" type="text"
						class="form:input-large" />
					<form:errors path="bankCode" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value=<spring:message code="account.addsubmit"/> />
				</div>
			</div>
		</fieldset>
	</form:form>
	<a
		href="<spring:url value="/admin/detail/{id}"><spring:param name="id" value="${user.id}" /></spring:url>"
		class="btn btn-info btn-md"></span></span><spring:message code="back"/></a>
</section>

<%@ include file="/WEB-INF/view/include/footer.jsp"%>
