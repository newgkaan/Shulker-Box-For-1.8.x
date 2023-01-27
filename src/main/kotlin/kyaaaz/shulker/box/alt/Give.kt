package kyaaaz.shulker.box.alt


import kyaaaz.shulker.Shulker
import kyaaaz.shulker.box.utils.ConvertItemStack
import org.bukkit.entity.Player
import java.util.UUID

class Give(private val shulker: Shulker, private val p: Player, private val uuid: UUID) {

    fun give() {
        val stack = ConvertItemStack(shulker, uuid).convert()

        if (p.inventory.firstEmpty() == -1) {
            p.location.world.dropItem(p.location, stack)
            return
        }

        p.inventory.addItem(stack)
    }

}