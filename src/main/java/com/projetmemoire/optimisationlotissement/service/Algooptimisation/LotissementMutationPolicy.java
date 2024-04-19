package com.projetmemoire.optimisationlotissement.service.Algooptimisation;

import org.apache.commons.math3.genetics.Chromosome;
import org.apache.commons.math3.genetics.MutationPolicy;

public class LotissementMutationPolicy implements MutationPolicy{

    @Override
    public Chromosome mutate(Chromosome original){
        if(!(original instanceof CustomBinaryChromosome)){
            throw new IllegalArgumentException("Une instance de CustomBinaryChromosome est demandée");
        }
        CustomBinaryChromosome originalChromosome=(CustomBinaryChromosome) original;

        
        return originalChromosome;
    }
}
