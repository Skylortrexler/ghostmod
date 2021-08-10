package website.skylorbeck.minecraft.ghostmod.client;

import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

public class GhostZombieEntityRenderer <T extends ZombieEntity, M extends ZombieEntityModel<T>> extends BipedEntityRenderer<T, M> {
    private static final Identifier TEXTURE = new Identifier("ghostmod:textures/entity/zombie/zombie.png");

    public GhostZombieEntityRenderer(EntityRendererFactory.Context context) {
        this(context, EntityModelLayers.ZOMBIE, EntityModelLayers.ZOMBIE_INNER_ARMOR, EntityModelLayers.ZOMBIE_OUTER_ARMOR);
    }
    public GhostZombieEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer, EntityModelLayer legsArmorLayer, EntityModelLayer bodyArmorLayer) {
        this(ctx, new ZombieEntityModel(ctx.getPart(layer)), new ZombieEntityModel(ctx.getPart(legsArmorLayer)), new ZombieEntityModel(ctx.getPart(bodyArmorLayer)));
    }

    public GhostZombieEntityRenderer(EntityRendererFactory.Context ctx, ZombieEntityModel bodyModel, ZombieEntityModel legsArmorModel, ZombieEntityModel bodyArmorModel) {
        super(ctx, (M) bodyModel, 0.5F);
        this.addFeature(new ArmorFeatureRenderer(this, legsArmorModel, bodyArmorModel));
    }


    public Identifier getTexture(ZombieEntity zombieEntity) {
        return TEXTURE;
    }

    protected boolean isShaking(T zombieEntity) {
        return super.isShaking(zombieEntity) || zombieEntity.isConvertingInWater();
    }
}