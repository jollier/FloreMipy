<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Fiche article</title>

<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/shop-item.css" rel="stylesheet">
<link href="../css/produit.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


<script language="JavaScript">
    
    function ajouterAuPanier() {
    	var qte = document.getElementById('quantite').value;
    	var url = "/FloreMipy/ficheArticle/${article.id}/ajouter/?qte=" + qte;
    	document.location.href = url;
    }
</script>
</head>

<body>

	<c:import url="/WEB-INF/pages/menu_haut.jsp" />
	
	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-md-9">
				<spring:url value="/ficheArticle" var="ficheArticleUrl" />

				<form:form class="form-horizontal" method="post" modelAttribute="article" action="${ficheArticleUrl}">

					<div class="thumbnail">
					   <div class="cont-img">
						<img class="img-responsive-art" src="/FloreMipy/${article.imgsrc}" alt="">
					   </div>
						<div class="caption-full">
							<h3 class="pull-right">${price} € TTC</h3>
							<p>
							<h3>
								<a href="#">${article.name}</a>
								<p>
								<div class="ratings">
									<p class="pull-left">${article.quantityInStock > 0 ? 'En stock' : 'En rupture provisoire'}</p>
								</div>
							</h3>
							<div class="text-right">
								<span>Quantité à commander</span> 
								<select id="quantite" name="quantite" class="wrapper-dropdown">
									<c:forEach var="i" begin="1" end="${article.quantityInStock}" step="1">
									   <option value="${i}"><c:out value="${i}" /></option>
								</c:forEach>
								</select>
								<p>
								<p>
							</div>
							<div class="text-right">
								<!-- <span class="glyphicon glyphicon-shopping-cart"></span> --> 
								<!-- <a class="glyphicon glyphicon-user"> </a> -->
                                <a class="img-add-cart" href="/FloreMipy/img/AddCart.jpg"> </a>
                                <a href="#" onclick="ajouterAuPanier();" class="btn btn-success">Ajouter au panier</a>
							</div>
							<p>${article.description}<a target="_blank"></a>.
							</p>
						</div>
					</div>
				</form:form>
			</div>
			

		</div>

	</div>
	<!-- /.container -->

	<div class="container">

		<hr>

        <c:import url="/WEB-INF/pages/footer.jsp" />

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="../js/jquery.js"></script>
        
	<!-- Bootstrap Core JavaScript -->
	<script src="../js/bootstrap.min.js"></script>
	
	

</body>

</html>
