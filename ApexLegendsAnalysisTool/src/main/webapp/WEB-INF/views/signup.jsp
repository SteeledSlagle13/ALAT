<!DOCTYPE html>
<html>
<jsp:include page="includes/header.jsp"></jsp:include>
<body>
	<nav class="nav-dark">
		<ul>
			<li><a class="active" href="/ApexLegendsAnalysisTool/login">Login</a></li>
			<li class="dropdown"><a href="/ApexLegendsAnalysisTool/analysis"
				class="dropbtn">Analysis</a>
				<div class="dropdown-content">
					<a href="/ApexLegendsAnalysisTool/legends">Legends</a> <a
						href="/ApexLegendsAnalysisTool/weapons">Weapons</a>
				</div></li>
			<li><a href="/ApexLegendsAnalysisTool/">Home</a></li>
		</ul>
	</nav>
	<form class="loginform" name="regform" ng-app="registerApp"
		ng-controller="signupController as ctrl"
		ng-submit="ctrl.checkUser(ctrl.user.username)">
		<input type="hidden" ng-model="ctrl.user.id" />
		<div class="signupformcontainer">
			<p class="formtitle">Sign-up</p>
			<table>
				<tr>
					<td><span class="red">*</span>Username:</td>
					<td><input class="input-dark" type="text" name="username"
						ng-model="ctrl.user.username" required></td>
				</tr>
				<tr>
					<td><span class="red">*</span>Email:</td>
					<td><input class="input-dark" type="text" name="email"
						ng-model="ctrl.user.email" required></td>
				</tr>
				<tr>
					<td><span class="red">*</span>Password:</td>
					<td><input class="input-dark" type="password" name="password"
						ng-model="ctrl.user.password" required></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input class="input-dark" type="text" name="address"
						ng-model="ctrl.user.address"></td>
				</tr>
			</table>
			<br> <input class="darkbtn" type="submit" value="Submit" />
		</div>
	</form>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="/ApexLegendsAnalysisTool/static/js/signup/signup.app.js"></script>
	<script src="/ApexLegendsAnalysisTool/static/js/signup/signup.service.js"></script>
	<script
		src="/ApexLegendsAnalysisTool/static/js/signup/signup.controller.js"></script>
</body>
</html>