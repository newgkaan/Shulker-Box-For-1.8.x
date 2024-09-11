package newgkaan.shulker.listeners

import newgkaan.shulker.Shulker
import newgkaan.shulker.data.Configuration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryType
import java.util.*

class InventoryClose(private val shulker: Shulker): Listener {

    @EventHandler
    fun on(e: InventoryCloseEvent) {

        if (e.inventory.type != InventoryType.CHEST) return

        try {
            val name = e.inventory.name ?: return
            val uuid = UUID.fromString(name) ?: return

            if (!shulker.boxs.contains(uuid)) return

            shulker.box.close(uuid, e.inventory)

            if (Configuration.makeSound) {
                e.player.world.playSound(e.player.location, Configuration.shulkerCloseSound, 1F, 1F)
            }

        } catch (ignored: Exception) {}


    }


}