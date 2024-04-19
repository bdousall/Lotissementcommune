package com.projetmemoire.optimisationlotissement.Controller;

import com.projetmemoire.optimisationlotissement.model.Infrastructure;
import com.projetmemoire.optimisationlotissement.service.Algooptimisation.ServiceInfrastructurePlacement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ExtendWith(SpringExtension.class)
@SpringBootTest  // Use this to load the full application context
@AutoConfigureMockMvc
public class InfrastructurePlacementControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private final String wktPoint = "POINT (1 1)";

    @Autowired
    private GeometryFactory geometryFactory;  // Ensure GeometryFactory is injected

    @BeforeEach
    public void setUp() {
        // Setup initial data or mock services if necessary
    }

    @Test
    public void testCalculerEmplacementOptimal() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/optimisation/infrastructures/placement-optimal")
                .param("type", "École")
                .param("wktZone", wktPoint)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.type").value("École"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.parcelle").exists());
    }
}

