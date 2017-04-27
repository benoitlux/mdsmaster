<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="container marketing">
	<div class="row">
        <div class="col-lg-4 col-md-6 ">
          <img class="img-circle" src="../img/phone.png" alt="Generic placeholder image" width="100" height="100">
          <h2 class="text_footer">CONTACT</h2>
		  
          <div class="col-md-4">
                    <ul class="part">
                        <li class="text_footer">Téléphone</li>
                        </br>
												
						<li class="text_footer">Mail</li>
                        
					</ul>
				</div>
				
				<div class="col-md-4" th:each="information :${information}">
                    <ul class="part">
                        <li th:text="${information.Telephone1}" class="text_footer"></li>
                        <li th:text="${information.Telephone2}" class="text_footer"></li>
						<li th:text="${information.Mail}" class="text_footer"></li>
						
                        
					</ul>
				</div>
          
        </div>
		
        <div class="col-lg-4">
          <img class="img-circle" src="../img/time.png" alt="Generic placeholder image" width="100" height="100">
          <h2 class="text_footer">HORAIRES</h2>
		  
          <div class="col-md-6">
                    <ul class="part">
                        <li  class="text_footer">Dimanche/Lundi</li>
                        <li class="text_footer">Mardi/Vendredi</li>
                        <li class="text_footer">Samedi</li>
                        <li class="text_footer">Congé</li>
						
                        
                    </ul>
                </div>
            	<div class="col-md-6" th:each="information :${information}">
                    <ul class="part">
                        
                        
						<li th:text="${information.DimancheLundi}" class="text_footer" ></li>
						<li th:text="${information.MardiVendredi}" class="text_footer" ></li>
						<li th:text="${information.Samedi}" class="text_footer" ></li>
						<li th:text="${information.conge}" class="text_footer" ></li>
						
                        
                    </ul>
                </div>
          
        </div>
		
		<div class="col-lg-4">
		
		<img class="img-circle img-home" src="../img/home.png" alt="Generic placeholder image" width="100" height="100">
          <h2 class="text_footer">NOUS TROUVER</h2>
		 
		  <p class="text_footer"> 547 rue Saint Jean  59246 Mons-en-Pévèle</p> 
		
		
		</div>
		
        
      </div>
      </div>