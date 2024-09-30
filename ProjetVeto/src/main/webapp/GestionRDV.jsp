<%@ page import="mvcModel.RendezvousService" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="entities.Rendezvous" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <title>Gestion Rendez Vous</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<style>
	body {
	  background-image: url('https://www.nmbu.no/_next/image?url=%2Fimages%2Fplaceholder-03.png&w=3840&q=75');
	  background-size: cover; 
      background-repeat: no-repeat; 
	}
</style>
<body>
<div class="container mt-5">
   <h1 class="text-center mb-4 text-primary">Gestion des Rendez-vous</h1>
    <div class="card mb-4">
        <div class="card-header">
            Ajouter un Rendez-vous
        </div>
        <div class="card-body">
            <form action="Controller" method="post">
                <div class="mb-3">
                    <label for="date">Date :</label>
                    <input type="date" class="form-control" id="date" name="date" required>
                </div>
                <div class="mb-3">
                    <label for="heure">Heure :</label>
                    <input type="time" class="form-control" id="heure" name="heure" required>
                </div>
                <div class="mb-3">
                    <label for="raisonVisite">Raison de la visite :</label>
                    <input type="text" class="form-control" id="raisonVisite" name="raisonVisite" required>
                </div>
                <div class="mb-3">
                    <label for="idAnimal">Animal ID :</label>
                    <input type="number" class="form-control" id="idAnimal" name="idAnimal" required>
                </div>
                <div class="mb-3">
                    <label for="status">Status :</label>
                    <input type="text" class="form-control" id="status" name="status" required>
                </div><br>
                <div class="text-center ">
                    <button type="submit" name="myBtn" value="addRendezvous" class="btn btn-primary">Ajouter Rendez-vous</button>
                </div>
                <div class="text-center text-primary">
                   <c:out value="${successMessage}"></c:out>
                </div>
                
            </form>
        </div>
    </div>
    
    <div class="card">
        <div class="card-header">
            Liste des Rendez-vous
        </div>
        <div class="card-body">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Heure</th>
                        <th>Animal</th>
                        <th>Raison de la visite</th>
                        <th>Statut</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listRdv}" var="rdv">
                    <tr>
                        <td>${rdv.date}</td>
                        <td>${rdv.heure}</td>
                        <td>${rdv.idAnimal}</td>
                        <td>${rdv.raisonVisite}</td>
                        <td>${rdv.statut}</td>
                        <td>
                            <form action="Controller" method="post">
                                <input type="hidden" name="id" value="${rdv.idRendezvous}">
                                <button type="submit" name="myBtn" value="supprimer" class="btn btn-sm btn-danger">Supprimer</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
