CREATE TABLE Etablissement(
   id_etablissement INT,
   nom_etablissement VARCHAR(50),
   PRIMARY KEY(id_etablissement)
);

CREATE TABLE Departement(
   id_departement INT,
   nom_departement VARCHAR(50),
   id_etablissement INT NOT NULL,
   PRIMARY KEY(id_departement),
   FOREIGN KEY(id_etablissement) REFERENCES Etablissement(id_etablissement)
);

CREATE TABLE Enseignant(
   id_enseignant INT,
   matricule_prof INT,
   prenom_prof VARCHAR(50),
   age_prof INT,
   grade_prof VARCHAR(50),
   prof_principal BOOLEAN,
   nom_prof VARCHAR(50),
   id_departement INT NOT NULL,
   PRIMARY KEY(id_enseignant),
   UNIQUE(matricule_prof),
   FOREIGN KEY(id_departement) REFERENCES Departement(id_departement)
);

CREATE TABLE ResponsableDepartement(
   id_responsable INT,
   id_enseignant INT NOT NULL,
   PRIMARY KEY(id_responsable),
   UNIQUE(id_enseignant),
   FOREIGN KEY(id_enseignant) REFERENCES Enseignant(id_enseignant)
);

CREATE TABLE Matiere(
   id_matiere INT,
   description_matiere VARCHAR(500),
   coef_matiere INT,
   duree_matiere INT,
   intitule VARCHAR(100),
   PRIMARY KEY(id_matiere)
);

CREATE TABLE Classe(
   id_classe INT,
   nom_classe VARCHAR(50),
   niveau_classe INT,
   id_departement INT NOT NULL,
   PRIMARY KEY(id_classe),
   FOREIGN KEY(id_departement) REFERENCES Departement(id_departement)
);

CREATE TABLE EmploiDuTemps(
   id_emploi_temps INT,
   jour_emploi_temps DATE,
   heure_emploi_temps TIME,
   PRIMARY KEY(id_emploi_temps)
);

CREATE TABLE Etudiant(
   id_etudiant INT,
   nom_etudiant VARCHAR(50),
   prenom_etudiant VARCHAR(50),
   date_naissance_etudiant DATE,
   email_etudiant VARCHAR(100),
   matricule_etudiant INT,
   id_emploi_temps INT NOT NULL,
   id_classe INT NOT NULL,
   PRIMARY KEY(id_etudiant),
   UNIQUE(matricule_etudiant),
   FOREIGN KEY(id_emploi_temps) REFERENCES EmploiDuTemps(id_emploi_temps),
   FOREIGN KEY(id_classe) REFERENCES Classe(id_classe)
);

CREATE TABLE Note(
   id_note INT,
   valeur_note INT,
   commmentaire_note VARCHAR(300),
   id_matiere INT NOT NULL,
   id_etudiant INT NOT NULL,
   PRIMARY KEY(id_note),
   FOREIGN KEY(id_matiere) REFERENCES Matiere(id_matiere),
   FOREIGN KEY(id_etudiant) REFERENCES Etudiant(id_etudiant)
);

CREATE TABLE Enseigner(
   id_enseignant INT,
   id_matiere INT,
   PRIMARY KEY(id_enseignant, id_matiere),
   FOREIGN KEY(id_enseignant) REFERENCES Enseignant(id_enseignant),
   FOREIGN KEY(id_matiere) REFERENCES Matiere(id_matiere)
);

CREATE TABLE peut_enseigner(
   id_enseignant INT,
   id_classe INT,
   PRIMARY KEY(id_enseignant, id_classe),
   FOREIGN KEY(id_enseignant) REFERENCES Enseignant(id_enseignant),
   FOREIGN KEY(id_classe) REFERENCES Classe(id_classe)
);

CREATE TABLE relie_a(
   id_matiere INT,
   id_emploi_temps INT,
   PRIMARY KEY(id_matiere, id_emploi_temps),
   FOREIGN KEY(id_matiere) REFERENCES Matiere(id_matiere),
   FOREIGN KEY(id_emploi_temps) REFERENCES EmploiDuTemps(id_emploi_temps)
);

/*creation des tables*/

CREATE TABLE Etablissement(
   id_etablissement INT,
   nom_etablissement VARCHAR(50),
   PRIMARY KEY(id_etablissement)
);

CREATE TABLE Departement(
   id_departement INT,
   nom_departement VARCHAR(50),
   id_etablissement INT NOT NULL,
   PRIMARY KEY(id_departement),
   FOREIGN KEY(id_etablissement) REFERENCES Etablissement(id_etablissement)
);

CREATE TABLE Enseignant(
   id_enseignant INT,
   matricule_prof INT,
   prenom_prof VARCHAR(50),
   age_prof INT,
   grade_prof VARCHAR(50),
   prof_principal BOOLEAN,
   nom_prof VARCHAR(50),
   id_departement INT NOT NULL,
   PRIMARY KEY(id_enseignant),
   UNIQUE(matricule_prof),
   FOREIGN KEY(id_departement) REFERENCES Departement(id_departement)
);

