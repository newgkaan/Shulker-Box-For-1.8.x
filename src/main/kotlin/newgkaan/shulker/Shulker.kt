package newgkaan.shulker

import newgkaan.shulker.box.Box
import newgkaan.shulker.commands.CMD
import newgkaan.shulker.listeners.*
import newgkaan.shulker.utils.LoadBoxs
import newgkaan.shulker.utils.SendThx
import newgkaan.shulker.utils.SetDefault
import newgkaan.shulker.utils.VersionCheck
import org.bukkit.plugin.java.JavaPlugin
import java.util.UUID

class Shulker : JavaPlugin() {

    val boxs: MutableSet<UUID> = HashSet()

    val box: Box = Box(this)

    override fun onEnable() {
        if (!VersionCheck(server.version).check()) {
            logger.severe("This plugin maked for spigot version 1.8.x. This version is unsupported!")
            this.isEnabled = false
            this.pluginLoader.disablePlugin(this)
            return
        }
        SendThx(this).send()


        val setdefault = SetDefault(this)
        setdefault.makeDirs()
        setdefault.setUUID()
        setdefault.setConfig()

        LoadBoxs(this).load()


        server.pluginManager.registerEvents(BlockDamage(this), this)
        server.pluginManager.registerEvents(BlockPlace(this), this)
        server.pluginManager.registerEvents(InventoryClose(this), this)
        server.pluginManager.registerEvents(PlayerInteract(this), this)


        getCommand("shulker").executor = CMD(this)

    }


    override fun onDisable() {

    }


}