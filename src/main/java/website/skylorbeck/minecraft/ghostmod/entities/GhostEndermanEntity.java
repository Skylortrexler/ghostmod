package website.skylorbeck.minecraft.ghostmod.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.world.World;

public class GhostEndermanEntity extends EndermanEntity {
    public GhostEndermanEntity(EntityType<? extends EndermanEntity> entityType, World world) {
        super(entityType, world);
    }
}
