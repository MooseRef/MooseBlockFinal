package net.moose.mooseblock.entity.goals;

import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.moose.mooseblock.entity.custom.RaccoonEntity;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SearchComposterGoal extends Goal {

    private final RaccoonEntity entity;

    public SearchComposterGoal(RaccoonEntity entity) {this.entity = entity;}


    @Override
    public boolean canStart() {
        return this.entity.getBlockTarget() == null; // && this.entity.getRandom().nextFloat() < 0.1f;
    }

    @Override
    public boolean shouldContinue() {
        return this.entity.getBlockTarget() == null;
    }

    public void tick() { searchForComposter(); }

    private void searchForComposter() {
        var composter = getComposter();
        if (composter.size() == 0)
            return;

        var pos = getRandomNavigableBlockPos(composter);
        // check we find a composter path
        if (pos == null)
            return;

        entity.setBlockTarget(pos);

    }
    @Nullable
    private BlockPos getRandomNavigableBlockPos(List<BlockPos> composter) {
        while (composter.size() > 0) {
            var index = entity.getRandom().nextInt(composter.size());
            var pos = composter.get(index);
            var path = this.entity.getNavigation().findPathTo(pos, 1);
            if (path != null && path.reachesTarget()) {
                return pos;
            } else {
                composter.remove(index);
            }
        }
        return null;
    }

    private List<BlockPos> getComposter() {
        ArrayList<BlockPos> blocks = new ArrayList<>();

        BlockPos pos = this.entity.getBlockPos();
        BlockPos start = pos.add(-10, -10, -10);
        BlockPos end = pos.add(10, 10, 10);
        for (BlockPos blockpos$mutableblockpos : BlockPos.iterate(start, end)) {
            Block block = this.entity.world.getBlockState(blockpos$mutableblockpos).getBlock();
            if (isValidBlock(block)) {
                blocks.add(blockpos$mutableblockpos.toImmutable());
            }
        }

        return blocks;
    }

    private boolean isValidBlock(Block block) {return block instanceof ComposterBlock;} // instanceof Blocks.Composter;}

}











