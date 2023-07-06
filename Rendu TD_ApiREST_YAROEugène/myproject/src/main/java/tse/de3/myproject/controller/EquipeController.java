package tse.de3.myproject.controller;

import tse.de3.myproject.model.Equipe;
import tse.de3.myproject.model.Joueur;
import tse.de3.myproject.repository.EquipeRepository;
import tse.de3.myproject.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController {
    @Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    private JoueurRepository joueurRepository;

    // GET - Récupérer la liste des équipes
    @GetMapping
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    // GET - Récupérer une équipe par ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable Long id) {
        Optional<Equipe> equipe = equipeRepository.findById(id);
        if (equipe.isPresent()) {
            return ResponseEntity.ok(equipe.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST - Créer une nouvelle équipe
    @PostMapping
    public ResponseEntity<Equipe> createEquipe(@RequestBody Equipe equipe) {
        Equipe savedEquipe = equipeRepository.save(equipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEquipe);
    }

    // PUT - Mettre à jour une équipe existante
    @PutMapping("/{id}")
    public ResponseEntity<Equipe> updateEquipe(@PathVariable Long id, @RequestBody Equipe equipeDetails) {
        Optional<Equipe> equipe = equipeRepository.findById(id);

        if (equipe.isPresent()) {
            Equipe updatedEquipe = equipe.get();
            updatedEquipe.setNom(equipeDetails.getNom());
            updatedEquipe.setJoueurs(equipeDetails.getJoueurs());
            equipeRepository.save(updatedEquipe);
            return ResponseEntity.ok(updatedEquipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // POST - Ajouter un joueur à une équipe
    @PostMapping("/{id}/joueurs")
    public ResponseEntity<Joueur> addJoueurToEquipe(@PathVariable Long id, @RequestBody Joueur joueur) {
        Optional<Equipe> equipeOptional = equipeRepository.findById(id);

        if (!equipeOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Equipe equipe = equipeOptional.get();
        joueur.setEquipe(equipe);

        Joueur savedJoueur = joueurRepository.save(joueur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedJoueur);
    }
    
    //GET - voir la liste des joueurs à partir de l'ID de l'équipe
    @GetMapping("/{id}/joueurs")
    public ResponseEntity<List<Joueur>> getJoueursByEquipeId(@PathVariable Long id) {
        Optional<Equipe> equipe = equipeRepository.findById(id);
        if (equipe.isPresent()) {
            return ResponseEntity.ok(equipe.get().getJoueurs());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // DELETE - Supprimer une équipe
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable Long id) {
        Optional<Equipe> equipe = equipeRepository.findById(id);
        if (equipe.isPresent()) {
            equipeRepository.delete(equipe.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}