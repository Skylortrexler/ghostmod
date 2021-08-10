package website.skylorbeck.minecraft.ghostmod.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.world.World;

public class GhostSkeletonEntity extends SkeletonEntity {
    public GhostSkeletonEntity(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }
}
