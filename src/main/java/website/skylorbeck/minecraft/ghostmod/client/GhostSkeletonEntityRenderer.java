package website.skylorbeck.minecraft.ghostmod.client;

import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.util.Identifier;

public class GhostSkeletonEntityRenderer extends BipedEntityRenderer<AbstractSkeletonEntity, SkeletonEntityModel<AbstractSkeletonEntity>> {
    private static final Identifier TEXTURE = new Identifier("ghostmod:textures/entity/skeleton/skeleton.png");

    public GhostSkeletonEntityRenderer(EntityRendererFactory.Context context) {
        this(context, EntityModelLayers.SKELETON, EntityModelLayers.SKELETON_INNER_ARMOR, EntityModelLayers.SKELETON_OUTER_ARMOR);
    }

    public GhostSkeletonEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer, EntityModelLayer legArmorLayer, EntityModelLayer bodyArmorLayer) {
        super(ctx, new SkeletonEntityModel(ctx.getPart(layer)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer(this, new SkeletonEntityModel(ctx.getPart(legArmorLayer)), new SkeletonEntityModel(ctx.getPart(bodyArmorLayer))));
    }

    public Identifier getTexture(AbstractSkeletonEntity abstractSkeletonEntity) {
        return TEXTURE;
    }

    protected boolean isShaking(AbstractSkeletonEntity abstractSkeletonEntity) {
        return abstractSkeletonEntity.isShaking();
    }
}
