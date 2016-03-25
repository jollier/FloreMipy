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


<h1> Une équipe jeune et dynamique à votre service !</h1>
    <!-- Navigation -->
    <!-- Page Content -->
    <div class="container">

        <div class="row">

   
            <div class="col-md-7">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>

                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="ecole1.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="ecole2.jpg" alt="">
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

    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>
</html>