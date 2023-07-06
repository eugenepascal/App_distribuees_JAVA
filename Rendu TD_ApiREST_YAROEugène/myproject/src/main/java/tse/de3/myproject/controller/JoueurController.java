package tse.de3.myproject.controller;

import tse.de3.myproject.model.Joueur;
import tse.de3.myproject.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/joueurs")
public class JoueurController {
    @Autowired
    private JoueurRepository joueurRepository;

    // GET - Récupérer la liste des joueurs
    @GetMapping
    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

    // GET - Récupérer un joueur par ID
    @GetMapping("/{id}")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable Long id) {
        Optional<Joueur> joueur = joueurRepository.findById(id);
        if (joueur.isPresent()) {
            return ResponseEntity.ok(joueur.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST - Créer un nouveau joueur
    @PostMapping
    public ResponseEntity<Joueur> createJoueur(@RequestBody Joueur joueur) {
        Joueur savedJoueur = joueurRepository.save(joueur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedJoueur);
    }

    // PUT - Mettre à jour un joueur existant
    @PutMapping("/{id}")
    public ResponseEntity<Joueur> updateJoueur(@PathVariable Long id, @RequestBody Joueur joueurDetails) {
        Optional<Joueur> joueur = joueurRepository.findById(id);

        if (joueur.isPresent()) {
            Joueur updatedJoueur = joueur.get();
            updatedJoueur.setNom(joueurDetails.getNom());
            updatedJoueur.setPoste(joueurDetails.getPoste());
            updatedJoueur.setEquipe(joueurDetails.getEquipe());
            joueurRepository.save(updatedJoueur);
            return ResponseEntity.ok(updatedJoueur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Supprimer un joueur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoueur(@PathVariable Long id) {
        Optional<Joueur> joueur = joueurRepository.findById(id);
        if (joueur.isPresent()) {
            joueurRepository.delete(joueur.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
 // DELETE - Supprimer un joueur d'une équipe spécifique
    @DeleteMapping("/api/equipes/{equipeId}/joueurs/{joueurId}")
    public ResponseEntity<Void> deleteJoueurFromEquipe(@PathVariable Long equipeId, @PathVariable Long joueurId) {
        Optional<Joueur> joueur = joueurRepository.findById(joueurId);
        if (joueur.isPresent() && joueur.get().getEquipe().getId().equals(equipeId)) {
            joueur.get().setEquipe(null);
            joueurRepository.save(joueur.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
