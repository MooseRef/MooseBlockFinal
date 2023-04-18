package net.moose.mooseblock.world.gen;

public class ModWorldGeneration {
    public static void  generateModWorldGen(){
        ModEntityGeneration.addSpawns();
        ModFlowerGeneration.generateFlowers();
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
        ModVegetationGeneration.generateVegetation();
    }
}

