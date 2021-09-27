
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>


<fieldset>
<legend>Update/Add Watch</legend>
<form:form modelAttribute="montre" method="post">
			<form:hidden path="id"/>
			<form:input type="text" path = "year" required="required"/>
			<form:input type="text" path = "brand" required="required"/>
			<form:errors path="brand" />
			<form:input type="text" path = "model" required="required"/>
			<form:input type="text" path = "image" required="required"/>
			<input type="submit" value="Add/Update a Watch"/>
		</form:form>
</fieldset>
		
<%@ include file="common/footer.jspf"%>