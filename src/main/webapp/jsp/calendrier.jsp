 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>


<%@ include file="../jsp/header.jsp" %>
<head><title>Institut de beauté Moment de soi Mons en Pévèle</title></head>

<body>


<!--Import JQuery-->
		<script src="bootstrap/jquery/jquery-3.1.1.min.js"></script>
		
		<!--Import Google Icon Font-->
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>

		
		<!--Import moment-->
		<script src='fullcalendar/lib/moment.min.js'></script>
		
		
		<!--Import fullcalendar-->
		<link rel='stylesheet' href='css/fullcalendar.min.css' />
		<script src='fullcalendar/fullcalendar.min.js'></script>
		<script type="text/javascript" src="fullcalendar/locale/fr.js"></script>
		<script src='js/agendajs.js'></script>
		<script src='js/jquery-ui.min.js'></script>
		

		<!--Import materialize-->
		<link type="text/css" rel="stylesheet" href="materialize/css/materialize.css">
		<script type="text/javascript" src='materialize/js/materialize.js'></script>
		
		
		<!--Import momentdesoi-->
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link href="css/prestations.css" rel="stylesheet">
		<script type="text/javascript" src="js/script.js"></script>
		<script src='js/jquery.qtip.js'></script>
		<link rel='stylesheet' href='css/jquery.qtip.css' />
		<link rel='stylesheet' href='css/surcouche.css' />
	


<!-- Full Calendar -->
<div class="container calendrier">

<div class="card-panel white calendrierForme">

	<div class="row"><input type="button" class="green btn waves-effect waves-light" name="action" value="Prendre-Rendez-Vous" onclick="self.location.href='ajouter'" ></div>
        <div id="calendar"></div>
		
</div>
</div>


<script>

$(document).ready(function () {
	
	 

    $('#calendar').fullCalendar({
        height: "auto",
		minTime: "09:00:00",
		maxTime: "19:30:00",
        editable: false,
       
        
        defaultView: 'agendaWeek',
       
        
        color: 'grey lighten-4',     // an option!
		hiddenDays: [0, 1],
		
		businessHours:[ 
        {
            start: '09:30:00',
            end: '19:00:00',
            dow: [2, 3, 4, 5]
        },
        {
            start: '09:30:00',
            end: '14:00:00',
            dow: [6]
        }
    ],

       //Mise en forme du header
        header: {
            prev: 'circle-triangle-w',
            next: 'circle-triangle-e',
            left: 'prev,next today',
            center: 'title',
            right: 'agendaWeek,agendaDay',
        },
        
        slotEventOverlap:false,
       
    
        events: [
            <c:forEach var="evenements" items="${evenements}" varStatus="pStatus">
     
            {
                id: '${evenements.evenement_id}',
                title: 'RDV non disponible',
                start: '${evenements.evenement_date_debut}T${evenements.evenement_heure_debut}Z',
                end: moment('${evenements.evenement_date_debut}T${evenements.evenement_heure_debut}Z').add('hours', '${evenements.duree}'),
              

           
                color:'#FF0000'

            },

     
            </c:forEach>
        ],
        
        
      
        
		});
	
});






</script>




</body>
<%@ include file="../jsp/footer.jsp" %>
</html>