<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<html>

<!-- Modal -->
<form class="form-horizontal"  method="Post" action="<c:url value='/identification'/>" >
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-lock"></span> Login</h4>
      </div>
      <div class="modal-body">
       
         <div class="row">
             <div class="panel panel-default">
                     <div class="panel-heading">
                     </div>
                     <div class="panel-body">
                         
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
                         
                     </div>
                     <div class="panel-footer">
                         Non enregistré? <a href="profil">s'enregistrer maintenant</a>
                     </div>
                 </div>
             </div>
          </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-success btn-sm">S'identifier</button> 
        <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
      </div>
    </div>
  </div>
</div>
</form>


</html>