<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="includes/header.jsp"></jsp:include> --%>
<jsp:include page="includes/bootstrap.jsp"></jsp:include>
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Teko'>
</head>
<body>
	<nav
		class="navbar navbar-expand-lg navbar-dark bg-dark border rounded border-primary">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent"
			data-hover="dropdown">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/ApexLegendsAnalysisTool/">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Stats </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="/ApexLegendsAnalysisTool/legends">Legends</a>
						<a class="dropdown-item" href="/ApexLegendsAnalysisTool/weapons">Weapons</a>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					href="/ApexLegendsAnalysisTool/login">Login</a></li>
			</ul>
		</div>
	</nav>
	<section class="container">
	</section>
	<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>