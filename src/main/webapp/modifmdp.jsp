<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@ include file="../jsp/headerBack.jsp" %>

<body class="grey lighten-4">




<div class="container">

    <div class="row">
        <div class="col s12 l6 offset-l3">
            <div class="card-panel white">

                <form method="post" name="modifiermdp" action="modifiermdp">
                    <h3 class="center blue-text flow-text" style="font-weight: 300;">
                        Modifier le mot de passe
                    </h3>

                    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>


                    <input type="hidden" name="utilisateur_mail"
                           value="${sessionScope.sessionUtilisateur.utilisateur_mail}">

                    <div class="row">
                        <div class="input-field col s12">
                            <input id="password" type="password" class="validate" name="utilisateur_ancien_mdp">
                            <label for="password">Ancien mot de passe</label>
                            <span class="erreur">${form.erreurs['utilisateur_ancien_mdp']}</span>

                        </div>
                    </div>


                    <div class="row">
                        <div class="input-field col s12">
                            <input id="passwordnew" type="password" class="validate" name="utilisateur_nouveau_mdp">
                            <label for="passwordnew">Nouveau mot de passe</label>
                            <span class="erreur">${form.erreurs['utilisateur_nouveau_mdp']}</span>

                        </div>
                    </div>


                    <div class="row">
                        <div class="input-field col s12">
                            <input id="passwordconfirm" type="password" class="validate"
                                   name="utilisateur_confirmation_mdp">
                            <label for="passwordconfirm">Confirmation mot de passe</label>
                            <span class="erreur">${form.erreurs['utilisateur_confirmation_mdp']}</span>

                        </div>
                    </div>


                    <div class="row">
                        <button class="waves-effect waves-light btn col offset-m4 s12 m4 " type="submit"
                                value="Modifier"
                                name="bouton">Modifier
                        </button>
                    </div>

                </form>
            </div>
        </div>
    </div>


</div>



<script src='../js/fullcalendar.js'></script>
<script type="text/javascript" src="../js/qtip-1.0.0.min.js"></script>
<script src='../js/lang-all.js'></script>

</body>
</html>
