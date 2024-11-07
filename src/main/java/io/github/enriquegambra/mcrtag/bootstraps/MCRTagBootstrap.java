package io.github.enriquegambra.mcrtag.bootstraps;

import io.github.enriquegambra.mcrtag.utilities.RegisterCommandsHandler;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;

public class MCRTagBootstrap implements PluginBootstrap {

    @Override
    public void bootstrap(BootstrapContext bootstrapContext) {

        LifecycleEventManager<BootstrapContext> manager = bootstrapContext.getLifecycleManager();

        RegisterCommandsHandler.registerCommands(manager);
    }
}
