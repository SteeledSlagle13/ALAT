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
	<form class="loginform" name="loginForm">
		<input type="hidden" />
		<div class="loginformcontainer">
			<p class="formtitle">Login</p>
			<p class="invalid">${errorMessage}</p>
			<table>
				<tr>
					<td>Username:</td>
					<td><input class="input-dark" type="text" name="username"
						required></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input class="input-dark" type="password" name="password"
						required></td>
				</tr>
			</table>
			<input class="darkbtn" type="submit" formmethod="post" value="Login" />
			<br> <br> Not registered? <a
				href="/ApexLegendsAnalysisTool/signup">Sign Up!</a>
		</div>
	</form>
</body>
</html>