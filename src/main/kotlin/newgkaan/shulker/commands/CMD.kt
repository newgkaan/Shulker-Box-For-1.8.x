package newgkaan.shulker.commands

import newgkaan.shulker.Shulker
import newgkaan.shulker.data.Configuration
import newgkaan.shulker.data.LoadConfiguration
import newgkaan.shulker.utils.Format
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class CMD(private val shulker: Shulker) : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>): Boolean {


        if (!sender.hasPermission("shulker.op")) {
            sender.sendMessage(Format(Configuration.msgPerm).format())
            return true
        }

        if (args.isEmpty()) {
            sender.sendMessage(Format(Configuration.msgAvailable).format())
            return true
        }

        if (args[0].lowercase() == "reload") {
            LoadConfiguration(shulker).load()
            sender.sendMessage(Format(Configuration.msgConfigReloaded).format())
        }
        if (args[0].lowercase() == "give") {
            if (args.size != 2) {
                sender.sendMessage(Format(Configuration.msgAvailable).format())
                return true
            }

            val target = Bukkit.getPlayer(args[1])
            if (target == null) {
                sender.sendMessage(Format(Configuration.msgTargetNull).format())
                return true
            }

            sender.sendMessage(Format(Configuration.msgGived).format())
            shulker.box.give(target)


            return true
        }


        sender.sendMessage(Format(Configuration.msgAvailable).format())
        return true
    }
}