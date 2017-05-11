<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Liste des cartes</title>
	<link href="/fr.allilaire.dbz.dokkanbattle.web/resources/css/bootstrap.min.css" rel="stylesheet">
	<script src="/fr.allilaire.dbz.dokkanbattle.web/resources/js/jquery-3.1.1.js"></script>
	<script src="/fr.allilaire.dbz.dokkanbattle.web/resources/js/bootstrap.js" ></script>
</head>
<body>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Name</th><th>Max level</th><th>Rarity</th><th>Type</th><th>Cost</th><th>Leader Skill</th><th>Super ATK</th>
			<th>Passive Skill</th><th>Link Skills</th><th>HP Max</th><th>ATK Max</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="item">
		<tr>
	    	<td><a href="../card/select?id=${item.id}" target="_blank">${item.name}</a></td>
    		<td>${item.maxLevel}</td>
			<td>${item.rarity}</td>
			<td>${item.type}</td>
			<td>${item.cost}</td>
			<td>${item.leaderSkill}</td>
			<td>${item.superATK}</td>
			<td>${item.passiveSkill}>
			<td>
				<ul>
				<c:forEach items="${item.linkSkills}" var="skill">
					<li>${skill.name}</li>
				</c:forEach>
				</ul>
			</td>
			<td>${item.hpMax}</td>
			<td>${item.atkMax}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>
