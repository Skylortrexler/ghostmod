package website.skylorbeck.minecraft.ghostmod.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class GhostZombieEntity extends ZombieEntity {
    public GhostZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    public GhostZombieEntity(World world) {
        super(world);
    }
}
