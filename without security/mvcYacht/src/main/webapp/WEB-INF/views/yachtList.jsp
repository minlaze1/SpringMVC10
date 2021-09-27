<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

 	
	<h1>Welcome ${username} to our online's yachts store From SarayaTech</h1>
	

	<a href="/add-yacht"> <b>Add new yacht</b></a>
	<hr>
		
		<table>
			<thead>
					<tr>
						<td  ><b>Image</b></td>
						<td ><b>Year</b></td>
						<td  ><b>Make</b></td>
						<td ><b>Model</b></td>
						<td ><b>Length</b></td>
						<td ><b>Update</b></td>
						<td><b>Remove Yacht</b></td>
					</tr>
			</thead>
			<tbody>
			<c:forEach items="${yachts}" var="yacht">
				<tr>
					<td  ><img src = "${yacht.image}" width="100" height="100" /></td>
					<td  >${yacht.year}</td>
					<td  >${yacht.make}</td>
					<td  >${yacht.model}</td>
					<td  >${yacht.length}</td>
					<td><b>&nbsp; &nbsp;
     <a href="/update-yacht?id=${yacht.id}">Update</a></b></td>
					<td><b>&nbsp; &nbsp;
     <a href="/delete-yacht?id=${yacht.id}">Delete</a></b></td>
				</tr>
			</c:forEach>	
			</tbody>
			
			
		</table>
		
<%@ include file="common/footer.jspf"%>