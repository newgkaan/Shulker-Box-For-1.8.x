package newgkaan.shulker.listeners


import newgkaan.shulker.Shulker
import newgkaan.shulker.data.Configuration
import newgkaan.shulker.utils.Format
import newgkaan.shulker.utils.HideShow
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import java.util.UUID

class BlockPlace(private val shulker: Shulker): Listener {


    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun on(e: BlockPlaceEvent) {


        val stack = e.itemInHand
        if (Configuration.material != stack.type) return
        if (Format(Configuration.name).format() != stack.itemMeta.displayName) return


        val lore = stack.itemMeta.lore ?: return
        var string = lore[0] ?: return
        string = HideShow(string).show()

        val uuid = UUID.fromString(string) ?: return


        e.player.inventory.remove(stack)
        shulker.box.place(e.blockPlaced.location, uuid)


    }

}