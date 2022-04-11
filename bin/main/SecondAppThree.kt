const val ITEM_PRICE = 100u
const val DISCOUNT = 100u
const val DISCOUNT_START = 1_001u
const val DISCOUNT_END = 10_001u
const val MAX_PERCENT_DISCOUNT = 5u
const val MIN_PERCENT_DISCOUNT = 1u

fun main() {
    print("Введите количество музыкальных композиций для покупки: ")
    val itemCount = readLine()?.toUInt() ?: return
    val totalPrice = ITEM_PRICE * itemCount
    val discountedPrice = if (totalPrice > DISCOUNT_END) {
        totalPrice - (totalPrice * MAX_PERCENT_DISCOUNT) / 100u
    } else if (totalPrice > DISCOUNT_START) {
        totalPrice - DISCOUNT
    } else {
        totalPrice
    }
    println("Стоимость покупки: $discountedPrice рублей")

    print("Покупаете музыку ежемесячно? (Да/Нет) ")
    val isMusicLover = readLine()
    val permanentDiscount = discountedPrice.toDouble() - (discountedPrice.toDouble()
            * MIN_PERCENT_DISCOUNT.toDouble()) / 100
    val penny = permanentDiscount.toString().substringAfter(".")
    if (isMusicLover == "Да") {
        println(
            "Стоимость покупки с учетом скидки постоянного клиента:" +
                    " ${permanentDiscount.toUInt()} рублей $penny копеек"
        )
    } else {
        println("Благодарим за покупку!")
    }
}


