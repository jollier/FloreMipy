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
<link href="../css/item/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/item/shop-item.css" rel="stylesheet">
<link href="../css/item/produit.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Accueil</a>
            </div>
            
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    
                    
                    <li>
                        <a href="#">C.G. de ventes</a>
                    </li>
                    <li>
                        <a href="#">C.G. d'envois</a>
                    </li>
                    <li>
                        <a href="#">Qui sommes-nous ?</a>
                    </li>
                    
                    
                    
                    
                    <li>
                        <a href="<c:url value="/identification"/>">Se connecter</a>      
                    </li>
                    <li>
                        <a href="<c:url value="/profil"/>">S'inscrire</a>                        
                    </li>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-md-3">
				<p class="lead">FloreMipi</p>
				<div class="list-group">
					<a href="#" class="list-group-item active">Category 1</a> <a
						href="#" class="list-group-item">Category 2</a> <a href="#"
						class="list-group-item">Category 3</a>
				</div>
			</div>

			<div class="col-md-9">
				<spring:url value="/ficheArticle" var="ficheArticleUrl" />

				<form:form class="form-horizontal" method="post" modelAttribute="article" action="${ficheArticleUrl}">

					<div class="thumbnail">
						<img class="img-responsive" src="/FloreMipy/${article.imgsrc}"
							alt="">
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
								<select id="quantite" var="qte"
									class="wrapper-dropdown">
									<c:forEach var="i" begin="1" end="${article.quantityInStock}" step="1">
									<option><c:out value="${i}" />
								</c:forEach>
								</select>
								<p>
								<p>
							</div>
							<div class="text-right">
								<!-- <span class="glyphicon glyphicon-shopping-cart"></span> --> 
								<!-- <a class="glyphicon glyphicon-user"> </a> -->
								    <a href="/FloreMipy/ficheArticle/${article.id}/ajouter/?qte=${qte}" } class="btn btn-success">Ajouter au panier</a>
							</div>
							<p>${article.description}<a target="_blank"></a>.
							</p>
						</div>
					</div>
			</div>
			</form:form>

		</div>

	</div>
	<!-- /.container -->

	<div class="container">

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
<!-- 					<p>Copyright &copy; Your Website 2016</p>
 -->				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="../js/item/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../js/item/bootstrap.min.js"></script>

</body>

</html>
