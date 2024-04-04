package com.projetmemoire.optimisationlotissement.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetmemoire.optimisationlotissement.model.Infrastructure;
import com.projetmemoire.optimisationlotissement.repository.InfrastructureRepository;
import com.projetmemoire.optimisationlotissement.service.ServiceInfrastructure;
@Service
public class ServiceInfrastructureImp implements ServiceInfrastructure{
     @Autowired
    private InfrastructureRepository infRepository;

    @Override
    public Infrastructure Enregistrerinf(Infrastructure Inf){
        return infRepository.save(Inf);
    }

    @Override
    public List<Infrastructure> TotalInf(){
        return infRepository.findAll();
    }

    @Override
    public Infrastructure InfParId(Long id){
        return infRepository.findById(id).orElseThrow(() ->
        new RuntimeException("Cette infrastructure n'existe pas"));
    }

    @Override
    public Infrastructure updateInf(Infrastructure Inf, Long id){
        Infrastructure infExistant=InfParId(id);
        infExistant.setSup_infrastructure(Inf.getSup_infrastructure());
        infExistant.setType(Inf.getType());
        return infRepository.save(infExistant);
    }

    @Override
    public void deleteInfrastructure(Long id){
        infRepository.deleteById(id);
    }

}
