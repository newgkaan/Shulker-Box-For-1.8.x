package newgkaan.shulker.box.alt

import newgkaan.shulker.Shulker
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import java.io.File
import java.util.UUID

class Open(private val shulker: Shulker, private val p: Player, private val uuid: UUID) {


    fun open() {


        val file = File(shulker.dataFolder.toString() + "/boxs/" + uuid.toString() + ".yml")

        if (!file.exists()) return

        val edit = YamlConfiguration.loadConfiguration(file)


        val inv: Inventory = Bukkit.createInventory(null, 27, uuid.toString())


        @Suppress("UNCHECKED_CAST")
        val contents : ArrayList<ItemStack> = edit.get("inv") as ArrayList<ItemStack>

        inv.contents = contents.toTypedArray()

        p.openInventory(inv)

    }

}