<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>


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
      
      
      <hr><hr>
      
      <form action="profil" class="form-horizontal" method="post" modelAttribute="profil">
  <fieldset>
<div class="jumbotron">
    <legend>Profil</legend>
    <div class="form-group">
      <label class="col-lg-2 control-label"></label>
      <div class="col-lg-10">
        <div class="radio">
          <label> 
            <input type="radio" name="optionsRadios" id="iRadios1" value="${optParticulier}" >
           Particulier
          </label>
          
          <label>
            <input type="radio" name="optionsRadios" id="iRadios2" value="${optEntreprise}">
            Entreprise
          </label>
        </div>
      </div>
	  </div>
    
        <div class="form-group">
	      <label for="input" class="col-lg-2 control-label">Entreprise</label>
	      <div class="col-lg-10">
	        <input type="text" class="form-control" id="iEntreprise" placeholder="Entreprise" value="${nomEntreprise}">
	      </div>
	    </div>  
        <div class="form-group">
          <label for="input" class="col-lg-2 control-label">Raison Sociale</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="iRaison" placeholder="Raison Sociale" value="${raisonSociale}">
          </div>
        </div>
        <div class="form-group">
          <label for="input" class="col-lg-2 control-label">SIRET</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="iSiret" placeholder="" value="${SIRET}">
          </div>
        </div>
        
        <div class="form-group">
         <!-- <label for="input" class="col-lg-2 control-label">Forme Juridique</label>
          <div class="col-lg-4">
            <input type="text" class="form-control" id="iJuriduque" placeholder="">
          </div>
            -->
            <label for="input" class="col-lg-2 control-label">Forme Juridique</label>
          <div class="col-lg-2 ">
                <select class="form-control" id="iJuriduque" value="${iJuridique}">
                    <option>SA</option>
                    <option>SCI</option>
                </select>
            </div>
           <label for="input" class="col-lg-2 control-label">TVA Intracom.</label>
          <div class="col-lg-6">
            <input type="text" class="form-control" id="iTVA" placeholder="" value="${TVA}">
          </div>
        </div>
       
        <div class="form-group">
          <label for="input" class="col-lg-2 control-label required" >Nom</label>
          <div class="col-lg-4">
            <input type="text" class="form-control" id="iNom" placeholder="" value="${name}" required>
          </div>
          <label for="input" class="col-lg-2 control-label required">Prénom</label>
          <div class="col-lg-4">
            <input type="text" class="form-control" id="iPrenom" placeholder="" value="${firstName}" required>
          </div>
        </div>
        
        <div class="form-group">
          <label for="input" class="col-lg-2 control-label required">Adresse</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="iAdresse" placeholder="" value="${adresse}" required>
          </div>
        </div>        
        
        <div class="form-group">
          <label for="input" class="col-lg-2 control-label required">Code postal</label>
          <div class="col-lg-2">
            <input type="text" class="form-control" id="iCP" placeholder="" value="${CP}" required>
          </div>
          
          <label for="input" class="col-lg-1 control-label required">Ville</label>
          <div class="col-lg-3">
            <input type="text" class="form-control" id="iVille" placeholder="" value="${city}" required>
          </div>

          <div class="col-lg-4 ">
                <select class="form-control" id="sPays" value="${country}">
                    <option>France</option>
                    <option class="divider"></option>
                    <option>Belgique</option>
                    <option>Angleterre</option>
                    <option>Luxembourg</option>
                </select>
            </div>
 			      
        </div>       
         
        <div class="form-group">
          <label for="input" class="col-lg-2 control-label required">Telephone 1</label>
          <div class="col-lg-4">
            <input type="text" class="form-control" id="itel1" placeholder="" value="${tel1}" required>
          </div>
          <label for="input" class="col-lg-2 control-label">Telephone 2</label>
          <div class="col-lg-4">
            <input type="text" class="form-control" id="iTel2" placeholder="" value="${tel2}">
          </div>
        </div>
        
        <div class="form-group">
          <label for="input" class="col-lg-2 control-label required">Login</label>
          <div class="col-lg-4">
            <input type="text" class="form-control" id="itel1" placeholder="" value="${login}" required>
          </div>
          <label for="input" class="col-lg-2 control-label required">Mot de passe</label>
          <div class="col-lg-4">
            <input type="text" class="form-control" id="iTel2" placeholder="" value="${password}" required>
          </div>
        </div>
        
	    <div class="form-group">
	      <label for="inputEmail" class="col-lg-2 control-label">Email</label>
	      <div class="col-lg-10">
	        <input type="text" class="form-control" id="inputEmail" placeholder="Email" value="${email}" required>
	      </div>
	    </div>
    
 		    <div class="form-group">
		      <div class="col-lg-10 col-lg-offset-2"> 
                <spring:url value="/accueil" var="accueil" htmlEscape="true"/>
                <a href="${accueil}" type="reset" class="btn btn-default"> Annuler4 </a>

		        <button type="submit" class="btn btn-primary">Envoyer</button>
		      </div>
		    </div>
		        </div>
		  </fieldset>
	</form>
        </div>
       </div>


    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="js/home/bootstrap.min.js"></script>
    <script src="js/home/usebootstrap.js"></script>
  </body>
</html>