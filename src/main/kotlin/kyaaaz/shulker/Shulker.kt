package kyaaaz.shulker

import kyaaaz.shulker.box.Box
import kyaaaz.shulker.commands.CMD
import kyaaaz.shulker.listeners.*
import kyaaaz.shulker.utils.LoadBoxs
import kyaaaz.shulker.utils.SendThx
import kyaaaz.shulker.utils.SetDefault
import kyaaaz.shulker.utils.VersionCheck
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


        server.pluginManager.registerEvents(BlockBreak(this), this)
        server.pluginManager.registerEvents(BlockDamage(this), this)
        server.pluginManager.registerEvents(BlockPlace(this), this)
        server.pluginManager.registerEvents(InventoryClose(this), this)
        server.pluginManager.registerEvents(PlayerInteract(this), this)


        getCommand("shulker").executor = CMD(this)

    }


    override fun onDisable() {

    }


}