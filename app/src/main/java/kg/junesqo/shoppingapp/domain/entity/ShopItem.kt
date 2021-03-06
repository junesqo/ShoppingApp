package kg.junesqo.shoppingapp.domain.entity

data class ShopItem(
    val name: String?,
    val count: Int?,
    var enable: Boolean,
    var id: Int = UNDEFINED_ID
){
    companion object {
        const val UNDEFINED_ID = 0
    }
}