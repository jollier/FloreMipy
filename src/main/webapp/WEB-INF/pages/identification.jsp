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

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-lock"></span> Login</h4>
      </div>
      <div class="modal-body">
       <!--  div class="container"-->

       <div class="row">
             <!--  div class="col-md-4 "-->
                 <div class="panel panel-default">
                     <div class="panel-heading">
                         
                     </div>
                     <div class="panel-body">
                         <form class="form-horizontal"  method="Post" action="identification">
                             <div class="form-group">
                                 <label for="inputEmail3" class="col-sm-3 control-label">Login</label>
                                 <div class="col-sm-9">
                                     <input type="text" class="form-control" id="inputEmail3" name="Email" required> 
                                     ${message}
                                 </div>
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
                                      <button type="submit" class="btn btn-success btn-sm">S'identifier</button> 
                                      <spring:url value="/accueil" var="accueil" htmlEscape="true" />
                                      <!--  a href="${accueil}" type="reset" class="btn btn-default">Annuler </a-->
                                      <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
                                      <!--  button type="reset" class="btn btn-default btn-sm">
                                         Annuler</button-->
                                 </div> 
                             </div>
                            
                         </form>
                     </div>
                     <div class="panel-footer">
                         Non enregistré? <a href="profil">s'enregistrer maintenant</a>
                     </div>
                 </div>
             </div>
          </div>
     </div>
      <div class="modal-footer">
        <!-- 
        <button type="button" class="btn btn-success">S'identifier</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
         
        -->
      </div>
    </div>
  </div>

</body>



</html>