package IHM;

import DAO.DaoImpl;
import DAO.HibernateUtil;
import entity.Classe;
import entity.Note;
import org.hibernate.Cache;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

public class IHM {

    private static DaoImpl dao;


    public static void main(String[] args) {


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        dao = new DaoImpl(sessionFactory);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Afficher la liste des classes (sans les élèves)");
            System.out.println("2. Afficher le nombre de matières d'un élève");
            System.out.println("3. Afficher la liste des notes d'un élève (avec les détails)");
            System.out.println("4. Afficher la moyenne d'un élève");
            System.out.println("5. Afficher le nombre d'élèves d'un département");
            System.out.println("6. Afficher tous les noms des élèves d'un niveau");
            System.out.println("7. Quitter");
            System.out.print("Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    AfficheClasseSansEtudiant();
                    break;
                case 2:
                    AfficheNombreMatiereEleve();
                    break;
                case 3:
                    AfficheNotesEleve();
                    break;
                case 4:
                    AfficheMoyenneEtudiant();
                    break;
                case 5:
                    AfficheNombreEleveParDepartement();
                    break;
                case 6:
                    AfficheNomsElevesParNiveau();
                    break;
                case 7:
                    System.out.println("Programme coupé!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void AfficheClasseSansEtudiant() {
        List<Classe> classes = dao.getAllClassesWithoutStudents();
        System.out.println("Liste des classes :");
        for (Classe classe : classes) {
            System.out.println(classe);
        }
    }

    private static void AfficheNombreMatiereEleve() {
        System.out.print("Entrez l'ID de l'élève : ");
        int idEtudiant = new Scanner(System.in).nextInt();
        int nombreMatieres = dao.getNombreMatieresEleve(idEtudiant);
        System.out.println("Nombre de matières de l'élève : " + nombreMatieres);
    }

    private static void AfficheNotesEleve() {
        System.out.print("Entrez l'ID de l'élève : ");
        int idEtudiant = new Scanner(System.in).nextInt();
        List<Note> notes = dao.getNotesEleveAvecDetails(idEtudiant);
        System.out.println("Liste des notes de l'élève :");
        for (Note note : notes) {
            System.out.println(note);
        }
    }

    private static void AfficheMoyenneEtudiant() {
        System.out.print("Entrez l'ID de l'élève : ");
        int idEtudiant = new Scanner(System.in).nextInt();
        double moyenne = dao.getMoyenneEleve(idEtudiant);
        System.out.println("Moyenne de l'élève : " + moyenne);
    }

    private static void AfficheNombreEleveParDepartement() {
        System.out.print("Entrez l'ID du département : ");
        int idDepartement = new Scanner(System.in).nextInt();
        long nombreEleves = dao.getNombreElevesDepartement(idDepartement);
        System.out.println("Nombre d'élèves dans le département : " + nombreEleves);
    }

    private static void AfficheNomsElevesParNiveau() {
        System.out.print("Entrez le niveau de la classe : ");
        int niveauClasse = new Scanner(System.in).nextInt();
        List<String> nomsEleves = dao.getNomsElevesNiveau(niveauClasse);
        System.out.println("Noms des élèves dans le niveau " + niveauClasse + " :");
        for (String nom : nomsEleves) {
            System.out.println(nom);
        }
    }
}