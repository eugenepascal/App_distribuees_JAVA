-- création de la séquence HIBERNATE

CREATE SEQUENCE IF NOT EXISTS HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;

--création des tables

CREATE TABLE IF NOT EXISTS equipe (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS joueur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    poste VARCHAR(255) NOT NULL,
    equipe_id INT,
    FOREIGN KEY (equipe_id) REFERENCES equipe(id)
);


-- Insérer des équipes
-- Équipe 1
INSERT INTO equipe (id, nom) VALUES (1, 'Équipe 1');
-- Équipe 2
INSERT INTO equipe (id, nom) VALUES (2, 'Équipe 2');
-- Équipe 3
INSERT INTO equipe (id, nom) VALUES (3, 'Équipe 3');
-- Équipe 4
INSERT INTO equipe (id, nom) VALUES (4, 'Équipe 4');

-- Insérer des joueurs pour chaque équipe
-- Joueur Équipe 1
INSERT INTO joueur (id, nom, poste, equipe_id) VALUES (1, 'Joueur 1', 'Attaquant', 1);
INSERT INTO joueur (id, nom, poste, equipe_id) VALUES (2, 'Joueur 2', 'Milieu', 1);
INSERT INTO joueur (id, nom, poste, equipe_id) VALUES (3, 'Joueur 3', 'Défenseur', 1);

-- Joueur Équipe 2
INSERT INTO joueur (id, nom, poste, equipe_id) VALUES (4, 'Joueur 4', 'Attaquant', 2);
INSERT INTO joueur (id, nom, poste, equipe_id) VALUES (5, 'Joueur 5', 'Milieu', 2);
INSERT INTO joueur (id, nom, poste, equipe_id) VALUES (6, 'Joueur 6', 'Défenseur', 2);

-- Joueur Équipe 3
INSERT INTO joueur (id, nom, poste, equipe_id) VALUES (7, 'Joueur 7', 'Attaquant', 3);
INSERT INTO joueur (id, nom, poste, equipe_id) VALUES (8, 'Joueur 8', 'Milieu', 3);
INSERT INTO joueur (id, nom, poste, equipe_id) VALUES (9, 'Joueur 9', 'Défenseur', 3);

-- Joueur Équipe 4
INSERT INTO joueur (id, nom, poste, equipe_id) VALUES (10, 'Joueur 10', 'Attaquant', 4);
INSERT INTO joueur (id, nom, poste, equipe_id) VALUES (11, 'Joueur 11', 'Milieu', 4);
INSERT INTO joueur (id, nom, poste, equipe_id) VALUES (12, 'Joueur 12', 'Défenseur', 4);
