-- Création de la table team
CREATE TABLE IF NOT EXISTS team (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

-- Création de la table player
CREATE TABLE IF NOT EXISTS player (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    position VARCHAR(255) NOT NULL,
    team_id INT,
    FOREIGN KEY (team_id) REFERENCES team(id)
);

-- Insertion des équipes
INSERT INTO team (id, name) VALUES (1, 'Team 1');
INSERT INTO team (id, name) VALUES (2, 'Team 2');
INSERT INTO team (id, name) VALUES (3, 'Team 3');
INSERT INTO team (id, name) VALUES (4, 'Team 4');
INSERT INTO team (id, name) VALUES (5, 'Team 5');

-- Insertion des joueurs
INSERT INTO player (id, name, position, team_id) VALUES (1, 'Player 1', 'Forward', 1);
INSERT INTO player (id, name, position, team_id) VALUES (2, 'Player 2', 'Defender', 1);
INSERT INTO player (id, name, position, team_id) VALUES (3, 'Player 3', 'Midfielder', 2);
INSERT INTO player (id, name, position, team_id) VALUES (4, 'Player 4', 'Goalkeeper', 2);
INSERT INTO player (id, name, position, team_id) VALUES (5, 'Player 5', 'Forward', 2);
INSERT INTO player (id, name, position, team_id) VALUES (6, 'Player 6', 'Defender', 3);
INSERT INTO player (id, name, position, team_id) VALUES (7, 'Player 7', 'Midfielder', 3);
INSERT INTO player (id, name, position, team_id) VALUES (8, 'Player 8', 'Goalkeeper', 4);
INSERT INTO player (id, name, position, team_id) VALUES (9, 'Player 9', 'Forward', 4);
INSERT INTO player (id, name, position, team_id) VALUES (10, 'Player 10', 'Midfielder', 5);
