<!DOCTYPE html>
<html>
<jsp:include page="includes/header.jsp"></jsp:include>
<body>
	<nav class="nav-dark">
		<ul>
			<li><a href="/ApexLegendsAnalysisTool/login">Login</a></li>
			<li class="dropdown"><a href="/ApexLegendsAnalysisTool/analysis"
				class="active dropbtn">Analysis</a>
				<div class="dropdown-content">
					<a href="/ApexLegendsAnalysisTool/legends">Legends</a> <a
						href="/ApexLegendsAnalysisTool/weapons">Weapons</a>
				</div></li>
			<li><a href="/ApexLegendsAnalysisTool/">Home</a></li>
		</ul>
	</nav>
	<div class="centersection">
		<div class="centertitle">
			<h1>Weapons</h1>
		</div>
		<div align="center" ng-app="weaponManagerApp"
			ng-controller="WeaponController">
			<table class="weapondisplaytbl">
				<tr>
					<td>
						<div class="selector">
							<h3 class="white">Weapon 1</h3>
							<select class="darkdrpdown" ng-model="weapon1"
								ng-options="x.name.toUpperCase() for x in weapons | orderBy : 'name'">
							</select>
							<div>
								<br>
							</div>
						</div>
					</td>
					<td>
						<div class="selector">
							<h3 class="white">Weapon 2</h3>
							<select class="darkdrpdown" ng-model="weapon2"
								ng-options="x.name.toUpperCase() for x in weapons | orderBy : 'name'"></select>
							<div>
								<br>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="selector white">
							<p>Name: {{weapon1.name.toUpperCase()}}</p>
							<img src="/ApexLegendsAnalysisTool/static/images/lmg/lmg.png"
								height="100px" width="200px" ng-src="{{weapon1.imageSource}}">
							<p>Damage : {{weapon1.lowDps}}-{{weapon1.highDps}}</p>
							<p style="color: white;">Type :
								{{weapon1.type.toUpperCase()}}</p>
						</div>
					</td>
					<td>
						<div class="selector white">
							<p>Name: {{weapon2.name.toUpperCase()}}</p>
							<img
								src="/ApexLegendsAnalysisTool/static/images/shotgun/shotgun.png"
								height="100px" width="200px" ng-src="{{weapon2.imageSource}}">
							<p>Damage : {{weapon2.lowDps}}-{{weapon2.highDps}}</p>
							<p>Type : {{weapon2.type.toUpperCase()}}</p>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	</div>
	<jsp:include page="includes/footer.jsp"></jsp:include>F
	<!-- Weapon Select Import -->
	<script
		src="/ApexLegendsAnalysisTool/static/js/weaponmanager/weaponmanager.app.js"></script>
	<script
		src="/ApexLegendsAnalysisTool/static/js/weaponmanager/weaponmanager.service.js"></script>
	<script
		src="/ApexLegendsAnalysisTool/static/js/weaponmanager/weaponmanager.controller.js"></script>
</body>
</html>