<%@ include file="/WEB-INF/view/include/header.jsp"%>
<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <a href="<spring:url value="/admin/administrator/add"></spring:url>"
                    class="btn btn-info btn-md"><span
                    class="glyphicon glyphicon-plus" /></span><spring:message code="adminlist.add"/></a>
            </div>
        </div>
    </div>
</section>
<c:if test="${!empty adminList}">
	<section>
	    <div class="col-lg-10">
		<table class="table table-hover">
            <tbody>
			<tr>
				<th></span><spring:message code="admin.login"/></th>
				<th>&nbsp;</th>
                <th>&nbsp;</th>
			</tr>
			<c:forEach items="${adminList}" var="admin">
				<tr>
					<td>${admin.login}</td>
					<td>
					    <a
						href="<spring:url value="/admin/administrator/delete/{id}"><spring:param name="id" value="${admin.id}" /></spring:url>"
						class="label label-danger"><span
							class="glyphicon glyphicon-remove" /></span></span><spring:message code="adminlist.delete"/>
					    </a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
	</section>
</c:if>
<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <a href="<spring:url value="/logout"></spring:url>"
                    class="btn btn-info btn-md">Logout</a>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/view/include/footer.jsp"%>
