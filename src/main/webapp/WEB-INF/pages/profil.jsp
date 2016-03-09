<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>Floremipi.com - profil</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--  <link rel="stylesheet" href="WEB-INF/sgui/css/bootstrap.css" media="screen">
    <link rel="stylesheet" href="WEB-INF/sgui/css/usebootstrap.css">-->
    <link href="css/home/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/home/shop-homepage.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <div class="navbar navbar-default navbar-fixed-top">
      <div class="container">
      
      
      
      <form:form action="profil" method="post" modelAttribute="profil" class="form-horizontal">
  <fieldset>
<div class="jumbotron">
    <legend>Profil</legend>
    <div class="form-group">
      <label class="col-lg-2 control-label"></label>
	      <div class="col-lg-10">
	        <div class="radio">
	          <label> 
	            <form:input type="radio"  path="iRadios1"  />
	           Particulier
	          </label>
	          <label>
	            <form:input type="radio" name="optionsRadios" path="iRadios2" value="${optEntreprise}"/>
	            Entreprise
	          </label>
	        </div>
	      </div>
	    </div>
    
        <div class="form-group">
	      <label for="form:input" class="col-lg-2 control-label">Entreprise</label>
	      <div class="col-lg-10">
	        <form:input type="text" class="form-control" path="iEntreprise" placeholder="Entreprise" value="${nomEntreprise}"/>
	      </div>
	    </div>
        <div class="form-group">
          <label for="form:input" class="col-lg-2 control-label">Raison Sociale</label>
          <div class="col-lg-10">
            <form:input type="text" class="form-control" path="iRaison" placeholder="Raison Sociale" value="${raisonSociale}"/>
          </div>
        </div>
        <div class="form-group">
          <label for="form:input" class="col-lg-2 control-label">SIRET</label>
          <div class="col-lg-10">
            <form:input type="text" class="form-control" path="iSiret" placeholder="" value="${SIRET}"/>
          </div>
        </div>
        
        <div class="form-group">
         <!-- <label for="form:input" class="col-lg-2 control-label">Forme Juridique</label>
          <div class="col-lg-4">
            <form:input type="text" class="form-control" path="iJuriduque" placeholder="">
          </div>
            -->
            <label for="form:input" class="col-lg-2 control-label">Forme Juridique</label>
          <div class="col-lg-2 ">v
                <select class="form-control" path="iJuriduque" ">
                    <option>France</option>
                    <option class="divider"></option>
                    <option>Belgique</option>
                    <option>Angleterre</option>
                    <option>Luxembourg</option>
                </select>
            </div>
           <label for="form:input" class="col-lg-2 control-label">TVA Intracommunaitaire</label>
          <div class="col-lg-6">
            <form:input type="text" class="form-control" path="iTVA" placeholder="" />
          </div>
        </div>
       
        <div class="form-group">
          <label for="form:input" class="col-lg-2 control-label">Nom</label>
          <div class="col-lg-4">
            <form:input type="text" class="form-control" path="iNom" placeholder=""/>
          </div>
          <label for="form:input" class="col-lg-2 control-label">Prénom</label>
          <div class="col-lg-4">
            <form:input type="text" class="form-control" path="iPrenom" placeholder="" />
          </div>
        </div>
        
        <div class="form-group">
          <label for="form:input" class="col-lg-2 control-label">Adresse</label>
          <div class="col-lg-10">
            <form:input type="text" class="form-control" path="iAdresse" placeholder="" />
          </div>
        </div>        
        
        <div class="form-group">
          <label for="form:input" class="col-lg-2 control-label">Code postal</label>
          <div class="col-lg-2">value="${CP}"/>
          </div>
          
          <label for="form:input" class="col-lg-1 control-label">Ville</label>
          <div class="col-lg-3">
            <form:input type="text" class="form-control" path="iVille" placeholder="" />
          </div>

          <div class="col-lg-4 ">
                <select class="form-control" path="sPays" >
                    <option>France</option>
                    <option>Belgique</option>
                    <option>Angleterre</option>
                    <option>Luxembourg</option>
                </select>
            </div>
 			      
        </div>       
         
        <div class="form-group">
          <label for="form:input" class="col-lg-2 control-label">Telephone 1</label>
          <div class="col-lg-4">
            <form:input type="text" class="form-control" path="itel1" placeholder="" />
          </div>
          <label for="form:input" class="col-lg-2 control-label">Telephone 2</label>
          <div class="col-lg-4">
            <form:input type="text" class="form-control" path="iTel2" placeholder="" />
          </div>
        </div>
        
	    <div class="form-group">
	      <label for="form:inputEmail" class="col-lg-2 control-label">Email</label>
	      <div class="col-lg-10">
	        <form:input type="text" class="form-control" path="email" placeholder="Email"/>
	      </div>
	    </div>
    
 		    <div class="form-group">
		      <div class="col-lg-10 col-lg-offset-2">
		        <a href="/accueil">
		        <button class="btn btn-default">Annuler</button>
		         </a>
		        <button type="submit" class="btn btn-primary">Envoyer</button>
		      </div>
		    </div>
		        </div>
		  </fieldset>
	</form:form>
        </div>
       </div>


    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="js/home/bootstrap.min.js"></script>
    <script src="js/home/usebootstrap.js"></script>
  </body>
</html>

