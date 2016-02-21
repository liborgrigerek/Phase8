<c:set var="now" value="<%=new java.util.Date()%>" />

<nav class="navbar navbar-default navbar-static-right pull-left">
    <div class="container">
        <div class="panel panel-default">
            <spring:message code="label.language"/><br>
            <div class="text-center">
                <a href="?lang=en">en</a>
                <a href="?lang=cz">cz</a>
            </div>
        </div>
    </div>
</nav>

<nav class="navbar navbar-default navbar-static-right pull-right">
	<div class="container">
		<div class="panel panel-default">
		    <!--  <div class="panel-heading">Information:</div> -->
			<table class="table table-hover table-condensed table-striped table-bordered" style="font-size:9px;">
			    <tr>
			        <th><spring:message code="info.login"/>:</th>
			        <td><c:out value="${username}" /></td>
			    </tr>
                <tr>
                    <th><spring:message code="info.time"/>:</th>
                    <td><fmt:formatDate type="time" value="${now}" /></td>
                </tr>
                <tr>
                    <th><spring:message code="info.date"/>:</th>
                    <td><fmt:formatDate type="date" value="${now}" /></td>
                </tr>
                <tr>
                    <th><spring:message code="info.users"/>:</th>
                    <td><c:out value="${nUsers}" /></td>
                </tr>
			</table>
		</div>
	</div>
</nav>

