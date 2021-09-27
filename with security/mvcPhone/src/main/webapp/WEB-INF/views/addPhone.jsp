
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<fieldset>
<legend>Update/Add Phone</legend>
<form:form modelAttribute="smartphone" method="post">
			<form:hidden path="id"/>
			<form:input type="text" path = "year" required="required"/>
			<form:input type="text" path = "make" required="required"/>
			<form:errors path="make" />
			<form:input type="text" path = "model" required="required"/>
			<form:input type="text" path = "color" required="required"/>
			<form:input type="text" path = "image" required="required"/>
			<input type="submit" value="Add/Update a Phone"/>
		</form:form>

</fieldset>
<%@ include file="common/footer.jspf"%>