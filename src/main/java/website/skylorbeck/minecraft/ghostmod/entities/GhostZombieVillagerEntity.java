package website.skylorbeck.minecraft.ghostmod.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.world.World;

public class GhostZombieVillagerEntity extends ZombieVillagerEntity {
    public GhostZombieVillagerEntity(EntityType<? extends ZombieVillagerEntity> entityType, World world) {
        super(entityType, world);
    }
}
