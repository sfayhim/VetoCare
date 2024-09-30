package mvcController;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvcModel.AnimalService;
import mvcModel.RendezvousService;
import mvcModel.VetService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entities.Rendezvous;
import entities.Vet;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @EJB
    private RendezvousService rendezvousService ;
    @EJB
    private VetService vetService ;
    @EJB
    private AnimalService animalService ;
    
    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        doPost(request, response);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buttonValue = request.getParameter("myBtn");
        
        //Login 
        if (buttonValue != null && "login".equals(buttonValue)) {
            String nom = request.getParameter("nom");
            String pwd = request.getParameter("pwd");

            Vet vet = vetService.getVetoByNameandPassword(nom, pwd);
            if (vet != null) {
                HttpSession session = request.getSession();
                session.setAttribute("vet", vet); 
                response.sendRedirect("GestionRDV.jsp");
            } else {
                request.setAttribute("erreur", "Nom ou mot de passe incorrect");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        //Ajouter & Afficher
            
        } else if ("addRendezvous".equals(buttonValue)) {
        	String date = request.getParameter("date");
            String heure = request.getParameter("heure");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = null;
            try {
                parsedDate = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace(); // Handle parsing exception appropriately
            }
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date parsedTime = null;
            try {
                parsedTime = timeFormat.parse(heure);
            } catch (ParseException e) {
                e.printStackTrace(); // Handle parsing exception appropriately
            }
            String raisonVisite = request.getParameter("raisonVisite");
            String statut = request.getParameter("status");
            int idAnimal = Integer.parseInt(request.getParameter("idAnimal"));
            if (animalService.getAnimalById(idAnimal)==null) {
                request.setAttribute("successMessage", "Animal Inexistant !!");
                request.getRequestDispatcher("GestionRDV.jsp").forward(request, response);
            }

            Rendezvous rendezvous = new Rendezvous();
            rendezvous.setDateRendezvous(parsedDate);
            rendezvous.setHeureRendezvous(parsedTime);
            rendezvous.setRaisonVisite(raisonVisite);
            rendezvous.setStatut(statut);
            rendezvous.setAnimal(animalService.getAnimalById(idAnimal));
            
            rendezvousService.addRdv(rendezvous);
            request.setAttribute("successMessage", "Animal Ajouté Avec succés !!");
            List<Rendezvous> dataRDV =  rendezvousService.getAllRdv();
            List<Rendezvous> listRdv = new ArrayList<>(dataRDV.size() + 1);
            for( Rendezvous rdv : dataRDV) {
            	listRdv.add(rdv);
            }
            request.setAttribute("listRdv",listRdv);
            RequestDispatcher dispatcher = request.getRequestDispatcher("GestionRDV.jsp");
            dispatcher.forward(request, response);
            
          //Supprimer 
        } else if ("supprimer".equals(buttonValue)) {
        	int id = Integer.parseInt(request.getParameter("id"));
        	List<Rendezvous> newList = rendezvousService.deleteRendezvousById(id);
        	request.setAttribute("listRdv", newList);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("GestionRDV.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
