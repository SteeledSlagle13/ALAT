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
	<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>