 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>





<%@ include file="../jsp/headerBack.jsp" %>

<body>

<!--Import JQuery-->
		<script src="bootstrap/jquery/jquery-3.1.1.min.js"></script>
		
		<!--Import Google Icon Font-->
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>


		<!--Import materialize-->
		<link type="text/css" rel="stylesheet" href="../materialize/css/materialize.css">
		<script type="text/javascript" src='../materialize/js/materialize.js'></script>
		
		
		<!--Import momentdesoi-->
		<script src="../bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css"/>
		<script src='../js/jquery.qtip.js'></script>
		<link rel='stylesheet' href='../css/jquery.qtip.css' />
		<link rel='stylesheet' href='../css/surcouche.css' />
		
		<div class="container">

    <div class="card-panel white calendrierForme">

        <h2 class="titreListe">
            Liste des rendez-vous en attente de validation :
        </h2>


   


	<c:forEach var="evenements" items="${evenements}" varStatus="pStatus">
        <form:input path="evenements[${pStatus.index}].evenement_id"/>
        <form:input path="evenements[${pStatus.index}].evenement_nom"/>


        <div class="card-panel white">


            <div class="row">

                


                <div class="col">
                    <a href="supprimer?id=${evenements.evenement_id}" class="btn-floating red">
                        <i class="material-icons">delete</i></a>
                </div>


                
                        <div class="col">
                            <a href="valider?id=${evenements.evenement_id}" class="btn-floating green modal-trigger"><i
                                    class="material-icons">check</i></a>
                        </div>
                   


            </div> 


            <p>
             Nom : ${evenements.evenement_nom},
            </p>

            <p>
             Date début: ${evenements.evenement_date_debut},
             Heure début : ${evenements.evenement_heure_debut} ,
            </p>

            <p>
             Description : ${evenements.evenement_description}
            </p>

        </div>
        

  </c:forEach>

</div>
</div>


</body>

<%@ include file="../jsp/footerBack.jsp" %>

</html>
