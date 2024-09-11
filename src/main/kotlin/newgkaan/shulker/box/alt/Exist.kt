package newgkaan.shulker.box.alt

import newgkaan.shulker.Shulker
import org.bukkit.Location
import java.io.File

class Exist(private val shulker: Shulker, private val loc: Location) {

    fun exist() : Boolean {
        val key: String = loc.world.name + "," + loc.blockX + "," + loc.blockY + "," + loc.blockZ
        val file = File(shulker.dataFolder.toString() + "/blocks/" + key + ".yml")
        return file.exists()
    }

}