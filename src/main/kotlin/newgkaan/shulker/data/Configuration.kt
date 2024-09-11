package newgkaan.shulker.data

import org.bukkit.Effect
import org.bukkit.Material
import org.bukkit.Sound

object Configuration {

    var name = "&cShulker Box"
    var material = Material.SKULL_ITEM
    var skullOwnerIfMaterialSkull = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmNhYWE5OTMyM2I0OWFkOTIyYTM4Y2JiNTg2YzgxYjM4MTYwZTFhZWFiYzY3NTcyMGZkOGVmZDg3YTY3ZmM1NCJ9fX0="



    var makeParticle = true
    var makeSound = true
    var shulkerOpenParticle = Effect.HEART
    var shulkerOpenSound = Sound.CHEST_OPEN
    var shulkerCloseSound = Sound.CHEST_CLOSE


    var visibleItemsInLore = true

    var canDamage = false
    var msgPerm = "&cYou don't have permission for this command"
    var msgGived = "&aYou give a shulker box a player"
    var msgTargetNull = "&cYour target player was null"
    var msgConfigReloaded = "&aConfiguration successfully reloaded"
    var msgAvailable = "&aAvailable options are [reload], [give <target>]"

}