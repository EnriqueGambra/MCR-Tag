package io.github.enriquegambra.mcrtag.listeners;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // TO-DO: Able to spectate after player left?
        Player player = event.getPlayer();

        System.out.println("Player joined: " + player.getName());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        // TO-DO: Remove player from list of players participating in tag
        Player player = event.getPlayer();

        System.out.println("Player quit: " + player.getName());
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        // TO-DO: Record when the user who is tagged hits a player that is not tagged
        Entity entity =  event.getEntity();

        if (entity instanceof Player) {

            Player player = (Player) entity;

        }
    }

}
