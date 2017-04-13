<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="fr">


<body class="grey lighten-4">

<div class="container">


        <div class="row">
            <p class="flow-text col offset-m1" style="margin: 0;">
                Voici la liste des rendez-vous en attente de validation
            </p>
        </div>
   


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

</body>
