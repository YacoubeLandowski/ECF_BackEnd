package DAO;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

public abstract class DAO {

    private SessionFactory sessionFactory = null;
    public DAO() {
        this.sessionFactory = sessionFactory;
    }


    // Méthodes de création

    public void createDepartement(Departement departement) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(departement);
            transaction.commit();
        }
    }

    public void createEnseignant(Enseignant enseignant) {
        if (enseignant.getNomProf() == null || enseignant.getNomProf().length() < 3) {
            throw new IllegalArgumentException("Le nom de l'enseignant doit avoir au moins 3 caractères.");
        }
        if (enseignant.getAgeProf() < 18) {
            throw new IllegalArgumentException("L'enseignant doit être majeur.");
        }
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(enseignant);
            transaction.commit();
        }
    }

    public void createEtudiant(Etudiant etudiant) {
        if (etudiant.getNomEtudiant() == null || etudiant.getNomEtudiant().length() < 3) {
            throw new IllegalArgumentException("Le nom de l'étudiant doit avoir au moins 3 caractères.");
        }
        if (etudiant.getPrenomEtudiant() == null || etudiant.getPrenomEtudiant().length() < 3) {
            throw new IllegalArgumentException("Le prénom de l'étudiant doit avoir au moins 3 caractères.");
        }
        if (!etudiant.getEmailEtudiant().toLowerCase().endsWith("@gmail.com")) {
            throw new IllegalArgumentException("L'adresse email de l'étudiant doit se terminer par @gmail.com.");
        }
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(etudiant);
            transaction.commit();
        }
    }

    public void createMatiere(Matiere matiere) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(matiere);
            transaction.commit();
        }
    }

    public void createNote(Note note) {
        if (note.getValeurNote() < 0 || note.getValeurNote() > 20) {
            throw new IllegalArgumentException("La valeur de la note doit être comprise entre 0 et 20.");
        }
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(note);
            transaction.commit();
        }
    }

    public void createClasse(Classe classe) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(classe);
            transaction.commit();
        }
    }

    public void createEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(emploiDuTemps);
            transaction.commit();
        }
    }


    // Les méthodes READ

    public List<Classe> getAllClassesWithoutStudent() {
        try (Session sesion= sessionFactory.openSession()) {
            Query<Classe> query = sesion.createQuery("SELECT new Classe(c.idClasse, c.nomClasse, c.niveauClasse, c.departement) FROM Classe c", Classe.class);
            return query.list();
        }
    }


    public abstract List<Classe> getAllClassesWithoutStudents();

    public int getNombreMatieresEleve(int idEtudiant) {
        try (Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery("SELECT COUNT(DISTINCT matiere.idMatiere) FROM Note WHERE etudiant.idEtudiant = :idEtudiant", Long.class);
            query.setParameter("idEtudiant", idEtudiant);
            return query.uniqueResult().intValue();
        }
    }


    public List<Note> getNotesEleveAvecDetails(int idEtudiant) {
        try (Session session = sessionFactory.openSession()) {
            Query<Note> query = session.createQuery("FROM Note WHERE etudiant.idEtudiant = :idEtudiant", Note.class);
            query.setParameter("idEtudiant", idEtudiant);
            return query.list();
        }
    }


    public double getMoyenneEleve(int idEtudiant) {
        try (Session session = sessionFactory.openSession()) {
            Query<Double> query = session.createQuery("SELECT AVG(valeurNote) FROM Note WHERE etudiant.idEtudiant = :idEtudiant", Double.class);
            query.setParameter("idEtudiant", idEtudiant);
            return query.uniqueResult() != null ? query.uniqueResult() : 0.0;
        }
    }


    public long getNombreElevesDepartement(int idDepartement) {
        try (Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Etudiant WHERE classe.departement.idDepartement = :idDepartement", Long.class);
            query.setParameter("idDepartement", idDepartement);
            return query.uniqueResult();
        }
    }


    public List<String> getNomsElevesNiveau(int niveauClasse) {
        try (Session session = sessionFactory.openSession()) {
            Query<String> query = session.createQuery("SELECT nomEtudiant FROM Etudiant WHERE classe.niveauClasse = :niveauClasse", String.class);
            query.setParameter("niveauClasse", niveauClasse);
            return query.list();
        }
    }



    // Les méthodes DELETE

    public void deleteEleve (int idEtudiant) {
        try (Session session= sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("DELETE FROM Note WHERE etudiant.idEtudiant = :idEtudiant");
            query.setParameter("idEtudiant", idEtudiant);
            query.executeUpdate();

            Etudiant etudiant = session.get(Etudiant.class, idEtudiant);
            session.delete(etudiant);

            transaction.commit();
        }
    }

    public void deleteClasse(int idClasse) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("DELETE FROM Etudiant WHERE classe.idClasse = :idClasse");
            query.setParameter("idClasse", idClasse);
            query.executeUpdate();

            Classe classe = session.get(Classe.class, idClasse);
            session.delete(classe);

            transaction.commit();
        }
    }

    public void deleteDepartement(int idDepartement) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query queryClasses = session.createQuery("DELETE FROM Classe WHERE departement.idDepartement = :idDepartement");
            queryClasses.setParameter("idDepartement", idDepartement);
            queryClasses.executeUpdate();

            Query queryEnseignants = session.createQuery("DELETE FROM Enseignant WHERE departement.idDepartement = :idDepartement");
            queryEnseignants.setParameter("idDepartement", idDepartement);
            queryEnseignants.executeUpdate();

            Departement departement = session.get(Departement.class, idDepartement);
            session.delete(departement);

            transaction.commit();
        }
     }



}


