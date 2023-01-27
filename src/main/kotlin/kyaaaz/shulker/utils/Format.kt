package kyaaaz.shulker.utils

import org.bukkit.ChatColor

class Format(private val string: String) {
    fun format(): String {
        return ChatColor.translateAlternateColorCodes('&', string)
    }
}