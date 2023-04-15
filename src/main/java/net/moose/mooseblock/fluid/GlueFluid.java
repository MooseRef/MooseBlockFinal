package net.moose.mooseblock.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;


public abstract class GlueFluid extends FlowableFluid {


    @Override
    protected boolean isInfinite(World world) {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    protected int getFlowSpeed(WorldView world) {
        return world.getDimension().ultrawarm() ? 4 : 2;
        //return 4;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        //return 2;
        return world.getDimension().ultrawarm() ? 1 : 2;

    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid== getStill() || fluid == getFlowing();
    }

    @Override
    public int getLevel(FluidState state) {
        return 0;
    }

    @Override
    public int getTickRate(WorldView world) {
        //return 20;
        return world.getDimension().ultrawarm() ? 10 : 30;
    }

    @Override
    protected float getBlastResistance() {
        return 100f;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.STILL_GLUE;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_GLUE;
    }

    @Override
    public Item getBucketItem() {
        return ModFluids.GLUE_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModFluids.GLUE_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }


    @Override
    public boolean isStill(FluidState state) {
        return false;
    }
    public static class Flowing extends GlueFluid{
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends GlueFluid{
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }

}
