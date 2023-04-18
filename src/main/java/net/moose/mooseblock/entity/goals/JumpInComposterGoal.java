package net.moose.mooseblock.entity.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.moose.mooseblock.entity.custom.RaccoonEntity;

public class JumpInComposterGoal extends Goal {

    private final RaccoonEntity entity;

    private int ticks = 0;

    public JumpInComposterGoal(RaccoonEntity entity) {this.entity =entity;}

    @Override
    public boolean canStart(){ return this.entity.getBlockTarget() != null && this.entity.getRandom().nextFloat() < 0.01f; }

    @Override
    public boolean shouldContinue()  {
        return this.entity.getBlockTarget() != null;
    }

    public void start() {
        var target = this.entity.getBlockTarget();
        entity.getNavigation().startMovingTo(target.getX(), target.getY(), target.getZ(), 0.75);
    }

    public void tick() {
        this.ticks++;
        if (this.ticks > 40 && !entity.getNavigation().isFollowingPath()) {
            entity.clearBlockTarget();
            return;
        }

        var target = entity.getBlockTarget();
        if (target == null || !canJumpInTarget(target))
            return;



        // stop and clear invalid target
        //
        //catch (Exception e){
        //    mooseblock.LOGGER.error("Failed to find/dig composter", e);
        //    entity.clearBlockTarget();
        //}
    }


    private boolean canJumpInTarget(BlockPos pos) {
        var distance = this.entity.getBlockPos().getManhattanDistance(pos);
        return distance <= 1;
    }





}
