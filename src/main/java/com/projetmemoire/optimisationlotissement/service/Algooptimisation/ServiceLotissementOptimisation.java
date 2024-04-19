package com.projetmemoire.optimisationlotissement.service.Algooptimisation;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.genetics.*;
import org.springframework.stereotype.Service;

@Service
public class ServiceLotissementOptimisation {
    private static final int Taille_Chromosome=10;
    private static final int Taille_Population=50;
    private static final int Num_Generations=100;
    private static final double Mutation_Rate=0.1;
    private static final double Elitism_Rate=0.1;
    public void optimiserlotissement(){
        CrossoverPolicy crossoverPolicy = new LotissementCrossoverPolicy();
        MutationPolicy mutationPolicy = new LotissementMutationPolicy();
        SelectionPolicy selectionPolicy = new TournamentSelection(2);
        Population initial=new ElitisticListPopulation(Taille_Population, Elitism_Rate);
        for(int i=0;i<Taille_Population;i++){
            Chromosome chromosome=generateRandomChromosome();
            initial.addChromosome(chromosome);
        }

        GeneticAlgorithm ga=new GeneticAlgorithm(crossoverPolicy,1.0, mutationPolicy, Mutation_Rate, selectionPolicy);

         StoppingCondition stopCondition = new FixedGenerationCount(Num_Generations);
          Population finalPopulation=ga.evolve(initial, stopCondition);
            

          Chromosome bestChromosome=finalPopulation.getFittestChromosome();
          System.out.println("Meilleure Solution:"+bestChromosome);

    }
    private Chromosome generateRandomChromosome(){
        List<Integer> representation=new ArrayList<>(Taille_Chromosome);
        for(int i=0;i<Taille_Chromosome;i++){
            representation.add(Math.random()>0.5?1:0);
        }
        return new CustomBinaryChromosome(representation);
    }

}
