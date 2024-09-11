package newgkaan.shulker.utils

import org.bukkit.ChatColor

class HideShow(private val string: String) {

    fun hide(): String {

        val hidden = StringBuilder()
        for (c in string.toCharArray()) hidden.append(ChatColor.COLOR_CHAR.toString() + "").append(c)

        return hidden.toString()
    }


    fun show(): String {
        return string.replace(ChatColor.COLOR_CHAR.toString() + "", "")
    }

}