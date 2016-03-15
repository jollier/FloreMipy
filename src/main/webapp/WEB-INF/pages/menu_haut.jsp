<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                    <li><a href="<c:url value ="/cGVentes"/>">C.G. de ventes</a></li>
                    <li><a href="<c:url value ="/cGEnvoi"/>">C.G. d'envois</a></li>
                    <li><a href="<c:url value ="/quiSommesNous"/>">Qui sommes-nous ?</a></li>
                </ul>
                                        
                <ul class="nav navbar-nav navbar-right">
                    <!-- 
                    <li><a href="<c:url value="/identification"/>">Se connecter</a></li>
                    <li><a href="<c:url value="/profil"/>">S'inscrire</a></li>  
                    -->
                    
                    <li><a href="<c:url value="/profil"/>"><span class="glyphicon glyphicon-user"></span> S'inscrire</a></li>
                    <li><a href="<c:url value="/identification"/>"><span class="glyphicon glyphicon-log-in"></span> Se connecter</a></li>                 
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>