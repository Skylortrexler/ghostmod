package website.skylorbeck.minecraft.ghostmod;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Registrar {

    public static void register(){
        regItem("ghostmode",Declarar.ghostmode);
        regItem("invisibleghostmode",Declarar.invisibleghostmode);
    }

    public static void regItem(String name, Item itemid){
        Registry.register(Registry.ITEM, new Identifier("ghostmod", name), itemid);
    }
}
