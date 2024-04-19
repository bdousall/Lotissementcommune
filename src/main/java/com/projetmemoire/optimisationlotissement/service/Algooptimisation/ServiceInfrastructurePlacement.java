package com.projetmemoire.optimisationlotissement.service.Algooptimisation;


import com.projetmemoire.optimisationlotissement.model.Infrastructure;
import com.projetmemoire.optimisationlotissement.model.Parcelle;
import com.projetmemoire.optimisationlotissement.service.ServiceParcelle;


import org.locationtech.jts.algorithm.ConvexHull;
import org.locationtech.jts.geom.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceInfrastructurePlacement {
   
    @Autowired
    private GeometryFactory geometryFactory;
    @Autowired
    private ServiceParcelle parcelleService;

    public List<Infrastructure> optimiserPlacementInfrastructures(List<Infrastructure> infrastructures, List<Point> pointsDInteret) {
        ConvexHull convexHull = new ConvexHull(pointsDInteret.stream().map(Point::getCoordinate).toArray(Coordinate[]::new), geometryFactory);
        Geometry hullGeometry = convexHull.getConvexHull();

        Point centre = hullGeometry.getCentroid();
        return infrastructures.stream().peek(infra -> infra.setGeom(centre)).collect(Collectors.toList());
    }

    public Infrastructure calculerEmplacementOptimal(Geometry zoneDeRecherche, String typeInfrastructure) {
        List<Parcelle> parcellesDisponibles = parcelleService.findParcellesWithin(zoneDeRecherche);
        Infrastructure meilleurChoix = null;
        double meilleurScore = Double.MAX_VALUE;

        for (Parcelle parcelle : parcellesDisponibles) {
            double score = evaluerParcellePourInfrastructure(parcelle, typeInfrastructure);
            if (score < meilleurScore) {
                meilleurScore = score;
                meilleurChoix = new Infrastructure();
                meilleurChoix.setParcelle(parcelle);
                meilleurChoix.setType(typeInfrastructure);
            }
        }
        return meilleurChoix;
    }

    private double evaluerParcellePourInfrastructure(Parcelle parcelle, String typeInfrastructure) {
        double score = 0.0; 
        return score;
    }

}
