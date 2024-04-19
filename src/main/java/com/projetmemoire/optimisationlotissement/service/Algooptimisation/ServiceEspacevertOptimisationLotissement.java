package com.projetmemoire.optimisationlotissement.service.Algooptimisation;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.buffer.BufferOp;
import org.locationtech.jts.operation.buffer.BufferParameters;
import org.springframework.stereotype.Service;

@Service
public class ServiceEspacevertOptimisationLotissement {
    public Geometry optimiserEspacesVerts(Geometry espaceVertActuel) {
        double distanceExpansion = 10.0;  // Cette valeur peut être dynamique selon les cas
        BufferParameters params = new BufferParameters();
        params.setEndCapStyle(BufferParameters.CAP_ROUND);
        Geometry espaceVertOptimise = BufferOp.bufferOp(espaceVertActuel, distanceExpansion, params);

        return espaceVertOptimise;
    }
    

}
