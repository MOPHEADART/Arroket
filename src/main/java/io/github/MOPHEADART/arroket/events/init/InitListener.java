package io.github.MOPHEADART.arroket.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.mod.InitEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.EntrypointManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

import static io.github.MOPHEADART.arroket.ArroketMod.NAMESPACE;

public class InitListener {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    public static final Logger LOGGER = NAMESPACE.getLogger();

    @EventListener
    private static void serverInit(InitEvent event) {
        LOGGER.info(NAMESPACE.toString());
    }
}
