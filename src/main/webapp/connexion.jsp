<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">



<body class="grey lighten-4">



<div class="container">

    <div class="card-panel white">
        <div class="row">
            <form class="col s12" method="post" name="connexion">
                <h3 class="center blue-text flow-text" style="font-weight: 300;">
                    Connexion
                </h3>

                <p class="center ${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>


                <div class="row">
                    <div class="input-field col offset-m2 s12 m8">


                        <input class="validate" type="email" id="email" name="email"
                               value="<c:out value="${utilisateur.utilisateur_mail}"/>"
                               size="20" maxlength="60"/>
                        <label for="email">Adresse email <span class="requis">*</span></label>

                        <span class="erreur">${form.erreurs['email']}</span>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col offset-m2 s12 m8">

                        <input class="validate" type="password" id="motdepasse" name="motdepasse"
                               value="<c:out value="${utilisateur.utilisateur_mdp}"/>" size="20"
                               maxlength="20"/>
                        <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                        <span class="erreur">${form.erreurs['motdepasse']}</span>
                    </div>
                </div>

                
                <div class="row">
                    <button class="waves-effect waves-light btn col offset-m4 offset-l5 s12 m4 l2" type="submit"
                            value="Connexion"
                            name="bouton">Connexion
                    </button>
                </div>

            </form>




        </div>
    </div>

    <div class="row center">
        <a class="blue-text" href="mdpoublie">Mot de passe oublié?</a>
    </div>

</div>



</body>
</html>