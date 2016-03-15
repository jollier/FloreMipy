<%@ page language="java" isELIgnored="false"
	contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>Floremipi.com - profil</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
		<div class="container">
		
		   <!-- Page Content -->
			<form:form action="profil" method="post" modelAttribute="profil"
				class="form-horizontal">
				<fieldset>
				<legend>Profil</legend>
					<div class="jumbotron">
						<!--  <legend>Profil</legend>-->

						<%--   <div class="form-group">
              <label class="col-lg-2 control-label"></label>
                  <div class="col-lg-10">
                    <div class="radio">
                      <label> 
                    <form:radiobuttons path="radios" value="Particulier"/>
                       Particulier
                      </label>
                      <label>
                      <form:radiobuttons path="radios" value="Entreprise"/>
                        Entreprise
                     </label>
                    </div>
                  </div>
                </div>
            
                <div class="form-group">
                  <label for="input" class="col-lg-2 control-label">Entreprise</label>
                  <div class="col-lg-10">
                  <form:input type="text" class="form-control" path="nomEntreprise" placeholder="Entreprise" />
                  </div>
                </div>
                <div class="form-group">
                  <label for="input" class="col-lg-2 control-label">Raison Sociale</label>
                  <div class="col-lg-10">
                  <form:input type="text" class="form-control" path="raisonSociale" placeholder="Raison Sociale" />
                  </div>
                </div>
                <div class="form-group">
                  <label for="input" class="col-lg-2 control-label">SIRET</label>
                  <div class="col-lg-10">
                   <form:input type="text" class="form-control" path="SIRET" placeholder="" />
                  </div>
                </div>
                
                <div class="form-group">
                    <label for="select" class="col-lg-2 control-label">Forme Juridique</label>
                  <div class="col-lg-2 ">
                        <form:select class="form-control" path="juridique" >
                            <form:option value = "SCI" label = "SCI"/>
                            <form:option value= "SA" label = "SA"/>
                        </form:select>
                         
                    </div>
                   <label for="input" class="col-lg-2 control-label">TVA Intracommunaitaire</label>
                  <div class="col-lg-6">
                   <form:input type="text" class="form-control" path="TVA" placeholder="" />
                  </div>
                </div>
     --%>
						<div class="form-group">
							<label for="input" class="col-lg-2 control-label required">Nom</label>
							<div class="col-lg-4">
								<form:input type="text" class="form-control" path="name"
									placeholder="" required="true" />
							</div>
							<label for="input" class="col-lg-2 control-label required">Prénom</label>
							<div class="col-lg-4">
								<form:input type="text" class="form-control" path="firstName"
									placeholder="" required="true" />
							</div>
						</div>

						<div class="form-group">
							<label for="input" class="col-lg-2 control-label required">Adresse</label>
							<div class="col-lg-10">
								<form:input type="text" class="form-control required"
									path="adresse" placeholder="" required="true" />
							</div>
						</div>

						<div class="form-group">
							<label for="input" class="col-lg-2 control-label required">Code
								postal</label>
							<div class="col-lg-2">
								<form:input type="text" class="form-control required" path="CP"
									required="true" />
							</div>

							<label for="input" class="col-lg-1 control-label required">Ville</label>
							<div class="col-lg-3">
								<form:input type="text" class="form-control" path="city"
									placeholder="" required="true" />
							</div>

							<div class="col-lg-4 ">
								<form:select class="form-control required" path="country">
									<form:option value="France" label="France" />
									<form:option value="Belgique" label="Belgique" />
								</form:select>
							</div>

						</div>

						<div class="form-group">
							<label for="input" class="col-lg-2 control-label required">Telephone
								1</label>
							<div class="col-lg-4">
								<form:input type="text" class="form-control required"
									path="tel1" placeholder="" required="true" />
							</div>
							<label for="input" class="col-lg-2 control-label">Telephone
								2</label>
							<div class="col-lg-4">
								<form:input type="text" class="form-control" path="tel2"
									placeholder="" />
							</div>
						</div>

						<div class="form-group">
							<label for="input"
								class="col-lg-2 control-label required required">Login</label>
							<div class="col-lg-4">
								<form:input type="text" class="form-control required"
									path="login" placeholder="" required="true" />
							</div>
							<label for="input" class="col-lg-2 control-label required">Mot
								de passe</label>
							<div class="col-lg-4">
								<form:input type="password" class="form-control required"
									path="password" placeholder="" required="true" />
							</div>
						</div>

						<div class="form-group">
							<label for="input" class="col-lg-2 control-label required">Email</label>
							<div class="col-lg-10">
								<form:input type="text" class="form-control" path="email"
									placeholder="Email" />
							</div>
						</div>

						<div class="form-group">
								<div class="col-lg-12 col-lg-offset-2">
									<spring:url value="/accueil" var="accueil" htmlEscape="true" />
									<a href="${accueil}" type="reset" class="btn btn-default">Annuler </a>
									<button type="submit" class="btn btn-primary">Envoyer</button>
								</div>
						</div>
						
					</div>
				</fieldset>
			</form:form>
			
			   <!-- /Page Content -->
		</div>
        <!-- //<div class="container"> -->

	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="js/home/bootstrap.min.js"></script>
	<script src="js/home/usebootstrap.js"></script>
</body>
</html>

