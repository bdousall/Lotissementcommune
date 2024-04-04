package com.projetmemoire.optimisationlotissement.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetmemoire.optimisationlotissement.model.Parcelle;
import com.projetmemoire.optimisationlotissement.repository.ParcelleRepository;
import com.projetmemoire.optimisationlotissement.service.ServiceParcelle;

@Service
public class ServiceParcelleImp implements ServiceParcelle{
    @Autowired
    private ParcelleRepository parcelleRepository;

    @Override
    public Parcelle EnregistrerParcelle(Parcelle parcelle){
        return parcelleRepository.save(parcelle);
    }

    @Override
    public List<Parcelle> TotalParcelle(){
        return parcelleRepository.findAll();
    }

    @Override
    public Parcelle ParcelleParId(Long id){
        return parcelleRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Cette parcelle n'existe pas"));
    }

    @Override
    public Parcelle updateParcelle(Parcelle parcelle, Long id){
        Parcelle parcelleExistant=ParcelleParId(id);
        parcelleExistant.setSup_parcelle(parcelle.getSup_parcelle());
        parcelleExistant.setStatut(parcelle.getStatut());
        return parcelleRepository.save(parcelleExistant);
    }

    @Override
    public void deleteParcelle(Long id){
        parcelleRepository.deleteById(id);
    }

}
