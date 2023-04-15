package net.moose.mooseblock.world.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.moose.mooseblock.block.ModBlocks;
import net.moose.mooseblock.mooseblock;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> MOOD_PLACED_KEY = registerKey("mood_placed");
    public static final RegistryKey<PlacedFeature> SATIN_PLACED_KEY = registerKey("satin_placed");

    public static final RegistryKey<PlacedFeature> GOXITE_ORE_PLACED_KEY = registerKey("goxite_ore_placed");
    public static final RegistryKey<PlacedFeature> BORPITE_ORE_PLACED_KEY = registerKey("borpite_ore_placed");
    public static final RegistryKey<PlacedFeature> MOOSITE_ORE_PLACED_KEY = registerKey("moosite_ore_placed");

    public static final RegistryKey<PlacedFeature> GNEISS_PLACED_KEY = registerKey("gneiss_placed");

    public static final RegistryKey<PlacedFeature> BLACK_ROSE_PLACED_KEY = registerKey("black_rose_placed");
    public static final RegistryKey<PlacedFeature> WHITE_ROSE_PLACED_KEY = registerKey("white_rose_placed");
    public static final RegistryKey<PlacedFeature> RED_ROSE_PLACED_KEY = registerKey("red_rose_placed");
    public static final RegistryKey<PlacedFeature> ORANGE_ROSE_PLACED_KEY = registerKey("orange_rose_placed");
    public static final RegistryKey<PlacedFeature> YELLOW_ROSE_PLACED_KEY = registerKey("yellow_rose_placed");
    public static final RegistryKey<PlacedFeature> CYAN_ROSE_PLACED_KEY = registerKey("cyan_rose_placed");
    public static final RegistryKey<PlacedFeature> BLUE_ROSE_PLACED_KEY = registerKey("blue_rose_placed");
    public static final RegistryKey<PlacedFeature> PINK_ROSE_PLACED_KEY = registerKey("pink_rose_placed");
    public static final RegistryKey<PlacedFeature> PURPLE_ROSE_PLACED_KEY = registerKey("purple_rose_placed");

    public static final RegistryKey<PlacedFeature> ONYX_GEODE_PLACED_KEY = registerKey("onyx_geode_placed");


    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, MOOD_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MOOD_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,0),ModBlocks.MOOD_SAPLING));
        register(context, SATIN_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SATIN_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,0),ModBlocks.SATIN_SAPLING));

        register(context, GOXITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GOXITE_KEY),
                ModOrePlacement.modifiersWithCount(3,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-30),YOffset.fixed(80))));
        register(context, BORPITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BORPITE_KEY),
                ModOrePlacement.modifiersWithCount(3,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-45),YOffset.fixed(60))));
        register(context, MOOSITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MOOSITE_KEY),
                ModOrePlacement.modifiersWithCount(3,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-60),YOffset.fixed(10))));

        register(context, GNEISS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GNEISS_KEY),
                ModOrePlacement.modifiersWithCount(5,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-20),YOffset.fixed(60))));



        register(context, BLACK_ROSE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLACK_ROSE_KEY),
                RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
        register(context, WHITE_ROSE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WHITE_ROSE_KEY),
                RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
        register(context, RED_ROSE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_ROSE_KEY),
                RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
        register(context, ORANGE_ROSE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGE_ROSE_KEY),
                RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
        register(context, YELLOW_ROSE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_ROSE_KEY),
                RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
        register(context, CYAN_ROSE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYAN_ROSE_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
        register(context, BLUE_ROSE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_ROSE_KEY),
                RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
        register(context, PINK_ROSE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_ROSE_KEY),
                RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());
        register(context, PURPLE_ROSE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PURPLE_ROSE_KEY),
                RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of());

        register(context, ONYX_GEODE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ONYX_GEODE_KEY),
                RarityFilterPlacementModifier.of(50), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(
                        YOffset.aboveBottom(6),YOffset.aboveBottom(60)), BiomePlacementModifier.of());

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(mooseblock.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
