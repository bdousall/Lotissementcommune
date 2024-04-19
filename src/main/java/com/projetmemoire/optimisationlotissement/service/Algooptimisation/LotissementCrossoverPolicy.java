package com.projetmemoire.optimisationlotissement.service.Algooptimisation;


import org.apache.commons.math3.genetics.Chromosome;
import org.apache.commons.math3.genetics.ChromosomePair;
import org.apache.commons.math3.genetics.CrossoverPolicy;

public class LotissementCrossoverPolicy implements CrossoverPolicy {
    @Override
    public ChromosomePair crossover(Chromosome first, Chromosome second) {
        if (!(first instanceof CustomBinaryChromosome && second instanceof CustomBinaryChromosome)) {
            throw new IllegalArgumentException("Les chromosomes doivent être des instances de CustomBinaryChromosome");
        }

        CustomBinaryChromosome parent1 = (CustomBinaryChromosome) first;
        CustomBinaryChromosome parent2 = (CustomBinaryChromosome) second;

        return CustomBinaryChromosome.crossover(parent1, parent2);
    }
}



