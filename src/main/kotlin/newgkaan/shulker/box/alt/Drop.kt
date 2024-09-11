package newgkaan.shulker.box.alt

import newgkaan.shulker.Shulker
import newgkaan.shulker.box.utils.ConvertItemStack
import org.bukkit.Location
import java.io.File
import java.util.UUID

class Drop(private val shulker: Shulker, private val loc: Location, private val uuid: UUID) {


    fun drop() {

        val key: String = loc.world.name + "," + loc.blockX + "," + loc.blockY + "," + loc.blockZ
        val file = File(shulker.dataFolder.toString() + "/blocks/" + key + ".yml")
        file.delete()

        val stack = ConvertItemStack(shulker, uuid).convert()

        loc.world.dropItemNaturally(loc, stack)

    }



}