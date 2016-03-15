<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Bootstrap Shop Cart</title>

<!-- Bootstrap core CSS -->
 <link href="css/home/bootstrap.min.css" rel="stylesheet">



<style>
body {
	padding-top: 50px;
}

#divTotal {
	background-color: green;
}

.affix {
	right: 0px;
}

.affix-top {
	right: 0px;
	position: fixed;
}
</style>

</head>

<body>

	<div class="container">

        <c:import url="/WEB-INF/pages/menu_haut.jsp" /></br>

		<div class="col-xs-7 col-md-8 col-sm-8 col-lg-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Votre pannier</h3>
				</div>
				<div class="panel-body">
					<table class="table table-sm">
						<thead>
							<tr>
								<th>Article</th>
								<th>Réf</th>
								<th>Prix</th>
								<th>Qté</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">xx</th>
								<td>yyy</td>
								<td>zzzz</td>
								<td>tttt</td>
							</tr>
							<tr>
								<th scope="row"></th>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<th scope="row"></th>
                                <td></td>
                                <td></td>
                                <td></td>
							</tr>
						</tbody>
					</table>


				</div>
			</div>
		</div>

		<div class="col-xs-5 col-md-4 col-sm-4 col-lg-4">
			<div class="panel panel-primary">
				<div id="divTotal" class="panel-heading">
					<h3 class="panel-title">Total</h3>
				</div>
				<div class="panel-body">
					<h2>XX euros</h2>
				</div>
			</div>

			<div class="text-center">
				 <button type="submit" class="btn btn-success btn-sm"> Commander</button>
                                    
			</div>
		</div>

    <c:import url="/WEB-INF/pages/footer.jsp" /></br>

	</div>

</body>

</html>