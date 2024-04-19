package com.projetmemoire.optimisationlotissement.service;

import java.util.List;

import org.locationtech.jts.geom.Geometry;

import com.projetmemoire.optimisationlotissement.model.Parcelle;

public interface ServiceParcelle {
    Parcelle EnregistrerParcelle(Parcelle parcelle);
    List<Parcelle> TotalParcelle();
    Parcelle ParcelleParId(Long Id);
    Parcelle updateParcelle(Parcelle parcelle, Long id);
    void deleteParcelle(Long id);
    public List<Parcelle> findParcellesWithin(Geometry polygon);
    public List<Parcelle> findParcellesNearPoint(Geometry point, double distance);
}
