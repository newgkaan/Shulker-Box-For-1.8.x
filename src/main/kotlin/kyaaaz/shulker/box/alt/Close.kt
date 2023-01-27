package kyaaaz.shulker.box.alt

import kyaaaz.shulker.Shulker
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.inventory.Inventory
import java.io.File
import java.util.UUID

class Close(private val shulker: Shulker, private val uuid: UUID, private val inv: Inventory) {

    fun close() {
        val file = File(shulker.dataFolder.toString() + "/boxs/" + uuid.toString() + ".yml")


        val edit = YamlConfiguration.loadConfiguration(file)

        edit.set("inv", inv.contents)

        edit.save(file)
    }

}