package website.skylorbeck.minecraft.ghostmod;

import net.fabricmc.api.ModInitializer;

public class Ghostmod implements ModInitializer {
    @Override
    public void onInitialize() {
        Registrar.register();
    }
}
