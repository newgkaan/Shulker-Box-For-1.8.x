package kyaaaz.shulker.box.utils

import kyaaaz.shulker.Shulker
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.util.UUID


class New(private val shulker: Shulker) {

    fun make() : UUID {
        val uuid: UUID = UUID.randomUUID()
        if (shulker.boxs.contains(uuid)) return make()


        putUUID(uuid)
        putEmpty(uuid)


        return uuid
    }


    private fun putUUID(uuid: UUID) {

        val file = File(shulker.dataFolder.toString() + "/uuids.yml")
        val edit = YamlConfiguration.loadConfiguration(file)

        val boxs : MutableList<String>? = edit.getStringList("boxs")
        boxs?.add(uuid.toString())
        edit.set("boxs", boxs)
        edit.save(file)

        shulker.boxs.add(uuid)
    }


    private fun putEmpty(uuid: UUID) {
        val file = File(shulker.dataFolder.toString() + "/boxs/" + uuid.toString() + ".yml")

        val edit = YamlConfiguration.loadConfiguration(file)

        val inv = Bukkit.createInventory(null, 27, uuid.toString())

        edit.set("inv", inv.contents)
        edit.save(file)
    }

}