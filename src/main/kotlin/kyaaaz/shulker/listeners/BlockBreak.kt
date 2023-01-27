package kyaaaz.shulker.listeners

import kyaaaz.shulker.Shulker
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class BlockBreak(private val shulker: Shulker): Listener {


    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun on(e: BlockBreakEvent) {


        if (!shulker.box.exist(e.block.location)) return


        e.isCancelled = true
        e.block.type = Material.AIR

        val uuid = shulker.box.find(e.block.location)

        shulker.box.drop(e.block.location, uuid)

    }

}