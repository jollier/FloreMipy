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


    <c:import url="/WEB-INF/pages/menu_haut.jsp" /></br>


    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-2">
                <p class="lead">Flore Mipy</p>
                
                <div class="btn-group-vertical">
                    <a href="/FloreMipy/accueil?categorie=Toutes" class="btn btn-primary">Toutes</a>
                    <c:forEach items="${catList}" var="cat"> 
				        <a href="/FloreMipy/accueil?categorie=${cat}" class="btn btn-primary">${cat}</a>
				    </c:forEach>    
				</div>   
            </div>
        
            <div class="col-md-8">
                <div class="row carousel-holder">
	                <div class="col-md-1">
	                </div>
	                    <div class="col-md-10">
	                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	                            <ol class="carousel-indicators">
	                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	                            </ol>
	                            <div class="carousel-inner">
	                                <div class="item active">
	                                    <img class="slide-image" src="/FloreMipy/img/promo_1.jpg" width="50" alt="">
	                                </div>
	                                <div class="item">
	                                    <img class="slide-image" src="/FloreMipy/img/Buis_1.jpg" width="50" alt="">
	                                </div>
	                                <div class="item">
	                                    <img class="slide-image" src="/FloreMipy/img/Arbuste_persistant_1.jpg" width="50" alt="">
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
	                <div class="col-md-1">
	                </div>
                </div>
                
                <div class="row">
                    <c:forEach items="${artList}" var="art">                
                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail">
                                <!-- <img src="http://placehold.it/320x150" alt=""> -->
                                <img src="/FloreMipy/${art.imgsrc}" alt="" width="50">
                                
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

    <c:import url="/WEB-INF/pages/footer.jsp" /></br>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>
</html>