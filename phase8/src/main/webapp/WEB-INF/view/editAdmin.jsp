<%@ include file="/WEB-INF/view/include/header.jsp"%>
<section class="container">
    <form:form method="post" action="/phase8/admin/administrator/add" commandName="login"
        class="form-horizontal">
        <fieldset>
            <legend><spring:message code="admin.title"/></legend>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="adminId"><spring:message code="admin.login"/></label>
                <div class="col-lg-10">
                    <form:hidden path="id" />
                    <form:input id="login" path="login" type="text" autocomplete="off"
                        class="form:input-large" />
                    <form:errors path="login" cssClass="text-danger" />
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="userId"><spring:message code="admin.password"/></label>
                <div class="col-lg-10">
                    <form:password id="password" path="password" autocomplete="off" class="form:input-large" />
                    <form:errors path="password" cssClass="text-danger" />
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="userId"><spring:message code="admin.confirmpassword"/></label>
                <div class="col-lg-10">
                    <form:password id="confirmPassword" path="confirmPassword" autocomplete="off" class="form:input-large" />
                    <form:errors path="password" cssClass="text-danger" />
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <c:if test="${admin.id == null}">
                        <input type="submit" id="btnAdd" class="btn btn-primary"
                            value=<spring:message code="admin.addsubmit"/> />
                    </c:if>
                    <c:if test="${admin.id != null}">
                        <input type="submit" id="btnAdd" class="btn btn-primary"
                            value=<spring:message code="admin.editsubmit"/> />
                    </c:if>
                </div>
            </div>
        </fieldset>
    </form:form>
    <a href="<spring:url value="/admin/"></spring:url>"
        class="btn btn-info btn-md"></span><spring:message code="back"/></a>
</section>

<%@ include file="/WEB-INF/view/include/footer.jsp"%>
