package com.projetmemoire.optimisationlotissement.service;

import java.util.List;

import org.locationtech.jts.geom.Point;

import com.projetmemoire.optimisationlotissement.model.Infrastructure;


public interface ServiceInfrastructure {
    Infrastructure Enregistrerinf(Infrastructure Inf);
    List<Infrastructure> TotalInf();
    Infrastructure InfParId(Long id);
    Infrastructure updateInf(Infrastructure Inf, Long id);
    void deleteInfrastructure(Long id);
    public List<Infrastructure> findInfrastructuresWithinDistance(Point point, double distance);
    public List<Infrastructure> findInfrastructuresByPolygon(String polygon);
}
