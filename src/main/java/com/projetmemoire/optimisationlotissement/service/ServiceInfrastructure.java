package com.projetmemoire.optimisationlotissement.service;

import java.util.List;

import com.projetmemoire.optimisationlotissement.model.Infrastructure;


public interface ServiceInfrastructure {
    Infrastructure Enregistrerinf(Infrastructure Inf);
    List<Infrastructure> TotalInf();
    Infrastructure InfParId(Long id);
    Infrastructure updateInf(Infrastructure Inf, Long id);
    void deleteInfrastructure(Long id);
}
