package kyaaaz.shulker.data

import kyaaaz.shulker.Shulker
import org.bukkit.Effect
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class LoadConfiguration(private val shulker: Shulker) {


    fun load() {
        val file = File(shulker.dataFolder.toString() + "/config.yml")
        if (!file.exists()) return


        val edit = YamlConfiguration.loadConfiguration(file)

        Configuration.canDamage = edit.getBoolean("canDamage")

        var material: Material = Material.getMaterial(edit.getString("material"))
        if (material == Material.AIR) material = Material.SKULL_ITEM
        Configuration.material = material

        Configuration.name = edit.getString("name")

        Configuration.msgPerm = edit.getString("msgPerm")
        Configuration.msgGived = edit.getString("msgGived")
        Configuration.msgTargetNull = edit.getString("msgTargetNull")
        Configuration.msgConfigReloaded = edit.getString("msgConfigReloaded")
        Configuration.skullOwnerIfMaterialSkull = edit.getString("skullOwnerIfMaterialSkull")

        Configuration.visibleItemsInLore = edit.getBoolean("visibleItemsInLore")






        var effect = Effect.getByName(edit.getString("shulkerOpenParticle"))
        if (effect == null) effect = Effect.HEART
        Configuration.shulkerOpenParticle = effect


        Configuration.makeParticle = edit.getBoolean("makeParticle")
        Configuration.makeSound = edit.getBoolean("makeSound")


        Configuration.shulkerOpenSound = Sound.valueOf(edit.getString("shulkerOpenSound"))
        Configuration.shulkerCloseSound = Sound.valueOf(edit.getString("shulkerCloseSound"))
    }

}