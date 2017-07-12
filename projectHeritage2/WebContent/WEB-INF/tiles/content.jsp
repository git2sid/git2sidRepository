
 <!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>




<html>
<head>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0-2/css/bootstrap.min.css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<script type="text/javascript" src="/js/popup.js"></script>
<script type="text/javascript">
function showChart(rowCount) {
	alert("hello");
	var element = document.getElementById(rowCount);
	alert(element.userId);
}

</script>
</head>
<body>
<%-- <div style="background:white;color:blue;border:2px solid black;width:120px">
<a href="${pageContext.request.contextPath}/report" > create excel</a>
</div>
${userList } --%>
<sql:query var="rs" dataSource="jdbc/spring">
select studentId,studentName from student
</sql:query>
<c:forEach var="row" items="${rs.rows}">
    id ${row.studentId}<br/>
    username ${row.studentName}<br/>
  
</c:forEach>



 <!-- On rows -->
 
 <c:set var="rowNum" value="1" scope="page"/>
<table class="table table-hover" style="padding-right:100px;">
<thead>
    <tr>
      <th>#</th>
      <th>Username</th>
      <th>ID</th>
      <th>Address</th>
      <th>Age</th>
    </tr>
  </thead>
 <c:forEach items="${userList}" var="user" varStatus="count">
 
  <tbody>
  
    <tr id="row+${count.index}" onclick="showChart(row+${count.index});">
      <th scope="row"> <c:out value="${count.index+1}" /> </th>
      <td id="userId"> ${user.id} </td>
      <td id="userName"> ${user.username} </td>
      <td>${user.address} </td>
      <td> ${user.age} </td>
    </tr>

  </tbody>
  </c:forEach>
</table>
 
<script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0-2/js/bootstrap.min.js"></script>
</body>
<div>
<a href="${pageContext.request.contextPath }/querydb">query database</a>
</div>
<div>
<a href="${pageContext.request.contextPath }/readexcel">read excel file</a>
</div>
<div>
<a href="${pageContext.request.contextPath }/getdatausingjquery">jquery form</a>
</div>
</html>