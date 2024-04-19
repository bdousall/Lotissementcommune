package com.projetmemoire.optimisationlotissement.service.Algooptimisation;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.math3.genetics.AbstractListChromosome;
import org.apache.commons.math3.genetics.BinaryChromosome;

import org.apache.commons.math3.genetics.ChromosomePair;
import org.apache.commons.math3.genetics.InvalidRepresentationException;

public class CustomBinaryChromosome extends BinaryChromosome{
    
    public CustomBinaryChromosome(List<Integer> representation) throws InvalidRepresentationException {
        super(representation);
        checkValidity(representation); 
    }

    @Override
    public AbstractListChromosome<Integer> newFixedLengthChromosome(List<Integer> chromosomeRepresentation) {
        try {
            return new CustomBinaryChromosome(chromosomeRepresentation);
        } catch (InvalidRepresentationException e) {
            throw new IllegalArgumentException("Failed to create a chromosome with invalid data", e);
        }
    }

    public static ChromosomePair crossover(CustomBinaryChromosome parent1, CustomBinaryChromosome parent2) {
        int length = parent1.getLength();
        int crossoverIndex = 1 + (int) (Math.random() * (length - 2));

        List<Integer> representationParent1 = parent1.getRepresentation();
        List<Integer> representationParent2 = parent2.getRepresentation();

        List<Integer> newRep1 = IntStream.range(0, length)
            .map(i -> i < crossoverIndex ? representationParent1.get(i) : representationParent2.get(i))
            .boxed()  
            .collect(Collectors.toList());
        List<Integer> newRep2 = IntStream.range(0, length)
            .map(i -> i < crossoverIndex ? representationParent2.get(i) : representationParent1.get(i))
            .boxed()  
            .collect(Collectors.toList());

        try {
            return new ChromosomePair(new CustomBinaryChromosome(newRep1), new CustomBinaryChromosome(newRep2));
        } catch (InvalidRepresentationException e) {
            throw new IllegalStateException("Invalid chromosome representation formed during crossover", e);
        }
    }

    @Override
    protected void checkValidity(List<Integer> chromosomeRepresentation) throws InvalidRepresentationException {
        for (Integer gene : chromosomeRepresentation) {
            if (gene < 0 || gene > 1) {
                throw new IllegalArgumentException("Veuillez entrez 0 ou 1");
            }
        }
    }

    @Override
    public double fitness() {
        double score = 0;
        List<Integer> representation = getRepresentation();
        for (Integer gene : representation) {
            if (gene == 1) {
                score += 1; 
            }
        }

       
        score -= calculatePenalty(representation);

        return score;
    }

    private double calculatePenalty(List<Integer> representation) {
        // Example penalty calculation (e.g., too many '1's in a row)
        double penalty = 0;
        int consecutiveOnes = 0;
        for (int i = 0; i < representation.size(); i++) {
            if (representation.get(i) == 1) {
                consecutiveOnes++;
                if (consecutiveOnes > 3) { // Penalize for more than 3 consecutive '1's
                    penalty += 1.0;
                }
            } else {
                consecutiveOnes = 0; // reset count on '0'
            }
        }
        return penalty;
    }
}
