<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

 	
	<h1>Dear ${username} you're now on our phones page</h1>
	

	<a href="/add-phone"> <b>Add new Phone</b></a>
	<hr>
		
		<table>
			<thead>
					<tr>
						<td  ><b>Image</b></td>
						<td ><b>Year</b></td>
						<td  ><b>Make</b></td>
						<td ><b>Model</b></td>
						<td ><b>Color</b></td>
						<td ><b>Update</b></td>
					<td><b>Remove Car</b></td>
					</tr>
			</thead>
			<tbody>
			<c:forEach items="${phones}" var="phone">
				<tr>
					<td  ><img src = "${phone.image}" width="100" height="100" /></td>
					<td  >${phone.year}</td>
					<td  >${phone.make}</td>
					<td  >${phone.model}</td>
					<td  >${phone.color}</td>
					<td><b>&nbsp; &nbsp;
     <a href="/update-phone?id=${phone.id}">Update</a></b></td>
					<td><b>&nbsp; &nbsp;
     <a href="/delete-phone?id=${phone.id}">Delete</a></b></td>
				</tr>
			</c:forEach>	
			</tbody>
			
			
		</table>
		
<%@ include file="common/footer.jspf"%>