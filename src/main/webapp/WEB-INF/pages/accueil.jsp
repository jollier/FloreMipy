<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Bootstrap Core CSS -->
    <link href="/FloreMipy/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/FloreMipy/css/shop-homepage.css" rel="stylesheet">
    
    <title>Flore Mipy</title>
</head>

<body>

    <!-- Navigation -->
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
                    <li><a href="#">C.G. de ventes</a></li>
                    <li><a href="#">C.G. d'envois</a></li>
                    <li><a href="#">Qui sommes-nous ?</a></li>
                </ul>
                                        
                <ul class="nav navbar-nav navbar-right">            
                    <c:choose>
                        <c:when test="${empty sessionScope.login}">
                            <li><a href="<c:url value="/profil"/>"><span class="glyphicon glyphicon-user"></span> S'inscrire</a></li>
                            <li><a href="<c:url value="/identification"/>"><span class="glyphicon glyphicon-log-in"></span> Se connecter</a></li>
                        </c:when>    
                        <c:otherwise>
                            <li><a href="<c:url value="/profil"/>">Bonjour : <c:out value="${login}" /></a></li>                            
                            <li><a href="Deconnexion"><span class="glyphicon glyphicon-log-in"></span> Se déconnecter</a></li>
                        </c:otherwise>
                    </c:choose>            
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-2">
                <p class="lead">Flore Mipy</p>
                <div class="list-group">
                
                    <a href="/FloreMipy/accueil?categorie=Toutes" class="list-group-item">Toutes</a>
                    <c:forEach items="${catList}" var="cat"> 
	                    <a href="/FloreMipy/accueil?categorie=${cat}" class="list-group-item">${cat}</a>	                    	                                 
                    </c:forEach>
                
                </div>           
            </div>

            <div class="col-md-7">
                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="/FloreMipy/img/Bambou_1.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="/FloreMipy/img/Buis_1.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="/FloreMipy/img/Arbuste_persistant_1.jpg" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${artList}" var="art">                
                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail">
                                <!-- <img src="http://placehold.it/320x150" alt=""> -->
                                <img src="/FloreMipy/${art.imgsrc}" alt="">
                                
                                <url value="/FloreMipy/ficheArticle/${art.id}" var="articleUrl" />
                                
                                <div class="caption">
                                    <h4><a href="/FloreMipy/ficheArticle/${art.id}"><c:out value="${art.name}" /></a></h4>
                                    <p><c:out value="${art.description}" /></p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                
                <div>

					<ul class="pagination">
					    <li>
					       <a href="#">Prev</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">Next</a></li>
					</ul>


	            </div>
            </div>
			
            <div class="col-md-2">
                      
            </div>
            
        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-6">
                    <p>Copyright &copy; FloreMipy.com 2016</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>
</html>