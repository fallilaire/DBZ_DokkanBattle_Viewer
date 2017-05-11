<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ma carte</title>
	<link href="/fr.allilaire.dbz.dokkanbattle.web/resources/css/bootstrap.min.css" rel="stylesheet">
	<script src="/fr.allilaire.dbz.dokkanbattle.web/resources/js/jquery-3.1.1.js"></script>
	<script src="/fr.allilaire.dbz.dokkanbattle.web/resources/js/bootstrap.js" ></script>
</head>
<body>

	<ul>
		<li>${card.name}</li>
		<li>${card.maxLevel}</li>
		<li>${card.rarity}</li>
		<li>${card.type}</li>
		<li>${card.cost}</li>
		<li>${card.leaderSkill}</li>
		<li>${card.superATK}</li>
		<li>${card.passiveSkill}></li>
		<li>
			<ul>
			<c:forEach items="${card.linkSkills}" var="skill">
				<li>${skill.name}</li>
			</c:forEach>
			</ul>
		</li>
		<li>${card.hpMax}</li>
		<li>${item.atkMax}</li>
	</ul>

</body>
</html>
