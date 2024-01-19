package DAO;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DaoImpl extends DAO {

    private final SessionFactory sessionFactory;

    public DaoImpl(SessionFactory sessionFactory) {
        super();
        this.sessionFactory = sessionFactory;
    }

    // --- Create Operations ---

    @Override
    public void createDepartement(Departement departement) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(departement);
            transaction.commit();
        }
    }

    @Override
    public void createEnseignant(Enseignant enseignant) {
        validateEnseignant(enseignant);
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(enseignant);
            transaction.commit();
        }
    }

    @Override
    public void createEtudiant(Etudiant etudiant) {
        validateEtudiant(etudiant);
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(etudiant);
            transaction.commit();
        }
    }

    @Override
    public void createMatiere(Matiere matiere) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(matiere);
            transaction.commit();
        }
    }

    @Override
    public void createNote(Note note) {
        validateNote(note);
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(note);
            transaction.commit();
        }
    }

    @Override
    public void createClasse(Classe classe) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(classe);
            transaction.commit();
        }
    }

    @Override
    public void createEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(emploiDuTemps);
            transaction.commit();
        }
    }

    // --- Read Operations ---

    @Override
    public List<Classe> getAllClassesWithoutStudents() {
        try (Session session = sessionFactory.openSession()) {
            Query<Classe> query = session.createQuery("SELECT new Classe(c.idClasse, c.nomClasse, c.niveauClasse, c.departement) FROM Classe c", Classe.class);
            return query.list();
        }
    }

    @Override
    public int getNombreMatieresEleve(int idEtudiant) {
        try (Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery("SELECT COUNT(DISTINCT matiere.idMatiere) FROM Note WHERE etudiant.idEtudiant = :idEtudiant", Long.class);
            query.setParameter("idEtudiant", idEtudiant);
            return query.uniqueResult().intValue();
        }
    }

    @Override
    public List<Note> getNotesEleveAvecDetails(int idEtudiant) {
        try (Session session = sessionFactory.openSession()) {
            Query<Note> query = session.createQuery("FROM Note WHERE etudiant.idEtudiant = :idEtudiant", Note.class);
            query.setParameter("idEtudiant", idEtudiant);
            return query.list();
        }
    }

    @Override
    public double getMoyenneEleve(int idEtudiant) {
        try (Session session = sessionFactory.openSession()) {
            Query<Double> query = session.createQuery("SELECT AVG(valeurNote) FROM Note WHERE etudiant.idEtudiant = :idEtudiant", Double.class);
            query.setParameter("idEtudiant", idEtudiant);
            return query.uniqueResult() != null ? query.uniqueResult() : 0.0;
        }
    }

    @Override
    public long getNombreElevesDepartement(int idDepartement) {
        try (Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Etudiant WHERE classe.departement.idDepartement = :idDepartement", Long.class);
            query.setParameter("idDepartement", idDepartement);
            return query.uniqueResult();
        }
    }

    @Override
    public List<String> getNomsElevesNiveau(int niveauClasse) {
        try (Session session = sessionFactory.openSession()) {
            Query<String> query = session.createQuery("SELECT nomEtudiant FROM Etudiant WHERE classe.niveauClasse = :niveauClasse", String.class);
            query.setParameter("niveauClasse", niveauClasse);
            return query.list();
        }
    }

    // --- Delete Operations ---

    @Override
    public void deleteEleve(int idEtudiant) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Etudiant etudiant = session.get(Etudiant.class, idEtudiant);
            if (etudiant != null) {
                session.delete(etudiant);
            }
            transaction.commit();
        }
    }

    @Override
    public void deleteClasse(int idClasse) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Classe classe = session.get(Classe.class, idClasse);
            if (classe != null) {
                session.delete(classe);
            }
            transaction.commit();
        }
    }

    @Override
    public void deleteDepartement(int idDepartement) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Departement departement = session.get(Departement.class, idDepartement);
            if (departement != null) {
                session.delete(departement);
            }
            transaction.commit();
        }
    }

    //  Méthodes de contraintes
    private void validateEnseignant(Enseignant enseignant) {
        if (enseignant.getNomProf() == null || enseignant.getNomProf().length() < 3) {
            throw new IllegalArgumentException("Le nom de l'enseignant doit avoir au moins 3 caractères.");
        }
        if (enseignant.getAgeProf() < 18) {
            throw new IllegalArgumentException("L'enseignant doit être majeur.");
        }
    }

    private void validateEtudiant(Etudiant etudiant) {
        if (etudiant.getNomEtudiant() == null || etudiant.getNomEtudiant().length() < 3) {
            throw new IllegalArgumentException("Le nom de l'étudiant doit avoir au moins 3 caractères.");
        }
        if (etudiant.getPrenomEtudiant() == null || etudiant.getPrenomEtudiant().length() < 3) {
            throw new IllegalArgumentException("Le prénom de l'étudiant doit avoir au moins 3 caractères.");
        }
        if (!etudiant.getEmailEtudiant().toLowerCase().endsWith("@gmail.com")) {
            throw new IllegalArgumentException("L'adresse email de l'étudiant doit se terminer par @gmail.com.");
        }
    }

    private void validateNote(Note note) {
        if (note.getValeurNote() < 0 || note.getValeurNote() > 20) {
            throw new IllegalArgumentException("La valeur de la note doit être comprise entre 0 et 20.");
        }
    }
}
