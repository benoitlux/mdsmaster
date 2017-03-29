<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>

<!--Import JQuery-->
		<script src="bootstrap/jquery/jquery-3.1.1.min.js"></script>
		
		<!--Import Google Icon Font-->
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>

		
		<!--Import moment-->
		<script src='fullcalendar/lib/moment.min.js'></script>
		
		
		
		
		<!--Import momentdesoi-->
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/navbar.css">
		<link href="css/prestations.css" rel="stylesheet">
		<link rel="stylesheet" href="css/footer.css">
		<script type="text/javascript" src="js/script.js"></script>
		<link rel='stylesheet' href='css/calendrier.css' />
		
		<!--Import materialize-->
		<link type="text/css" rel="stylesheet" href="materialize/css/materialize.css">
		<script type="text/javascript" src='materialize/js/materialize.js'></script>
		<script type="text/javascript" src='js/formulaire.js'></script>

<div class="container">

    <div class="card-panel white">

        <h2 class="center blue-text" style="font-weight: 300;">
            Prendre rendez-vous
        </h2>

        <form method="post" action="ajouter">
            <div class="row">

                <!-- ************ Informations générales *********   -->

                

                <div class="input-field col offset-m2 s12 m8">
                    <input id="titre" type="text" name="evenement_nom" class="validate" required>
                    <label for="titre">Nom</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col offset-m2 s12 m8">
                    <select name="evenement_couleur" required>
                        <option value="" disabled selected>Prestation :</option>
                        <option value="soinvisage">Soin du visage</option>
                        <option value="soinspe">Soin spécifique</option>
                        <option value="bienetre">Parcours bien-être</option>
                        <option value="soincorps">Soin du corps</option>
                        <option value="uva">UVA</option>
                        <option value="epilation">Epilation</option>
                        <option value="regardmaquillage">Regard et maquillage</option>
                    </select>
                </div>
            </div>


            

              


            <div class="row">
                <div class="input-field col offset-m2 s12 m8">
                            <textarea id="description" class="materialize-textarea" name="evenement_description"
                                      length="120"></textarea>
                    <label for="description">Commentaire</label>
                </div>
            </div>


            


            <!-- ************ Début *********   -->

            <div class="row">
                <span style="margin-top: 20px;" class="flow-text col offset-m2">Début</span>
            </div>

            <div class="row">
                <div class="input-field col offset-m2 s12 m8">
                    <!-- <label for="debut">Date de début</label> -->
                    <input type="date" id="evenement_date_debut" name="evenement_date_debut" class="datepicker"
                           required/>
                    <label for="evenement_date_debut">Date début</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col offset-m2 s6 m4">
                    <select name="evenement_heure_debut" required>
                        <option value="" disabled selected>Heure de début</option>
                        
                        <option value="09">09 heures</option>
                        <option value="10">10 heures</option>
                        <option value="11">11 heures</option>
                        <option value="12">12 heures</option>
                        <option value="13">13 heures</option>
                        <option value="14">14 heures</option>
                        <option value="15">15 heures</option>
                        <option value="16">16 heures</option>
                        <option value="17">17 heures</option>
                        <option value="18">18 heures</option>
                        <option value="19">19 heures</option>
                       
                    </select>
                </div>


                <div class="input-field col s6 m4">
                    <select name="evenement_minute_debut" required>
                        <option value="" disabled selected>Minute</option>
                        <option value=":00:00">00 minute</option>
                        <option value=":15:00">15 minutes</option>
                        <option value=":30:00">30 minutes</option>
                        <option value=":45:00">45 minutes</option>

                    </select>
                </div>
            </div>


            <!-- ************ Fin *********   -->


            <div class="row">
                <span class="flow-text col offset-m2">Fin</span>
            </div>

            <div class="row">
                <div class="input-field col offset-m2 s12 m8">
                    <!-- <label for="debut">Date de début</label> -->
                    <input type="date" id="evenement_date_fint" name="evenement_date_fin" class="datepicker"
                           required/>
                    <label for="evenement_date_fint">Date fin</label>

                </div>
            </div>

            <div class="row">
                <div class="input-field col offset-m2 s6 m4">
                    <select id="evenement_heure_fin" name="evenement_heure_fin" required>
                        <option value="" disabled selected>Heure de fin</option>
                       
                        <option value="09">09 heures</option>
                        <option value="10">10 heures</option>
                        <option value="11">11 heures</option>
                        <option value="12">12 heures</option>
                        <option value="13">13 heures</option>
                        <option value="14">14 heures</option>
                        <option value="15">15 heures</option>
                        <option value="16">16 heures</option>
                        <option value="17">17 heures</option>
                        <option value="18">18 heures</option>
                        <option value="19">19 heures</option>
                        
                    </select>
                </div>


                <div class="input-field col s6 m4">
                    <select id="evenement_minute_fin" name="evenement_minute_fin" required>
                        <option value="" disabled selected>Minute</option>
                        <option value=":00:00">00 minute</option>
                        <option value=":15:00">15 minutes</option>
                        <option value=":30:00">30 minutes</option>
                        <option value=":45:00">45 minutes</option>

                    </select>
                </div>
            </div>


           

            <!-- ************ Boutons *********   -->

            <div class="row">
                <div class="col offset-m3 s6 m3">
                    <button class="green btn waves-effect waves-light" type="submit"
                            name="action">Enregistrer
                        <i class="material-icons right">save</i>
                    </button>
                </div>


                <div class="col s6 m3">
                    <a class="btn red waves-effect waves-light" href=javascript:history.go(-1)>Annuler
                        <i class="material-icons right">cancel</i>
                    </a>
                </div>
            </div>
        </form>

    </div>

</div>

<script>
    $(document).ready(function () {

    	$('#textarea1').trigger('autoresize');

        $('.datepicker').pickadate({
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 1, // Creates a dropdown of 15 years to control year
            labelMonthNext: 'Suivant',
            labelMonthPrev: 'Précédent',
            monthsFull: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
            monthsShort: ['Janv.', 'Févr.', 'Mars', 'Avril', 'Mai', 'Juin', 'Juil.', 'Août', 'Sept.', 'Oct.', 'Nov.', 'Déc.'],
            weekdaysFull: ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'],
            weekdaysShort: ['Dim.', 'Lun.', 'Mar.', 'Mer.', 'Jeu.', 'Ven.', 'Sam.'],
            weekdaysLetter: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
            today: 'Auj.',
            clear: 'Supp.',
            close: 'Fermer',
            format: 'yyyy-mm-dd'
        });

        $(document).ready(function () {
            $('select').material_select();
        });

    })
    ;
    
    
    

    
    evenements.forEach(function (evenement) {
   	    console.log(evenement);
   	    {
   	        title: evenement.evenement_nom;
   	        start: evenement.evenement_date_debutTevenement.evenement_heure_debutZ;
   	        end: evenement.evenement_date_finTevenement.evenement_heure_finZ;
   	    }


   	});
   		 
</script>


</body>
</html>