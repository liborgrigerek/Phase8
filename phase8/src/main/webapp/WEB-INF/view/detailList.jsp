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

<h3><spring:message code="detaillist.bookheader"/>:</h3>
<c:if test="${!empty bookList}">
	<section>
		<table class="table table-hover">
			<tr>
				<th><spring:message code="book.title"/></th>
				<th><spring:message code="book.description"/></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.description}</td>
					<td><a
						href="<spring:url value="/admin/detail/book/edit/{userid}/{bookid}"><spring:param name="userid" value="${user.id}" /><spring:param name="bookid" value="${book.id}" /></spring:url>"
						class="label label-info"><span
							class="glyphicon glyphicon-edit" /></span><spring:message code="detaillist.edit"/></a></td>
					<td><a
						href="<spring:url value="/admin/detail/book/delete/{userid}/{bookid}"><spring:param name="userid" value="${user.id}" /><spring:param name="bookid" value="${book.id}" /></spring:url>"
						class="label label-danger"><span
							class="glyphicon glyphicon-remove" /></span><spring:message code="detaillist.delete"/></a></td>
				</tr>
			</c:forEach>
		</table>
	</section>
</c:if>
<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<a
					href="<spring:url value="/admin/detail/book/add/{id}"><spring:param name="id" value="${user.id}" /></spring:url>"
					class="btn btn-info btn-md"><span
					class="glyphicon glyphicon-plus" /></span><spring:message code="detaillist.addbook"/></a>
			</div>
		</div>
	</div>
</section>






<h3><spring:message code="detaillist.accountheader"/>:</h3>
<c:if test="${!empty accountList}">
	<section>
		<table class="table table-hover">
			<tr>
				<th><spring:message code="account.bankname"/></th>
				<th><spring:message code="account.accountprefix"/></th>
				<th><spring:message code="account.accountnumber"/></th>
				<th><spring:message code="account.bankcode"/></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${accountList}" var="account">
				<tr>
					<td>${account.name}</td>
					<td>${account.accountPrefix}</td>
					<td>${account.accountNumber}</td>
					<td>${account.bankCode}</td>
					<td><a
						href="<spring:url value="/admin/detail/account/edit/{userid}/{accountid}"><spring:param name="userid" value="${user.id}" /><spring:param name="accountid" value="${account.id}" /></spring:url>"
						class="label label-info"><span
							class="glyphicon glyphicon-edit" /></span><spring:message code="detaillist.edit"/></a></td>
					<td><a
						href="<spring:url value="/admin/detail/account/delete/{userid}/{accountid}"><spring:param name="userid" value="${user.id}" /><spring:param name="accountid" value="${account.id}" /></spring:url>"
						class="label label-danger"><span
							class="glyphicon glyphicon-remove" /></span><spring:message code="detaillist.delete"/></a></td>
				</tr>
			</c:forEach>
		</table>
	</section>
</c:if>
<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<a
					href="<spring:url value="/admin/detail/account/add/{id}"><spring:param name="id" value="${user.id}" /></spring:url>"
					class="btn btn-info btn-md"><span
					class="glyphicon glyphicon-plus" /></span><spring:message code="detaillist.addaccount"/></a>
			</div>
		</div>
	</div>
</section>


<h3><spring:message code="detaillist.userprefference"/>:</h3>
<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<form:form method="POST"
					action="/phase8/admin/detail/prefferences/${user.id}"
					commandName="user">
					<fieldset>
						<div class="form-group">
							<label class="control-label" for="userId"><spring:message code="detaillist.favouritebook"/>:</label>
							<div class="">
								<!-- Zde jako path se bere objekt formulare a jako id se pak vola getter tohoto objektu 
                                     pro ziskani aktualniho nastaveni-->
								<form:select id="id" path="favouriteBook">
									<form:option value="" label="--- Select ---" />
									<!-- U options items muze byt vlozen list objektu, pak pro jeden objekt tohoto listu 
                                         itemValue vola getter oznacene metody pro ziskani hodnot (zde getId())
                                         itemLabel vola getter oznacene metody pro ziskani popisku (zde getTitle())
                                         <form:options items="${bookList}" itemValue="id" itemLabel="title" />
                                         Ale zde vyuzivame convertor pro prevod na string, proto staci vlozit bookList
                                    -->
									<form:options items="${bookList}" />
								</form:select>
								<form:errors path="favouriteBook" cssClass="text-danger" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label" for="userId"><spring:message code="detaillist.prefferedaccount"/>:</label>
							<div class="">
								<form:select id="id" path="prefferedAccount">
									<form:option value="" label="--- Select ---" />
									<form:options items="${accountList}" />
								</form:select>
								<form:errors path="prefferedAccount" cssClass="text-danger" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-10">
								<input type="submit" id="btnSet" class="btn btn-primary"
									value=<spring:message code="detaillist.setprefferences"/> />
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
</section>





<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<a href="<spring:url value="/admin/"></spring:url>"
					class="btn btn-info btn-lg"><spring:message code="back"/></a>
			</div>
		</div>
	</div>
</section>
<%@ include file="/WEB-INF/view/include/footer.jsp"%>
