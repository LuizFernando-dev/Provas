<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Responder teste</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="resources/css/responder.css">
	<script type="text/javascript" src="resources/js/responder.js"></script>
</head>
<body>
	<h1>${test.titulo}</h1> <p>valor: ${test.valor}</p>
	<form id="form" action="/MakeProvas/corrige">
			
			<c:forEach items="${questoes }" var="quest" varStatus="loop">
			<div id="questao">
			<h3>${quest.titulo}</h3>
				<c:if test="${quest.q1 =='resposta'}">
					<input type="radio" name="alt${loop.count }" value="${quest.q1 }">${quest.resposta}<input type="hidden" id="hidden${loop.count}"> <br>
					<hr>
				</c:if>
				<c:if test="${quest.q1 !='resposta'}">
					<input type="radio" name="alt${loop.count }" value="${quest.q1 }"><input type="hidden" id="hidden${loop.count}"> ${quest.q1 }<br>
					<hr>
				</c:if>
				<c:if test="${quest.q2 =='resposta'}">
					<input type="radio" name="alt${loop.count }" value="${quest.q2 }"><input type="hidden" id="hidden${loop.count}"> ${quest.resposta }<br>
					<hr>
				</c:if>
				<c:if test="${quest.q2 !='resposta'}">
					<input type="radio" name="alt${loop.count }" value="${quest.q2 }"><input type="hidden" id="hidden${loop.count}"> ${quest.q2 }<br>
					<hr>
				</c:if>
				<c:if test="${quest.q3 =='resposta'}">
					<input type="radio" name="alt${loop.count }" value="${quest.q3 }"><input type="hidden" id="hidden${loop.count}"> ${quest.resposta }<br>
					<hr>
				</c:if>
				<c:if test="${quest.q3 !='resposta'}">
					<input type="radio" name="alt${loop.count }" value="${quest.q3}"><input type="hidden" id="hidden${loop.count}"> ${quest.q3 }<br>
					<hr>
				</c:if>
				<c:if test="${quest.q4 =='resposta'}">
					<input type="radio" name="alt${loop.count }" value="${quest.q4}"><input type="hidden" id="hidden${loop.count}"> ${quest.resposta }<br>
					<hr>
				</c:if>
				<c:if test="${quest.q4 !='resposta'}">
					<input type="radio" name="alt${loop.count }" value="${quest.q4 }"><input type="hidden" id="hidden${loop.count}"> ${quest.q4 }<br>
					<hr>
				</c:if>
				</div>
			</c:forEach>
				<input type="hidden" value="${index}" id="index" name="total">
		<input type="submit" name="enviar" value="Responder" onclick="salvaQuestoes()">
	</form>
	
</body>
</html>