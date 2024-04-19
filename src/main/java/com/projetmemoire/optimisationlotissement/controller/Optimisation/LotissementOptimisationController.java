package com.projetmemoire.optimisationlotissement.controller.Optimisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetmemoire.optimisationlotissement.service.Algooptimisation.ServiceLotissementOptimisation;

@RestController
@RequestMapping("/api/optimisation/lotissement")
public class LotissementOptimisationController {
    @Autowired
    private ServiceLotissementOptimisation serviceLotissementOptimisation;

    @GetMapping("/lancer")
    public ResponseEntity<String> lancerOptimisation() {
        new Thread(serviceLotissementOptimisation::optimiserlotissement).start();
        return ResponseEntity.ok("L'optimisation du lotissement a été lancée et est en cours d'exécution.");
    }
    


}
