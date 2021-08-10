package website.skylorbeck.minecraft.ghostmod.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.world.World;

public class GhostSpiderEntity extends SpiderEntity {
    public GhostSpiderEntity(EntityType<? extends SpiderEntity> entityType, World world) {
        super(entityType, world);
    }
}
