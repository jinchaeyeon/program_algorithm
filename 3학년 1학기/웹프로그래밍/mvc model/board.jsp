<%@page import="java.util.List"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="persistance.BoardDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>	
	<form action="#" method="post" align="center">
		<input type="text" name="serchText" /> <input type="submit"
			value="검색" />
	</form>
	<table width="700" border="3" bordercolor="lightgray" align="center">
		<thead>
			<tr>
				<td>no</td>
				<td>제 목</td>
				<td>글쓴이</td>
				<td>내용</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
		</thead>
		<%
			List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("boardDto");
			for (BoardDTO dto : list) {
				pageContext.setAttribute("dto", dto);			
		%>
			<tr>
				<td>${dto.id}</td>
				<td>${dto.title}</td>
				<td>${dto.writer}</td>
				<td>${dto.contents}</td>
				<td>${dto.regdate}</td>
				<td>${dto.hit}</td>
			</tr>
		<%}%>
<%-- 		<c:forEach var="dto" items="${boardDto}" begin="0" end="2">
			<tr>
				<td>${dto.id}</td>
				<td>${dto.title}</td>
				<td>${dto.writer}</td>
				<td>${dto.contents}</td>
				<td>${dto.regdate}</td>
				<td>${dto.hit}</td>
			</tr>
		</c:forEach> --%>

	</table>
	
</body>
</html>