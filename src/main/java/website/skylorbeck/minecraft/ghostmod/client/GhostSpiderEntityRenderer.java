package website.skylorbeck.minecraft.ghostmod.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SpiderEyesFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.util.Identifier;

public class GhostSpiderEntityRenderer<T extends SpiderEntity> extends MobEntityRenderer<T, SpiderEntityModel<T>> {
    private static final Identifier TEXTURE = new Identifier("ghostmod:textures/entity/spider/spider.png");

    public GhostSpiderEntityRenderer(EntityRendererFactory.Context context) {
        this(context, EntityModelLayers.SPIDER);
    }

    public GhostSpiderEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer) {
        super(ctx, new SpiderEntityModel(ctx.getPart(layer)), 0.8F);
        this.addFeature(new SpiderEyesFeatureRenderer(this));
    }

    protected float getLyingAngle(T spiderEntity) {
        return 180.0F;
    }

    public Identifier getTexture(T spiderEntity) {
        return TEXTURE;
    }
}
