const axios = require('axios');

const API_BASE_URL = 'http://localhost:8080/api';

async function getEquipe(id) {
    const response = await axios.get(`${API_BASE_URL}/equipes/${id}`);
    console.log(response.data);
}

async function createEquipe(nom) {
    const response = await axios.post(`${API_BASE_URL}/equipes`, { nom });
    console.log(response.data);
}

async function deleteEquipe(id) {
    const response = await axios.delete(`${API_BASE_URL}/equipes/${id}`);
    console.log('Equipe supprimée');
}

function getAllJoueurs() {
    axios.get('http://localhost:8080/api/joueurs')
    .then(response => {
        console.log(response.data);
    })
    .catch(error => {
        console.error('Il y a eu une erreur lors de la récupération des joueurs: ', error);
    });
}

async function getJoueurs(idEquipe) {
    const response = await axios.get(`${API_BASE_URL}/equipes/${idEquipe}/joueurs`);
    console.log(response.data);
}

async function addJoueurToEquipe(idEquipe, nom, poste) {
    const response = await axios.post(`${API_BASE_URL}/equipes/${idEquipe}/joueurs`, { nom, poste });
    console.log(response.data);
}

async function deleteJoueurFromEquipe(idEquipe, idJoueur) {
    const response = await axios.delete(`${API_BASE_URL}/equipes/${idEquipe}/joueurs/${idJoueur}`);
    console.log('Joueur supprimé de l\'équipe');
}

// Utilisation des fonctions@

// Afficher une équipe
//getEquipe(1);

// Créer une équipe
//createEquipe('FC Barcelona');

// Supprimer une équipe
//deleteEquipe(5);

//Avoir la liste de tous les joueurs
getAllJoueurs();

// Afficher la liste des joueurs d'une équipe
//getJoueurs(1);

// Ajouter un joueur à une équipe
//addJoueurToEquipe(1, 'Nouveau joueur', 'Attaquant');

// Supprimer un joueur d'une équipe
//deleteJoueurFromEquipe(1, 3);
