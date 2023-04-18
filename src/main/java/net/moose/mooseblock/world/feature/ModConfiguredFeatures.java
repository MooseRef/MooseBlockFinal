package net.moose.mooseblock.world.feature;


import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.moose.mooseblock.block.ModBlocks;
import net.moose.mooseblock.mooseblock;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOOD_KEY = registerKey("mood_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SATIN_KEY = registerKey("satin_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> GOXITE_KEY = registerKey("goxite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BORPITE_KEY = registerKey("borpite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOOSITE_KEY = registerKey("moosite_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> GNEISS_KEY = registerKey("gneiss");

    public static final RegistryKey<ConfiguredFeature<?, ?>> STRAWBERRY_BUSH_KEY = registerKey("strawberry_bush");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACK_ROSE_KEY = registerKey("black_rose");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_ROSE_KEY = registerKey("white_rose");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_ROSE_KEY = registerKey("red_rose");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_ROSE_KEY = registerKey("orange_rose");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_ROSE_KEY = registerKey("yellow_rose");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CYAN_ROSE_KEY = registerKey("cyan_rose");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_ROSE_KEY = registerKey("blue_rose");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_ROSE_KEY = registerKey("pink_rose");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PURPLE_ROSE_KEY = registerKey("purple_rose");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ONYX_GEODE_KEY = registerKey("onyx_geode");



    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);


        List<OreFeatureConfig.Target> overworldGoxite =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.GOXITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_GOXITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldBorpite =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.BORPITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_BORPITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldMoosite =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.MOOSITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_MOOSITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldGneiss =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.GNEISS.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.GNEISS.getDefaultState()));

        register(context, MOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MOOD_LOG),
                new StraightTrunkPlacer(5, 3, 3),
                BlockStateProvider.of(ModBlocks.MOOD_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, SATIN_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.SATIN_LOG),
                new StraightTrunkPlacer(4, 2, 5),
                BlockStateProvider.of(ModBlocks.SATIN_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());


        register(context, GOXITE_KEY, Feature.ORE, new OreFeatureConfig(overworldGoxite, 5));
        register(context, BORPITE_KEY, Feature.ORE, new OreFeatureConfig(overworldBorpite, 4));
        register(context, MOOSITE_KEY, Feature.ORE, new OreFeatureConfig(overworldMoosite, 3));

        register(context, GNEISS_KEY, Feature.ORE, new OreFeatureConfig(overworldGneiss, 12));

        register(context, STRAWBERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.STRAWBERRY_BUSH
                                .getDefaultState().with(SweetBerryBushBlock.AGE,3))))));

        register(context, BLACK_ROSE_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLACK_ROSE)))));
        register(context, WHITE_ROSE_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WHITE_ROSE)))));
        register(context, RED_ROSE_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RED_ROSE)))));
        register(context, ORANGE_ROSE_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ORANGE_ROSE)))));
        register(context, YELLOW_ROSE_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_ROSE)))));
        register(context, CYAN_ROSE_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CYAN_ROSE)))));
        register(context, BLUE_ROSE_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_ROSE)))));
        register(context, PINK_ROSE_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PURPLE_ROSE)))));
        register(context, PURPLE_ROSE_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PINK_ROSE)))));

        register(context, ONYX_GEODE_KEY, Feature.GEODE,
                new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
                        BlockStateProvider.of(ModBlocks.ONYX_BLOCK),  //non budding
                        BlockStateProvider.of(ModBlocks.BUDDING_ONYX), //budding
                        BlockStateProvider.of(Blocks.CALCITE),      //calcite
                        BlockStateProvider.of(ModBlocks.POLISHED_GNEISS),      //smooth basalt
                        List.of(ModBlocks.SMALL_ONYX_BUD.getDefaultState(),
                                ModBlocks.MEDIUM_ONYX_BUD.getDefaultState(),
                                ModBlocks.LARGE_ONYX_BUD.getDefaultState(),
                                ModBlocks.ONYX_CLUSTER.getDefaultState()), // buds
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerThicknessConfig(1.50, 2.20, 3.20,4.20),
                        new GeodeCrackConfig(0.50, 2.0,2),
                        0.20,0.11,true, UniformIntProvider.create(4,6),
                        UniformIntProvider.create(3,4), UniformIntProvider.create(1,2),
                        -15,15,0.025, 1));



    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(mooseblock.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}



