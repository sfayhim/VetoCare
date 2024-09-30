<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>Login Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<style>
	body {
 	 	background-image: url('https://img.freepik.com/photos-gratuite/gros-plan-medecin-veterinaire-prenant-soin-animal-compagnie_23-2149267934.jpg');
 	 	background-size: cover; /* Cover the entire page */
        background-repeat: no-repeat; 
	}
</style>

<body style="background-color: #f8f9fa;">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h3 class="card-title text-center mb-4">Login</h3>
                    <form action="Controller" method="post">
                        <div class="mb-3">
                            <label for="nom" class="form-label">Nom :</label>
                            <input type="text" class="form-control" id="nom" name="nom" placeholder="Entrez votre nom">
                        </div>
                        <div class="mb-3">
                            <label for="numero" class="form-label">Mot de passe:</label>
                            <input type="password" class="form-control mb-3" id="pwd" name="pwd" placeholder="Entrez votre Mot de passe">
                        </div>
                        <br>
                        <div class="text-center ">
                            <button type="submit" class="btn btn-primary mb-3" value="login" name="myBtn">Login</button>
                        </div>
                        <div class="text-center">
                            <c:out value="${erreur}"></c:out>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
