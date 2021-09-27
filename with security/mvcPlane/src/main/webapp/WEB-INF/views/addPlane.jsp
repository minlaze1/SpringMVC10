
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<fieldset>
<legend>Update/Add Plane</legend>
<form:form modelAttribute="aircraft" method="post">
			<form:hidden path="id"/>
			<form:input type="text" path = "year" required="required"/>
			<form:input type="text" path = "make" required="required"/>
			<form:errors path="make" />
			<form:input type="text" path = "model" required="required"/>
			<form:input type="text" path = "length" required="required"/>
			<form:input type="text" path = "image" required="required"/>
			<input type="submit" value="Add/Update a Plane"/>
		</form:form>

</fieldset>
		
		
<%@ include file="common/footer.jspf"%>