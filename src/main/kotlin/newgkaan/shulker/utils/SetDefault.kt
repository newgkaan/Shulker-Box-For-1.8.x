package newgkaan.shulker.utils

import newgkaan.shulker.Shulker
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.util.UUID

class SetDefault(private val shulker : Shulker) {





    fun makeDirs() {
        val file = File(shulker.dataFolder.toString() + "/boxs/")
        if (file.exists()) return
        file.mkdirs()
    }

    fun setUUID() {
        val file = File(shulker.dataFolder.toString() + "/uuids.yml")

        if (file.exists()) return

        val edit = YamlConfiguration.loadConfiguration(file)
        val boxs : MutableSet<UUID> = HashSet()
        edit.set("boxs", boxs)
        edit.save(file)
    }

    fun setConfig() {
        val file = File(shulker.dataFolder.toString() + "/config.yml")

        if (file.exists()) return

        shulker.saveResource("config.yml", false)

    }

}