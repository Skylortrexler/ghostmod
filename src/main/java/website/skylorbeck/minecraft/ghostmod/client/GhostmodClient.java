package website.skylorbeck.minecraft.ghostmod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.keybinding.KeyBindingRegistryImpl;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import org.lwjgl.glfw.GLFW;

import static website.skylorbeck.minecraft.ghostmod.Declarar.*;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class GhostmodClient implements ClientModInitializer {
    public static KeyBinding lightningKey;
    @Override
    public void onInitializeClient() {
        lightningKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.ghostmod.zap",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_Z,
                "category.ghostmod"
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (lightningKey.wasPressed()) {
                Vec3d ray = client.player.raycast(50,client.getTickDelta(),false).getPos();
                client.player.sendChatMessage("/summon minecraft:lightning_bolt "+ray.x+" "+ray.y+" "+ray.z);
            }
        });

        EntityRendererRegistry.INSTANCE.register(GHOSTCREEP, GhostCreeperEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(GHOSTENDERMAN, GhostEndermanEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(GHOSTSKELETON, GhostSkeletonEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(GHOSTSPIDER, GhostSpiderEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(GHOSTZOMBIE, GhostZombieEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(GHOSTZOMBIEVILLAGER, GhostZombieVillagerEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(GHOSTWITCH, GhostWitchEntityRenderer::new);
    }
}
