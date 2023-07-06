const { request, gql } = require('graphql-request')

const endpoint = 'http://localhost:8080/graphql' // l'URL de l'API GraphQL

// Requête pour obtenir tous les joueurs
const getPlayersQuery = gql`
  {
    allPlayers {
      id
      name
      position
    }
  }
`

request(endpoint, getPlayersQuery)
  .then((data) => console.log(data))
  .catch((error) => console.log(error))

// Requête pour obtenir toutes les équipes
const getTeamsQuery = gql`
  {
    allTeams {
      id
      name
    }
  }
`

request(endpoint, getTeamsQuery)
  .then((data) => console.log(data))
  .catch((error) => console.log(error))

