<%@ include file="/WEB-INF/view/include/header.jsp"%>
<section>
	<div class="center-block">
		<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
			<p>You have to login first.</p>
			<c:url var="loginUrl" value="/login" />
			<form action="${loginUrl}" method="post" class="form-horizontal">
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p><spring:message code="login.invalid"/>.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p><spring:message code="login.logout"/>.</p>
					</div>
				</c:if>
				<div class="input-group input-sm">
					<label class="input-group-addon" for="username"><i
						class="fa fa-user"><spring:message code="login.login"/>:</i></label> <input type="text"
						class="form-control" id="username" name="ssoId"
						placeholder="Enter Username" required>
				</div>
				<div class="input-group input-sm">
					<label class="input-group-addon" for="password"><i
						class="fa fa-lock"><span><spring:message code="login.password"/>:</span> </i></label> <input
						type="password" class="form-control" id="password" name="password"
						placeholder="Enter Password" required>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<div class="form-actions">
					<input type="submit" class="btn btn-block btn-primary btn-default"
						value=<spring:message code="login.submit"/>>
				</div>
			</form>
		</div>
	</div>
</section>

<%@ include file="/WEB-INF/view/include/footer.jsp"%>
