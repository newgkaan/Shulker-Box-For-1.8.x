package kyaaaz.shulker.utils

import kyaaaz.shulker.Shulker
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.util.*


class LoadBoxs(private val shulker: Shulker) {


    fun load() {

        val file = File(shulker.dataFolder.toString() + "/uuids.yml")
        val edit = YamlConfiguration.loadConfiguration(file)

        val boxs : MutableList<String> = edit.getStringList("boxs")

        for (string in boxs) shulker.boxs.add(UUID.fromString(string))

    }

}