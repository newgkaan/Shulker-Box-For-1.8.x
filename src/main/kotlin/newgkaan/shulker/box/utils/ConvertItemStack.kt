package newgkaan.shulker.box.utils

import com.mojang.authlib.GameProfile
import com.mojang.authlib.properties.Property
import newgkaan.shulker.Shulker
import newgkaan.shulker.data.Configuration
import newgkaan.shulker.utils.Format
import newgkaan.shulker.utils.HideShow
import org.bukkit.Material
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.inventory.ItemStack
import java.io.File
import java.lang.NullPointerException
import java.lang.reflect.Field
import java.util.*
import kotlin.collections.ArrayList

class ConvertItemStack(private val shulker: Shulker, private val uuid: UUID) {


    fun convert() : ItemStack {

        val stack : ItemStack = if (Configuration.material == Material.SKULL_ITEM) {
            ItemStack(Configuration.material, 1, 3)
        } else {
            ItemStack(Configuration.material)
        }

        val meta = stack.itemMeta
        meta.displayName = Format(Configuration.name).format()


        if (stack.type == Material.SKULL_ITEM) {


            val profile = GameProfile(UUID.randomUUID(), "")
            profile.properties.put("textures", Property("textures", Configuration.skullOwnerIfMaterialSkull))

            val field : Field
            try {
                field = meta.javaClass.getDeclaredField("profile")
                field.isAccessible = true
                field.set(meta, profile)
            } catch (ignored : Exception) {}

        }


        val lore: MutableList<String> = ArrayList()
        lore.add(HideShow(uuid.toString()).hide())



        if (Configuration.visibleItemsInLore) {

            val file = File(shulker.dataFolder.toString() + "/boxs/" + uuid.toString() + ".yml")
            if (file.exists()) {

                val edit = YamlConfiguration.loadConfiguration(file)
                @Suppress("UNCHECKED_CAST")
                val contents : ArrayList<ItemStack> = edit.get("inv") as ArrayList<ItemStack>



                try {
                    for (st in contents) {
                        try {
                            if (st.type.equals(Material.AIR)) continue
                            lore.add(Format("&8- &7" + st.type.toString() + " &f(" + st.amount + "x)").format())
                        } catch (ignored: NullPointerException) {
                            continue
                        }
                    }
                } catch (ignored: NullPointerException) {}

            }
        }




        meta.lore = lore

        stack.itemMeta = meta

        return stack
    }

}