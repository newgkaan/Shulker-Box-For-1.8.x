package kyaaaz.shulker.box

import kyaaaz.shulker.Shulker
import kyaaaz.shulker.box.alt.*
import kyaaaz.shulker.box.utils.New
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import java.util.UUID

class Box(private val shulker: Shulker) {



    fun open(p: Player, uuid: UUID) {
        Open(shulker, p, uuid).open()
    }

    fun close(uuid: UUID, inv: Inventory) {
        Close(shulker, uuid, inv).close()
    }

    fun place(loc: Location, uuid: UUID) {
        Place(shulker, loc, uuid).place()
    }

    fun drop(loc: Location, uuid: UUID) {
        Drop(shulker, loc, uuid).drop()
    }

    fun give(p: Player) {
        val uuid: UUID = New(shulker).make()
        Give(shulker, p, uuid).give()
    }

    fun exist(loc: Location): Boolean {
        return Exist(shulker, loc).exist()
    }

    fun find(loc: Location): UUID {
        return Find(shulker, loc).find()
    }


}