CREATE TABLE ResponsableDepartement(
   id_responsable INT,
   id_enseignant INT NOT NULL,
   PRIMARY KEY(id_responsable),
   UNIQUE(id_enseignant),
   FOREIGN KEY(id_enseignant) REFERENCES Enseignant(id_enseignant)
);

CREATE TABLE Matiere(
   id_matiere INT,
   description_matiere VARCHAR(500),
   coef_matiere INT,
   duree_matiere INT,
   intitule VARCHAR(100),
   PRIMARY KEY(id_matiere)
);

CREATE TABLE Classe(
   id_classe INT,
   nom_classe VARCHAR(50),
   niveau_classe INT,
   id_departement INT NOT NULL,
   PRIMARY KEY(id_classe),
   FOREIGN KEY(id_departement) REFERENCES Departement(id_departement)
);

CREATE TABLE EmploiDuTemps(
   id_emploi_temps INT,
   jour_emploi_temps DATE,
   heure_emploi_temps TIME,
   PRIMARY KEY(id_emploi_temps)
);

CREATE TABLE Etudiant(
   id_etudiant INT,
   nom_etudiant VARCHAR(50),
   prenom_etudiant VARCHAR(50),
   date_naissance_etudiant DATE,
   email_etudiant VARCHAR(100),
   matricule_etudiant INT,
   id_emploi_temps INT NOT NULL,
   id_classe INT NOT NULL,
   PRIMARY KEY(id_etudiant),
   UNIQUE(matricule_etudiant),
   FOREIGN KEY(id_emploi_temps) REFERENCES EmploiDuTemps(id_emploi_temps),
   FOREIGN KEY(id_classe) REFERENCES Classe(id_classe)
);

CREATE TABLE Note(
   id_note INT,
   valeur_note INT,
   commmentaire_note VARCHAR(300),
   id_matiere INT NOT NULL,
   id_etudiant INT NOT NULL,
   PRIMARY KEY(id_note),
   FOREIGN KEY(id_matiere) REFERENCES Matiere(id_matiere),
   FOREIGN KEY(id_etudiant) REFERENCES Etudiant(id_etudiant)
);

CREATE TABLE Enseigner(
   id_enseignant INT,
   id_matiere INT,
   PRIMARY KEY(id_enseignant, id_matiere),
   FOREIGN KEY(id_enseignant) REFERENCES Enseignant(id_enseignant),
   FOREIGN KEY(id_matiere) REFERENCES Matiere(id_matiere)
);

CREATE TABLE peut_enseigner(
   id_enseignant INT,
   id_classe INT,
   PRIMARY KEY(id_enseignant, id_classe),
   FOREIGN KEY(id_enseignant) REFERENCES Enseignant(id_enseignant),
   FOREIGN KEY(id_classe) REFERENCES Classe(id_classe)
);

CREATE TABLE relie_a(
   id_matiere INT,
   id_emploi_temps INT,
   PRIMARY KEY(id_matiere, id_emploi_temps),
   FOREIGN KEY(id_matiere) REFERENCES Matiere(id_matiere),
   FOREIGN KEY(id_emploi_temps) REFERENCES EmploiDuTemps(id_emploi_temps)
);


/* ajout données */ 

INSERT INTO Etablissement (id_etablissement, nom_etablissement)
VALUES (1, 'Etablissement 1');

INSERT INTO Departement (id_departement, nom_departement, id_etablissement)
VALUES (1, 'Departement Alpha', 1);

INSERT INTO Enseignant (id_enseignant, matricule_prof, prenom_prof, age_prof, grade_prof, prof_principal, nom_prof, id_departement)
VALUES (1, 1001, 'Jakub', 25, 'Professeur', true, 'Landowski', 1);

INSERT INTO ResponsableDepartement (id_responsable, id_enseignant)
VALUES (1, 1);

INSERT INTO Matiere (id_matiere, description_matiere, coef_matiere, duree_matiere, intitule)
VALUES (1, 'Description Matiere A', 4, 60, 'Matiere A');

INSERT INTO Classe (id_classe, nom_classe, niveau_classe, id_departement)
VALUES (1, 'Classe 1A', 6, 1);

INSERT INTO EmploiDuTemps (id_emploi_temps, jour_emploi_temps, heure_emploi_temps)
VALUES (1, '2024-01-20', '09:00:00');

INSERT INTO Etudiant (id_etudiant, nom_etudiant, prenom_etudiant, date_naissance_etudiant, email_etudiant, matricule_etudiant, id_emploi_temps, id_classe)
VALUES (1, 'Jak', 'Lan', '1998-05-15', 'jalan@gmail.com', 20001, 1, 1);

INSERT INTO Note (id_note, valeur_note, commmentaire_note, id_matiere, id_etudiant)
VALUES (1, 18, 'Excellent travail', 1, 1);

INSERT INTO Enseigner (id_enseignant, id_matiere)
VALUES (1, 1);

INSERT INTO peut_enseigner (id_enseignant, id_classe)
VALUES (1, 1);

INSERT INTO relie_a (id_matiere, id_emploi_temps)
VALUES (1, 1);
