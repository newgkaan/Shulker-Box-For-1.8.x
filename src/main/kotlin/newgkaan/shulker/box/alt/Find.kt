package newgkaan.shulker.box.alt

import newgkaan.shulker.Shulker
import org.bukkit.Location
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.util.UUID

class Find(private val shulker: Shulker, private val loc: Location) {


    fun find(): UUID {
        val key: String = loc.world.name + "," + loc.blockX + "," + loc.blockY + "," + loc.blockZ
        val file = File(shulker.dataFolder.toString() + "/blocks/" + key + ".yml")

        val edit = YamlConfiguration.loadConfiguration(file)

        return UUID.fromString(edit.getString("uuid"))
    }

}