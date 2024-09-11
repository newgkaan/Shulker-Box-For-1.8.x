package newgkaan.shulker.listeners

import newgkaan.shulker.Shulker
import newgkaan.shulker.data.Configuration
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerInteractEvent

class PlayerInteract(private val shulker: Shulker): Listener{

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun on(e: PlayerInteractEvent) {
        val action = e.action


        if (action != Action.RIGHT_CLICK_BLOCK) {
            fix(e)
            return
        }

        if (!shulker.box.exist(e.clickedBlock.location)) return


        val uuid = shulker.box.find(e.clickedBlock.location)



        e.isCancelled = true


        if (Configuration.makeParticle) {
            val loc = e.clickedBlock.location.clone()
            loc.add(0.0, 0.3, 0.0)
            loc.world.playEffect(loc, Configuration.shulkerOpenParticle, 1, 1)
        }

        if (Configuration.makeSound) {
            val loc = e.clickedBlock.location
            loc.world.playSound(loc, Configuration.shulkerOpenSound, 1F, 1F)
        }



        shulker.box.open(e.player, uuid)

    }

    private fun fix(e: PlayerInteractEvent) {

        if (e.action != Action.LEFT_CLICK_BLOCK) return
        if (!shulker.box.exist(e.clickedBlock.location)) return

        val breakEvent = BlockBreakEvent(e.clickedBlock, e.player)
        shulker.server.pluginManager.callEvent(breakEvent)
        if (e.isCancelled) return

        e.clickedBlock.type = Material.AIR

        val uuid = shulker.box.find(e.clickedBlock.location)

        shulker.box.drop(e.clickedBlock.location, uuid)



    }

}