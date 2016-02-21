<%@ include file="/WEB-INF/view/include/header.jsp"%>
<section class="container">
	<form:form method="post" action="/phase8/admin/add" commandName="user"
		class="form-horizontal">
		<!-- <form:errors path="*" cssClass="alert alert-danger" element="div" /> -->
		<fieldset>
			<legend><spring:message code="user.title"/>:</legend>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="userId"><spring:message code="user.firstname"/></label>
				<div class="col-lg-10">
					<form:hidden path="id" />
					<form:input id="firstname" path="firstname" type="text"
						class="form:input-large" />
					<form:errors path="firstname" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="userId"><spring:message code="user.lastname"/></label>
				<div class="col-lg-10">
					<form:input id="lastname" path="lastname" type="text"
						class="form:input-large" />
					<form:errors path="lastname" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="email">Email</label>
				<div class="col-lg-10">
					<form:input id="email" path="email" type="text"
						class="form:input-large" />
					<form:errors path="email" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="telephone"><spring:message code="user.telephone"/></label>
				<div class="col-lg-10">
					<form:input id="telephone" path="telephone" type="text"
						class="form:input-large" />
					<form:errors path="telephone" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<c:if test="${user.id == null}">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value=<spring:message code="user.addsubmit"/> />
					</c:if>
					<c:if test="${user.id != null}">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value=<spring:message code="user.editsubmit"/> />
					</c:if>
				</div>
			</div>
		</fieldset>
	</form:form>
	<a href="<spring:url value="/admin/"></spring:url>"
		class="btn btn-info btn-md"></span><spring:message code="back"/></a>
</section>

<%@ include file="/WEB-INF/view/include/footer.jsp"%>
