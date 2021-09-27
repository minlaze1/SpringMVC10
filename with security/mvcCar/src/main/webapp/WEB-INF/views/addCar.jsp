
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>


<legend>Update/Add car</legend>
<form:form method="post" modelAttribute="vehicle">
	<form:hidden path="id"/>
	<fieldset>
	Year:<form:input type="text" path="year" required="required"/>
	</fieldset>
	<fieldset>
	Make:<form:input type="text" path="make" required="required"/>
	<form:errors path="make"/>
	</fieldset>
	<fieldset>
	Model:<form:input type="text" path="model" required="required"/>
	</fieldset>
	<fieldset>
	Image:<form:input type="text" path="image" required="required"/>
	</fieldset>
		<input type="submit" value="Add / Update a Car"/>
</form:form>
	
<%@ include file="common/footer.jspf"%>