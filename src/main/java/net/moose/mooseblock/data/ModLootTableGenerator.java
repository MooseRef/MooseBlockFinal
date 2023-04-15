package net.moose.mooseblock.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.predicate.StatePredicate;
import net.moose.mooseblock.block.ModBlocks;
import net.moose.mooseblock.block.custom.TomatoCropBlock;
import net.moose.mooseblock.item.ModItems;
import software.bernie.shadowed.eliotlash.mclib.math.functions.classic.Mod;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate()
    {
        addDrop(ModBlocks.MOOD_LOG);
        addDrop(ModBlocks.MOOD_WOOD);
        addDrop(ModBlocks.STRIPPED_MOOD_LOG);
        addDrop(ModBlocks.STRIPPED_MOOD_WOOD);
        addDrop(ModBlocks.MOOD_PLANKS);
        addDrop(ModBlocks.MOOD_STAIRS);
        addDrop(ModBlocks.MOOD_SLAB);
        addDrop(ModBlocks.MOOD_FENCE);
        addDrop(ModBlocks.MOOD_FENCE_GATE);
        addDrop(ModBlocks.MOOD_BUTTON);
        addDrop(ModBlocks.MOOD_PRESSURE_PLATE);
        addDrop(ModBlocks.MOOD_DOOR,
                doorDrops(ModBlocks.MOOD_DOOR));
        addDrop(ModBlocks.MOOD_TRAPDOOR);
        addDrop(ModBlocks.MOOD_REDSTONE_LAMP);

        addDrop(ModBlocks.MOOD_LEAVES,
                leavesDrops(ModBlocks.MOOD_LEAVES,
                        ModBlocks.MOOD_SAPLING,
                        SAPLING_DROP_CHANCE));

        addDrop(ModBlocks.MOOD_SAPLING);
        addDrop(ModBlocks.POTTED_MOOD_SAPLING,
                pottedPlantDrops(ModBlocks.MOOD_SAPLING));

        addDrop(ModBlocks.MOOD_SAPLING);
        addDrop(ModBlocks.POTTED_MOOD_SAPLING,
                pottedPlantDrops(ModBlocks.MOOD_SAPLING));

        addDrop(ModBlocks.SATIN_LOG);
        addDrop(ModBlocks.SATIN_WOOD);
        addDrop(ModBlocks.STRIPPED_SATIN_LOG);
        addDrop(ModBlocks.STRIPPED_SATIN_WOOD);
        addDrop(ModBlocks.SATIN_PLANKS);
        addDrop(ModBlocks.SATIN_STAIRS);
        addDrop(ModBlocks.SATIN_SLAB);
        addDrop(ModBlocks.SATIN_FENCE);
        addDrop(ModBlocks.SATIN_FENCE_GATE);
        addDrop(ModBlocks.SATIN_BUTTON);
        addDrop(ModBlocks.SATIN_PRESSURE_PLATE);
        addDrop(ModBlocks.SATIN_DOOR,
                doorDrops(ModBlocks.SATIN_DOOR));
        addDrop(ModBlocks.SATIN_TRAPDOOR);

        addDrop(ModBlocks.SATIN_LEAVES,
                leavesDrops(ModBlocks.SATIN_LEAVES,
                        ModBlocks.SATIN_SAPLING,
                        SAPLING_DROP_CHANCE));

        addDrop(ModBlocks.SATIN_SAPLING);
        addDrop(ModBlocks.POTTED_SATIN_SAPLING,
                pottedPlantDrops(ModBlocks.SATIN_SAPLING));

        addDrop(ModBlocks.GOXITE_ORE,
                oreDrops(ModBlocks.GOXITE_ORE,
                        ModItems.RAW_GOXITE));
        addDrop(ModBlocks.DEEPSLATE_GOXITE_ORE,
                oreDrops(ModBlocks.DEEPSLATE_GOXITE_ORE,
                        ModItems.RAW_GOXITE));
        addDrop(ModBlocks.BLOCK_OF_GOXITE);
        addDrop(ModBlocks.BLOCK_OF_RAW_GOXITE);

        addDrop(ModBlocks.BORPITE_ORE,
                oreDrops(ModBlocks.BORPITE_ORE,
                        ModItems.RAW_BORPITE));
        addDrop(ModBlocks.DEEPSLATE_BORPITE_ORE,
                oreDrops(ModBlocks.DEEPSLATE_BORPITE_ORE,
                        ModItems.RAW_BORPITE));
        addDrop(ModBlocks.BLOCK_OF_BORPITE);
        addDrop(ModBlocks.BLOCK_OF_RAW_BORPITE);

        addDrop(ModBlocks.MOOSITE_ORE,
                oreDrops(ModBlocks.MOOSITE_ORE,
                        ModItems.MOOSITE));
        addDrop(ModBlocks.DEEPSLATE_MOOSITE_ORE,
                oreDrops(ModBlocks.DEEPSLATE_MOOSITE_ORE,
                        ModItems.MOOSITE));
        addDrop(ModBlocks.BLOCK_OF_MOOSITE);

        addDrop(ModBlocks.GNEISS);
        addDrop(ModBlocks.GNEISS_STAIRS);
        addDrop(ModBlocks.GNEISS_SLAB);
        addDrop(ModBlocks.GNEISS_WALL);

        addDrop(ModBlocks.POLISHED_GNEISS);
        addDrop(ModBlocks.POLISHED_GNEISS_STAIRS);
        addDrop(ModBlocks.POLISHED_GNEISS_SLAB);
        addDrop(ModBlocks.POLISHED_GNEISS_WALL);

        addDrop(ModBlocks.ONYX_BLOCK);
        // add cluster later?
        addDrop(ModBlocks.LARGE_ONYX_BUD,
                dropsWithSilkTouch(ModBlocks.LARGE_ONYX_BUD));
        addDrop(ModBlocks.MEDIUM_ONYX_BUD,
                dropsWithSilkTouch(ModBlocks.MEDIUM_ONYX_BUD));
        addDrop(ModBlocks.SMALL_ONYX_BUD,
                dropsWithSilkTouch(ModBlocks.SMALL_ONYX_BUD));

        BlockStatePropertyLootCondition.Builder builder
                = BlockStatePropertyLootCondition
                .builder(ModBlocks.TOMATO_CROP)
                .properties(StatePredicate
                        .Builder.create()
                        .exactMatch(TomatoCropBlock.AGE, 6));
        addDrop(ModBlocks.TOMATO_CROP,
                this.applyExplosionDecay
                        (ModBlocks.TOMATO_CROP,
                                LootTable.builder()
                        .pool(LootPool.builder()
                                .with(ItemEntry.builder
                                        (ModItems.TOMATO_SEEDS)))
                        .pool(LootPool.builder()
                                .conditionally(builder)
                                .with(ItemEntry.builder
                                (ModItems.TOMATO)
                                        .apply(ApplyBonusLootFunction.binomialWithBonusCount
                                                (Enchantments.FORTUNE, 0.5714286f, 3))))
                        .pool(LootPool.builder()
                                .conditionally(builder)
                                .with(ItemEntry.builder
                                (ModItems.ROTTEN_TOMATO)
                                        .conditionally
                                                (RandomChanceLootCondition.builder(0.02f))))));


        addDrop(ModBlocks.BLACK_ROSE);
        addDrop(ModBlocks.POTTED_BLACK_ROSE,
                pottedPlantDrops(ModBlocks.BLACK_ROSE));
        addDrop(ModBlocks.WHITE_ROSE);
        addDrop(ModBlocks.POTTED_WHITE_ROSE,
                pottedPlantDrops(ModBlocks.WHITE_ROSE));
        addDrop(ModBlocks.RED_ROSE);
        addDrop(ModBlocks.POTTED_RED_ROSE,
                pottedPlantDrops(ModBlocks.RED_ROSE));
        addDrop(ModBlocks.ORANGE_ROSE);
        addDrop(ModBlocks.POTTED_ORANGE_ROSE,
                pottedPlantDrops(ModBlocks.ORANGE_ROSE));
        addDrop(ModBlocks.YELLOW_ROSE);
        addDrop(ModBlocks.POTTED_YELLOW_ROSE,
                pottedPlantDrops(ModBlocks.YELLOW_ROSE));
        addDrop(ModBlocks.ILL_ROSE);
        addDrop(ModBlocks.POTTED_ILL_ROSE,
                pottedPlantDrops(ModBlocks.ILL_ROSE));
        addDrop(ModBlocks.CYAN_ROSE);
        addDrop(ModBlocks.POTTED_CYAN_ROSE,
                pottedPlantDrops(ModBlocks.CYAN_ROSE));
        addDrop(ModBlocks.BLUE_ROSE);
        addDrop(ModBlocks.POTTED_BLUE_ROSE,
                pottedPlantDrops(ModBlocks.BLUE_ROSE));
        addDrop(ModBlocks.PINK_ROSE);
        addDrop(ModBlocks.POTTED_PINK_ROSE,
                pottedPlantDrops(ModBlocks.PINK_ROSE));
        addDrop(ModBlocks.PURPLE_ROSE);
        addDrop(ModBlocks.POTTED_PURPLE_ROSE,
                pottedPlantDrops(ModBlocks.PURPLE_ROSE));
        addDrop(ModBlocks.RAINBOW_ROSE);
        addDrop(ModBlocks.POTTED_RAINBOW_ROSE,
                pottedPlantDrops(ModBlocks.RAINBOW_ROSE));

        addDrop(ModBlocks.VISION_PAD);
    }

}
