package com.projetmemoire.optimisationlotissement.serrvice.Imp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.projetmemoire.optimisationlotissement.model.Parcelle;
import com.projetmemoire.optimisationlotissement.repository.ParcelleRepository;
import com.projetmemoire.optimisationlotissement.service.imp.ServiceParcelleImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ServiceParcelleImpTest {
    
    @Mock
    private ParcelleRepository parcelleRepository;

    @InjectMocks
    private ServiceParcelleImp serviceParcelleImp;

    @BeforeEach
    void setMockOutput() {
        MockitoAnnotations.openMocks(this);
        Parcelle parcelle = new Parcelle();
        parcelle.setId_parcelle(1L);
        parcelle.setSup_parcelle(100.0);
        parcelle.setStatut("Disponible");

        when(parcelleRepository.findAll()).thenReturn(Arrays.asList(parcelle));
        when(parcelleRepository.findById(1L)).thenReturn(Optional.of(parcelle));
        when(parcelleRepository.save(any(Parcelle.class))).thenReturn(parcelle);
    }

    @Test
    void testEnregistrerParcelle() {
        Parcelle newParcelle = new Parcelle();
        newParcelle.setSup_parcelle(200.0);
        newParcelle.setStatut("Occupé");

        Parcelle savedParcelle = serviceParcelleImp.EnregistrerParcelle(newParcelle);
       
        assertEquals("Disponible", savedParcelle.getStatut(),"Le statut doit être 'Occupé' comme défini initialement.");
    }

    @Test
    void testTotalParcelle() {
        List<Parcelle> parcelles = serviceParcelleImp.TotalParcelle();
        assertNotNull(parcelles);
        assertEquals(1, parcelles.size());
    }

    @Test
    void testParcelleParId() {
        Parcelle parcelle = serviceParcelleImp.ParcelleParId(1L);
        assertNotNull(parcelle);
        assertEquals(100.0, parcelle.getSup_parcelle());
    }

    @Test
    void testUpdateParcelle() {
        Parcelle updatedParcelle = new Parcelle();
        updatedParcelle.setSup_parcelle(300.0);
        updatedParcelle.setStatut("En attente");

        Parcelle result = serviceParcelleImp.updateParcelle(updatedParcelle, 1L);
        assertNotNull(result);
        assertEquals(300.0, result.getSup_parcelle());
        assertEquals("En attente", result.getStatut());
    }

}
