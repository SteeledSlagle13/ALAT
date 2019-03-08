<!DOCTYPE html>
<html>
<jsp:include page="includes/header.jsp"></jsp:include>
<body>
	<nav class="nav-dark">
		<ul>
			<li><a href="/ApexLegendsAnalysisTool/login">Login</a></li>
			<li class="dropdown"><a href="/ApexLegendsAnalysisTool/analysis"
				class="dropbtn">Analysis</a>
				<div class="dropdown-content">
					<a href="/ApexLegendsAnalysisTool/legends">Legends</a> <a
						href="/ApexLegendsAnalysisTool/weapons">Weapons</a>
				</div></li>
			<li><a class="active" href="/ApexLegendsAnalysisTool/">Home</a></li>
		</ul>
	</nav>
	<div class="title left">
		<h1>Apex Legends Loadout Analysis Tool</h1>
	</div>
	<section class="container"
		style="background-image: url('/ApexLegendsAnalysisTool/static/images/wraith.jpg')">
		<div class="info">
			<p style="font-size: 32px; margin-right: 20px;">
				This tool was designed by SS0113 to help <br>Legends compare
				different Loadouts.
			</p>
			<img
				src="/ApexLegendsAnalysisTool/static/images/legends/pathfinderIcon.png"
				height="250">
		</div>
	</section>
	<section class="container">
		<div></div>
	</section>
	<section class="container footer">
		<div>
			<table class="footertable">
				<tr>
					<td>Hello this is a note from the Dev.</td>
					<td><img
						src="/ApexLegendsAnalysisTool/static/images/ApexIcon.png"
						height="100"></td>
				</tr>
			</table>
		</div>
	</section>
</body>
</html>