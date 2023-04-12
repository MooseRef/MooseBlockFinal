package net.moose.mooseblock.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.moose.mooseblock.block.ModBlocks;
import net.moose.mooseblock.fluid.ModFluids;
import net.moose.mooseblock.item.ModItems;
import net.moose.mooseblock.mooseblock;
import net.moose.mooseblock.util.ModTags;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataOutput output)
    {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter)
    {
        offerPlanksRecipe(exporter,ModBlocks.MOOD_PLANKS, ModTags.Items.MOOD_LOGS,4);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.MOOD_WOOD,3)
                .pattern("XX")
                .pattern("XX")
                .pattern("  ")
                .input('X',ModBlocks.MOOD_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_LOG))
                .group("bark")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_log"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.STRIPPED_MOOD_WOOD,3)
                .pattern("XX")
                .pattern("XX")
                .pattern("  ")
                .input('X',ModBlocks.STRIPPED_MOOD_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_MOOD_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_MOOD_LOG))
                .group("bark")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "stripped_mood_log"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOOD_STAIRS, 4)
                .pattern("X  ")
                .pattern("XX ")
                .pattern("XXX")
                .input('X',ModBlocks.MOOD_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .group("wooden_stairs")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_stairs"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOOD_SLAB, 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("XXX")
                .input('X',ModBlocks.MOOD_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .group("wooden_slab")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_slab"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MOOD_FENCE, 3)
                .pattern("   ")
                .pattern("XSX")
                .pattern("XSX")
                .input('X',ModBlocks.MOOD_PLANKS)
                .input('S',Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .group("wooden_fence")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_fence"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MOOD_FENCE_GATE, 1)
                .pattern("   ")
                .pattern("SXS")
                .pattern("SXS")
                .input('X',ModBlocks.MOOD_PLANKS)
                .input('S',Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .group("wooden_fence_gate")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_fence_gate"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE,ModBlocks.MOOD_BUTTON, 1)
                .input(ModBlocks.MOOD_PLANKS).criterion("has_mood_planks",
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS)).group("wooden_button")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"mood_button"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MOOD_PRESSURE_PLATE, 1)
                .pattern("   ")
                .pattern("   ")
                .pattern("XX ")
                .input('X',ModBlocks.MOOD_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .group("wooden_pressure_plate")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_pressure_plate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MOOD_DOOR, 3)
                .pattern("XX ")
                .pattern("XX ")
                .pattern("XX ")
                .input('X',ModBlocks.MOOD_PLANKS)
                .group("wooden_door")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_door"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MOOD_TRAPDOOR, 2)
                .pattern("   ")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModBlocks.MOOD_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .group("wooden_trapdoor")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "mood_trapdoor"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MOOD_REDSTONE_LAMP, 1)
                .pattern("XRX")
                .pattern("RGR")
                .pattern("XRX")
                .input('X',ModBlocks.MOOD_PLANKS)
                .input('R',Items.REDSTONE)
                .input('G',Blocks.GLOWSTONE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOD_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOD_PLANKS))
                .offerTo(exporter,  new Identifier(mooseblock.MOD_ID, "mood_redstone_lamp"));


        offerPlanksRecipe(exporter,ModBlocks.SATIN_PLANKS, ModTags.Items.SATIN_LOGS,4);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.SATIN_WOOD,3 )
                .pattern("XX")
                .pattern("XX")
                .pattern("  ")
                .input('X',ModBlocks.SATIN_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_LOG))
                .group("bark")
                .offerTo(exporter,  new Identifier(mooseblock.MOD_ID, "satin_wood"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.STRIPPED_SATIN_WOOD,3)
                .pattern("XX")
                .pattern("XX")
                .pattern("  ")
                .input('X',ModBlocks.STRIPPED_SATIN_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_SATIN_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_SATIN_LOG))
                .group("bark")
                .offerTo(exporter,  new Identifier(mooseblock.MOD_ID, "stripped_satin_log"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SATIN_STAIRS, 4)
                .pattern("X  ")
                .pattern("XX ")
                .pattern("XXX")
                .input('X',ModBlocks.SATIN_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .group("wooden_stairs")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_stairs"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SATIN_SLAB, 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("XXX")
                .input('X',ModBlocks.SATIN_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .group("wooden_slab")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_slab"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SATIN_FENCE, 3)
                .pattern("   ")
                .pattern("XSX")
                .pattern("XSX")
                .input('X',ModBlocks.SATIN_PLANKS)
                .input('S',Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .group("wooden_fence")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_fence"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.SATIN_FENCE_GATE, 1)
                .pattern("   ")
                .pattern("SXS")
                .pattern("SXS")
                .input('X',ModBlocks.SATIN_PLANKS)
                .input('S',Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .group("wooden_fence_gate")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_fence_gate"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE,ModBlocks.SATIN_BUTTON, 1)
                .input(ModBlocks.SATIN_PLANKS).criterion("has_satin_planks",
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS)).group("wooden_button")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"satin_button"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.SATIN_PRESSURE_PLATE, 1)
                .pattern("   ")
                .pattern("   ")
                .pattern("XX ")
                .input('X',ModBlocks.SATIN_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .group("wooden_pressure_plate")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_pressure_plate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.SATIN_DOOR, 3)
                .pattern("XX ")
                .pattern("XG ")
                .pattern("XX ")
                .input('X',ModBlocks.SATIN_PLANKS)
                .input('G',Items.GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .group("wooden_door")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_door"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.SATIN_TRAPDOOR, 2)
                .pattern("   ")
                .pattern("XXX")
                .pattern("XGX")
                .input('X',ModBlocks.SATIN_PLANKS)
                .input('G',Items.GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SATIN_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SATIN_PLANKS))
                .group("wooden_trapdoor")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "satin_trapdoor"));


        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.GOXITE), RecipeCategory.MISC, ModItems.RAW_GOXITE,
                0.5f,200, RecipeSerializer.SMELTING)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RAW_GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.RAW_GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_from_smelting_raw_goxite"));
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.GOXITE), RecipeCategory.MISC, ModItems.RAW_GOXITE,
                        0.5f,100, RecipeSerializer.BLASTING)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RAW_GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.RAW_GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_from_blasting_raw_goxite"));
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.GOXITE), RecipeCategory.MISC, ModBlocks.GOXITE_ORE,
                        0.5f,200, RecipeSerializer.SMELTING)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GOXITE_ORE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.GOXITE_ORE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_from_smelting_goxite_ore"));
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.GOXITE), RecipeCategory.MISC, ModBlocks.GOXITE_ORE,
                        0.5f,100, RecipeSerializer.BLASTING)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GOXITE_ORE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.GOXITE_ORE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_from_blasting_goxite_ore"));
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.GOXITE), RecipeCategory.MISC, ModBlocks.DEEPSLATE_GOXITE_ORE,
                        0.5f,200, RecipeSerializer.SMELTING)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.DEEPSLATE_GOXITE_ORE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.DEEPSLATE_GOXITE_ORE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_from_smelting_deepslate_goxite_ore"));
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.GOXITE), RecipeCategory.MISC, ModBlocks.DEEPSLATE_GOXITE_ORE,
                        0.5f,100, RecipeSerializer.BLASTING)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.DEEPSLATE_GOXITE_ORE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.DEEPSLATE_GOXITE_ORE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_from_blasting_deepslate_goxite_ore"));


        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.BORPITE), RecipeCategory.MISC, ModItems.RAW_BORPITE,
                        0.5f,200, RecipeSerializer.SMELTING)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RAW_BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.RAW_BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_from_smelting_raw_borpite"));
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.BORPITE), RecipeCategory.MISC, ModItems.RAW_BORPITE,
                        0.5f,100, RecipeSerializer.BLASTING)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RAW_BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.RAW_BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_from_blasting_raw_borpite"));
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.BORPITE), RecipeCategory.MISC, ModBlocks.BORPITE_ORE,
                        0.5f,200, RecipeSerializer.SMELTING)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BORPITE_ORE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BORPITE_ORE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_from_smelting_borpite_ore"));
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.BORPITE), RecipeCategory.MISC, ModBlocks.BORPITE_ORE,
                        0.5f,100, RecipeSerializer.BLASTING)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BORPITE_ORE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BORPITE_ORE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_from_blasting_borpite_ore"));
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.BORPITE), RecipeCategory.MISC, ModBlocks.DEEPSLATE_BORPITE_ORE,
                        0.5f,200, RecipeSerializer.SMELTING)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.DEEPSLATE_BORPITE_ORE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.DEEPSLATE_BORPITE_ORE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_from_smelting_deepslate_borpite_ore"));
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.BORPITE), RecipeCategory.MISC, ModBlocks.DEEPSLATE_BORPITE_ORE,
                        0.5f,100, RecipeSerializer.BLASTING)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.DEEPSLATE_BORPITE_ORE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.DEEPSLATE_BORPITE_ORE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_from_blasting_deepslate_borpite_ore"));


        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.MOOSITE), RecipeCategory.MISC, ModBlocks.MOOSITE_ORE,
                        0.5f,200, RecipeSerializer.SMELTING)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOSITE_ORE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOSITE_ORE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "moosite_from_smelting_moosite_ore"));
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.MOOSITE), RecipeCategory.MISC, ModBlocks.MOOSITE_ORE,
                        0.5f,100, RecipeSerializer.BLASTING)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.MOOSITE_ORE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.MOOSITE_ORE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "moosite_from_blasting_moosite_ore"));
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.MOOSITE), RecipeCategory.MISC, ModBlocks.DEEPSLATE_MOOSITE_ORE,
                        0.5f,200, RecipeSerializer.SMELTING)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.DEEPSLATE_MOOSITE_ORE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.DEEPSLATE_MOOSITE_ORE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "moosite_from_smelting_deepslate_moosite_ore"));
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.MOOSITE), RecipeCategory.MISC, ModBlocks.DEEPSLATE_MOOSITE_ORE,
                        0.5f,100, RecipeSerializer.BLASTING)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.DEEPSLATE_MOOSITE_ORE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.DEEPSLATE_MOOSITE_ORE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "moosite_from_blasting_deepslate_moosite_ore"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOXITE,9)
                .input(ModBlocks.BLOCK_OF_GOXITE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLOCK_OF_GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLOCK_OF_GOXITE))
                .offerTo(exporter,new Identifier(mooseblock.MOD_ID,"goxite_from_compacting"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.BLOCK_OF_GOXITE)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModItems.GOXITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "block_of_goxite_from_compacting"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_GOXITE,9)
                .input(ModBlocks.BLOCK_OF_RAW_GOXITE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLOCK_OF_RAW_GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLOCK_OF_RAW_GOXITE))
                .offerTo(exporter,new Identifier(mooseblock.MOD_ID,"raw_goxite_from_compacting"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.BLOCK_OF_RAW_GOXITE)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModItems.RAW_GOXITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RAW_GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.RAW_GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "block_of_raw_goxite_from_compacting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BORPITE,9)
                .input(ModBlocks.BLOCK_OF_BORPITE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLOCK_OF_BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLOCK_OF_BORPITE))
                .offerTo(exporter,new Identifier(mooseblock.MOD_ID,"borpite_from_compacting"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.BLOCK_OF_BORPITE)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModItems.BORPITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "block_of_borpite_from_compacting"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_BORPITE,9)
                .input(ModBlocks.BLOCK_OF_RAW_BORPITE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLOCK_OF_RAW_BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLOCK_OF_RAW_BORPITE))
                .offerTo(exporter,new Identifier(mooseblock.MOD_ID,"raw_borpite_from_compacting"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.BLOCK_OF_RAW_BORPITE)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModItems.RAW_BORPITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RAW_BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.RAW_BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "block_of_raw_borpite_from_compacting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MOOSITE,9)
                .input(ModBlocks.BLOCK_OF_MOOSITE)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLOCK_OF_MOOSITE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLOCK_OF_MOOSITE))
                .offerTo(exporter,new Identifier(mooseblock.MOD_ID,"moosite_from_compacting"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.BLOCK_OF_MOOSITE)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModItems.MOOSITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.MOOSITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.MOOSITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "block_of_moosite_from_compacting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.GOXITE_BOOTS)
                .pattern("   ")
                .pattern("X X")
                .pattern("X X")
                .input('X',ModItems.GOXITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_boots"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.GOXITE_CHESTPLATE)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModItems.GOXITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.GOXITE_LEGGINGS)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .input('X',ModItems.GOXITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.GOXITE_HELMET)
                .pattern("XXX")
                .pattern("X X")
                .pattern("   ")
                .input('X',ModItems.GOXITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.GOXITE_AXE)
                .pattern("XX")
                .pattern("XS")
                .pattern(" S")
                .input('X',ModItems.GOXITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.GOXITE_HOE)
                .pattern("XX")
                .pattern(" S")
                .pattern(" S")
                .input('X',ModItems.GOXITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_hoe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.GOXITE_SHOVEL)
                .pattern("X")
                .pattern("S")
                .pattern("S")
                .input('X',ModItems.GOXITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.GOXITE_SWORD)
                .pattern("X")
                .pattern("X")
                .pattern("S")
                .input('X',ModItems.GOXITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.GOXITE_PICKAXE)
                .pattern("XXX")
                .pattern(" S ")
                .pattern(" S ")
                .input('X',ModItems.GOXITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "goxite_pickaxe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.BORPITE_BOOTS)
                .pattern("   ")
                .pattern("X X")
                .pattern("X X")
                .input('X',ModItems.BORPITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_boots"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.BORPITE_CHESTPLATE)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModItems.BORPITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.BORPITE_LEGGINGS)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .input('X',ModItems.BORPITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.BORPITE_HELMET)
                .pattern("XXX")
                .pattern("X X")
                .pattern("   ")
                .input('X',ModItems.BORPITE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.BORPITE_AXE)
                .pattern("XX")
                .pattern("XS")
                .pattern(" S")
                .input('X',ModItems.BORPITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.BORPITE_HOE)
                .pattern("XX")
                .pattern(" S")
                .pattern(" S")
                .input('X',ModItems.BORPITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_hoe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.BORPITE_SHOVEL)
                .pattern("X")
                .pattern("S")
                .pattern("S")
                .input('X',ModItems.BORPITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.BORPITE_SWORD)
                .pattern("X")
                .pattern("X")
                .pattern("S")
                .input('X',ModItems.BORPITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.BORPITE_PICKAXE)
                .pattern("XXX")
                .pattern(" S ")
                .pattern(" S ")
                .input('X',ModItems.BORPITE)
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "borpite_pickaxe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DICE_CUBE)
                .pattern(" X ")
                .pattern("XRX")
                .pattern(" X ")
                .input('X',ModItems.MOOSITE)
                .input('R', Items.REDSTONE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.MOOSITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.MOOSITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "dice_cube"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DICE_DODECAHEDRON)
                .pattern(" XX")
                .pattern("XRX")
                .pattern("XX ")
                .input('X',ModItems.BORPITE)
                .input('R', Items.REDSTONE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BORPITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BORPITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "dice_dodecahedron"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DICE_ICOSAHEDRON)
                .pattern("XXX")
                .pattern("XRX")
                .pattern("XXX")
                .input('X',ModItems.GOXITE)
                .input('R', Items.REDSTONE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.GOXITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.GOXITE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "dice_icosahedron"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GNEISS, 4)
                .pattern("XX ")
                .pattern("XX ")
                .pattern("   ")
                .input('X',ModBlocks.GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "polished_gneiss"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GNEISS_STAIRS, 4)
                .pattern("X  ")
                .pattern("XX ")
                .pattern("XXX")
                .input('X',ModBlocks.GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "gneiss_stairs"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GNEISS_SLAB, 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("XXX")
                .input('X',ModBlocks.GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "gneiss_slab"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.GNEISS_WALL, 6)
                .pattern("   ")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModBlocks.GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "gneiss_wall"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GNEISS_STAIRS, 4)
                .pattern("X  ")
                .pattern("XX ")
                .pattern("XXX")
                .input('X',ModBlocks.POLISHED_GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.POLISHED_GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.POLISHED_GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "polished_gneiss_stairs"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GNEISS_SLAB, 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("XXX")
                .input('X',ModBlocks.POLISHED_GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.POLISHED_GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.POLISHED_GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "polished_gneiss_slab"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_GNEISS_WALL, 6)
                .pattern("   ")
                .pattern("XXX")
                .pattern("XXX")
                .input('X',ModBlocks.POLISHED_GNEISS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.POLISHED_GNEISS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.POLISHED_GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "polished_gneiss_wall"));

        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GNEISS), RecipeCategory.BUILDING_BLOCKS,ModBlocks.GNEISS_SLAB,2)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS), FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"gneiss_slab_from_stonecutting"));
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GNEISS), RecipeCategory.BUILDING_BLOCKS,ModBlocks.GNEISS_STAIRS,1)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS), FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"gneiss_stairs_from_stonecutting"));
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GNEISS), RecipeCategory.BUILDING_BLOCKS,ModBlocks.GNEISS_WALL,1)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS), FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"gneiss_wall_from_stonecutting"));
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GNEISS), RecipeCategory.BUILDING_BLOCKS,ModBlocks.POLISHED_GNEISS,1)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS), FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"polished_gneiss_from_stonecutting"));
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GNEISS), RecipeCategory.BUILDING_BLOCKS,ModBlocks.POLISHED_GNEISS_SLAB,2)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS), FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"polished_gneiss_slab_from_stonecutting"));
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GNEISS), RecipeCategory.BUILDING_BLOCKS,ModBlocks.POLISHED_GNEISS_STAIRS,1)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS), FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"polished_gneiss_stairs_from_stonecutting"));
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GNEISS), RecipeCategory.BUILDING_BLOCKS,ModBlocks.POLISHED_GNEISS_WALL,1)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.GNEISS), FabricRecipeProvider.conditionsFromItem(ModBlocks.GNEISS))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"polished_gneiss_wall_from_stonecutting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModFluids.GLUE_BUCKET)
                .pattern("XXX")
                .pattern("XWX")
                .pattern("XBX")
                .input('X', Items.LEATHER)
                .input('W', Items.WATER_BUCKET)
                .input('B', Items.BUCKET)
                .criterion(FabricRecipeProvider.hasItem(Items.WATER_BUCKET),
                        FabricRecipeProvider.conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "glue_bucket"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.TOMATO_SEEDS, 1)
                .input(ModItems.TOMATO).criterion("has_tomato",
                        FabricRecipeProvider.conditionsFromItem(ModItems.TOMATO))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"tomato_seeds"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD,ModItems.GOLDEN_TOMATO)
                .pattern("GGG")
                .pattern("GXG")
                .pattern("GGG")
                .input('X',ModItems.TOMATO)
                .input('G',Items.GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TOMATO),
                        FabricRecipeProvider.conditionsFromItem(ModItems.TOMATO))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "golden_tomato"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.ILL_ROSE)
                .pattern("   ")
                .pattern(" R ")
                .pattern(" W ")
                .input('R',ModTags.Items.MOOSE_ROSES)
                .input('W',Blocks.WITHER_ROSE)
                .criterion(FabricRecipeProvider.hasItem(Blocks.WITHER_ROSE),
                        FabricRecipeProvider.conditionsFromItem(Blocks.WITHER_ROSE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "ill_rose"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.RAINBOW_ROSE)
                .pattern("YGC")
                .pattern("ONB")
                .pattern("RPM")
                .input('R',ModBlocks.RED_ROSE)
                .input('O',ModBlocks.ORANGE_ROSE)
                .input('Y',ModBlocks.YELLOW_ROSE)
                .input('G',ModBlocks.ILL_ROSE)
                .input('C',ModBlocks.CYAN_ROSE)
                .input('B',ModBlocks.BLUE_ROSE)
                .input('M',ModBlocks.PURPLE_ROSE)
                .input('P',ModBlocks.PINK_ROSE)
                .input('N',Items.GOLD_NUGGET)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.ILL_ROSE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.ILL_ROSE))
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID, "rainbow_rose"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.BLACK_DYE, 1)
                .input(ModBlocks.BLACK_ROSE).criterion("has_black_rose",
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLACK_ROSE)).group("black_dye")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"black_dye_from_rose"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.LIGHT_GRAY_DYE, 1)
                .input(ModBlocks.WHITE_ROSE).criterion("has_white_rose",
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.WHITE_ROSE)).group("light_gray_dye")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"light_gray_dye_from_rose"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.RED_DYE, 1)
                .input(ModBlocks.RED_ROSE).criterion("has_red_rose",
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.RED_ROSE)).group("red_dye")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"red_dye_from_rose"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.ORANGE_DYE, 1)
                .input(ModBlocks.ORANGE_ROSE).criterion("has_orange_rose",
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.ORANGE_ROSE)).group("orange_dye")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"orange_dye_from_rose"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.YELLOW_DYE, 1)
                .input(ModBlocks.YELLOW_ROSE).criterion("has_yellow_rose",
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.YELLOW_ROSE)).group("yellow_dye")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"yellow_dye_from_rose"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.GREEN_DYE, 1)
                .input(ModBlocks.ILL_ROSE).criterion("has_ill_rose",
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.ILL_ROSE)).group("green_dye")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"green_dye_from_rose"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.CYAN_DYE, 1)
                .input(ModBlocks.CYAN_ROSE).criterion("cyan_rose",
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.CYAN_ROSE)).group("cyan_rose")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"cyan_dye_from_rose"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.BLUE_DYE, 1)
                .input(ModBlocks.BLUE_ROSE).criterion("blue_rose",
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLUE_ROSE)).group("blue_rose")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"blue_dye_from_rose"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.PINK_DYE, 1)
                .input(ModBlocks.PINK_ROSE).criterion("pink_rose",
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.PINK_ROSE)).group("pink_rose")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"pink_dye_from_rose"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.PURPLE_DYE, 1)
                .input(ModBlocks.PURPLE_ROSE).criterion("has_purple_rose",
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.PURPLE_ROSE)).group("purple_rose")
                .offerTo(exporter, new Identifier(mooseblock.MOD_ID,"purple_dye_from_rose"));


                    }


}
