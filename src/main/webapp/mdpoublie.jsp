<%--
  Created by IntelliJ IDEA.
  User: Cesar
  Date: 10/05/16
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">



<body class="grey lighten-4">


<nav>
    <div class="nav-wrapper red">
    </div>
</nav>

<div class="container">

    <div class="card-panel white">
        <div class="row">
            <form class="col s12" method="post" name="mdpoublie">
                <h3 class="center blue-text flow-text" style="font-weight: 300;">
                    Mot de passe oublié
                </h3>


                <div class="row">
                    <div class="input-field col offset-m2 s12 m8">


                        <input class="validate" type="email" id="email" name="utilisateur_mail"
                               value="<c:out value="${utilisateur.utilisateur_mail}"/>"
                               size="20" maxlength="60"/>
                        <label for="email">Adresse email @hei.fr <span class="requis">*</span></label>

                        <span class="erreur">${erreurs['utilisateur_mail']}</span>
                    </div>
                </div>

                <div class="row">
                    <button class="waves-effect waves-light btn col offset-m4 offset-l5 s12 m4 l2" type="submit"
                            value="Inscription"
                            name="bouton">Mail
                    </button>
                </div>

                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>


            </form>

        </div>
    </div>

</div>



</body>

</html>
