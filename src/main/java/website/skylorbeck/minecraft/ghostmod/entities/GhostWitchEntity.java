package website.skylorbeck.minecraft.ghostmod.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.WitchEntity;
import net.minecraft.world.World;

public class GhostWitchEntity extends WitchEntity {
    public GhostWitchEntity(EntityType<? extends WitchEntity> entityType, World world) {
        super(entityType, world);
    }
}
