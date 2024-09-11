package newgkaan.shulker.listeners

import newgkaan.shulker.Shulker
import newgkaan.shulker.data.Configuration
import org.bukkit.Material

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockDamageEvent

class BlockDamage(private val shulker : Shulker) : Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    fun on(e : BlockDamageEvent) {

        if (!shulker.box.exist(e.block.location)) return


        e.isCancelled = true
        if (Configuration.canDamage) {
            e.block.type = Material.AIR

            val uuid = shulker.box.find(e.block.location)
            shulker.box.drop(e.block.location, uuid)

        }



    }

}