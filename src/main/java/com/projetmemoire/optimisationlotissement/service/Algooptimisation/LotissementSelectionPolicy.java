package com.projetmemoire.optimisationlotissement.service.Algooptimisation;

import org.apache.commons.math3.genetics.Chromosome;
import org.apache.commons.math3.genetics.ChromosomePair;
import org.apache.commons.math3.genetics.Population;
import org.apache.commons.math3.genetics.SelectionPolicy;

public class LotissementSelectionPolicy implements SelectionPolicy {
    @Override
    public ChromosomePair select(Population population) {
        Chromosome firstSelected = population.getFittestChromosome();
        Chromosome secondSelected = population.getFittestChromosome();  

        return new ChromosomePair(firstSelected, secondSelected);
    }

}
