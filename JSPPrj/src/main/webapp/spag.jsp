<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
pageContext.setAttribute("a","hello");
%>
<body>
	<%=request.getAttribute("result") %>입니다.<br>
	${requestScope.result}입니다.<br>
	${names[0]} : 첫번째 리스트입니다.<br>
	${names[1]} : 두번째 리스트입니다.<br>
	${notice.title} : map 사용<br>
	
	pageContext요소입니다.<br>
	${a}<br>
	${param.n}<br>
	${header.accept}
	
</body>
</html>