package io.github.enriquegambra.mcrtag;

import io.github.enriquegambra.mcrtag.listeners.PlayerListener;
import io.github.enriquegambra.mcrtag.utilities.RegisterCommandsHandler;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 *
 */
public class MCRTagPlugin extends JavaPlugin implements Listener
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);

        LifecycleEventManager<Plugin> manager = this.getLifecycleManager();

        RegisterCommandsHandler.registerCommands(manager);
    }

}
