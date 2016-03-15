<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">

 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/signin.css" rel="stylesheet">
 
<title>Insert title here</title>
</head>
<body>
<c:import url="/WEB-INF/pages/menu_haut.jsp" /></br>
     <div class="container">

       <div class="row">
             <div class="col-md-4 ">
                 <div class="panel panel-default">
                     <div class="panel-heading">
                         <span class="glyphicon glyphicon-lock"></span> Login
                     </div>
                     <div class="panel-body">
                         <form class="form-horizontal"  method="Post" action="identification">
                             <div class="form-group">
                                 <label for="inputEmail3" class="col-sm-3 control-label">
                                     Login</label>
                                 <div class="col-sm-9">
                                     <input type="text" class="form-control" id="inputEmail3" name="Email" required> ${message}</div>
                             </div>
                             <div class="form-group">
                                 <label for="inputPassword3" class="col-sm-3 control-label">
                                     Password</label>
                                 <div class="col-sm-9">
                                     <input type="password" class="form-control" id="inputPassword3" name="Password" required>
                                 </div>
                             </div>
                             <div class="form-group">
                                 <div class="col-sm-offset-3 col-sm-9">
                                     <div class="checkbox">
                                         <label> <input type="checkbox" /> Enregistrer le mot de passe
                                         </label>
                                     </div>
                                 </div>
                             </div>
                             <div class="form-group last">
                                 <div class="col-sm-offset-3 col-sm-9">
                                      <button type="submit" class="btn btn-success btn-sm">
                                         S'identifier</button> 
                                     <spring:url value="/accueil" var="accueil" htmlEscape="true" />
                                    <a href="${accueil}" type="reset" class="btn btn-default">Annuler </a>
<!--                                      <button type="reset" class="btn btn-default btn-sm">
                                         Annuler</button>
                                 </div> -->
                             </div>
                         </form>
                     </div>
                     <div class="panel-footer">
                         Non enregistré? <a href="profil">s'enregistrer maintenant</a>
                     </div>
                 </div>
             </div>
          </div>
                            <c:import url="/WEB-INF/pages/footer.jsp" /></br>
     </div>
</body>
</html>