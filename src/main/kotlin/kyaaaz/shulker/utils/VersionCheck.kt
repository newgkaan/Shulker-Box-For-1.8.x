package kyaaaz.shulker.utils

class VersionCheck(private val ver: String) {

    fun check(): Boolean {
        return ver.contains("1.8")
    }
}