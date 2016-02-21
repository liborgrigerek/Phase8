<%@ include file="/WEB-INF/view/include/header.jsp"%>
<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p><spring:message code="login.logout"/>.</p>
					</div>
				</c:if>
				<a href="<spring:url value="/admin/"></spring:url>"
					class="btn btn-info btn-md"><spring:message code="welcome.users"/></a>
			</div>
		</div>
	</div>
</section>
<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <a href="<spring:url value="/admin/administrator/"></spring:url>"
                    class="btn btn-info btn-md"><spring:message code="welcome.administrators"/></a>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/view/include/footer.jsp"%>
