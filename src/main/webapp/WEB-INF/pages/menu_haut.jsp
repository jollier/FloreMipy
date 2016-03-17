<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<html>

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
                <a class="navbar-brand" href="<c:url value="accueil"/>">Accueil</a>
            </div>
            
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="<c:url value ="/cGVentes"/>">C.G. de ventes</a></li>
                    <li><a href="<c:url value ="/cGEnvoi"/>">C.G. d'envois</a></li>
                    <li><a href="<c:url value ="/quiSommesNous"/>">Qui sommes-nous ?</a></li>
                </ul>
                  <!--                          
                <ul class="nav navbar-nav navbar-right">
                    <!-- 
                    <li><a href="<c:url value="/identification"/>">Se connecter</a></li>
                    <li><a href="<c:url value="/profil"/>">S'inscrire</a></li>  
                    -->
                  <!--   
                    <li><a href="<c:url value="/profil"/>"><span class="glyphicon glyphicon-user"></span> S'inscrire</a></li>
                    <li><a href="<c:url value="/identification"/>"><span class="glyphicon glyphicon-log-in"></span> Se connecter</a></li> 
                    <li><a href="<c:url value="/panier"/>"><span class="glyphicon glyphicon-log-in"></span> Mon panier</a></li>                  
                </ul>
                 -->
                <ul class="nav navbar-nav navbar-right">            
                     <c:choose>
                         <c:when test="${empty sessionScope.login}">
                             <li><a href="<c:url value="/profil"/>"><span class="glyphicon glyphicon-user"></span> S'inscrire</a></li>
                             <li><a href="#" onclick="init('click');"> <span class="glyphicon glyphicon-log-in"></span> Se connecter</a></li>
                             <li><a href="<c:url value="/panier"/>"><span class="glyphicon glyphicon-shopping-cart"></span> Mon panier (${nbArticle})</a></li>
                         </c:when>    
                         <c:otherwise>
                             <li><a href="<c:url value="/profil"/>">Bonjour : <c:out value="${login}" /></a></li>                            
                             <li><a href="Deconnexion"><span class="glyphicon glyphicon-log-in"></span> Se déconnecter</a></li>
                             <li><a href="<c:url value="/panier"/>"><span class="glyphicon glyphicon-shopping-cart"></span> Mon panier (${nbArticle})</a></li>
                         </c:otherwise>
                     </c:choose>            
                 </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>  

<c:import url="/WEB-INF/pages/identification.jsp" />

<script type="text/javascript">

    $(window).load(function(){
        init("");});
    function init(chaine){
        if (("${message}"!="") || (chaine!="" && chaine!=null)) {
            $('#myModal').modal('show');
        }
    };
</script>
 