package kyaaaz.shulker.box.alt

import kyaaaz.shulker.Shulker
import org.bukkit.Location
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.util.*

class Place(private val shulker: Shulker, private val loc: Location, private val uuid: UUID) {

    fun place() {
        val key: String = loc.world.name + "," + loc.blockX + "," + loc.blockY + "," + loc.blockZ
        val file = File(shulker.dataFolder.toString() + "/blocks/" + key + ".yml")
        val edit = YamlConfiguration.loadConfiguration(file)



        edit.set("uuid", uuid.toString())
        edit.save(file)

    }

}