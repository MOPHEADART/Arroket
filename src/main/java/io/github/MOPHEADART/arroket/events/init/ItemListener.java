package io.github.MOPHEADART.arroket.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.EntrypointManager;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Namespace;

import java.lang.invoke.MethodHandles;

import static io.github.MOPHEADART.arroket.ArroketMod.NAMESPACE;

public class ItemListener {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    public static Item WRENCH;

    @EventListener
    private static void registerItems(ItemRegistryEvent event) {
        WRENCH = new TemplateItem(NAMESPACE.id("wrench"))
                .setTranslationKey(NAMESPACE.id("wrench"));
    }
}
