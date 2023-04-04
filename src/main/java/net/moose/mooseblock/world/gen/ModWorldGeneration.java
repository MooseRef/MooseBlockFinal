package net.moose.mooseblock.world.gen;

public class ModWorldGeneration {
    public static void  generateModWorldGen(){
        ModEntityGeneration.addSpawns();
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
    }
}

