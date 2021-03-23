// Задача №1 - "Только что"

fun main() {
    println(agoToText(0))
    println(agoToText(23))
    println(agoToText(489))
    println(agoToText(60 * 9))
    println(agoToText(60 * 60))
    println(agoToText(60_000_000))
    println(agoToText(1_000_000))
    println(agoToText(60_000))

}

fun agoToText(seconds: Int): String {

    var count = 0
    var text: String

    when (seconds) {
        in 0..59 -> {
            count = seconds
            text = "секунд"
        }
        in 60..3599 -> {
            count = seconds / 60
            text = "минут"
        }
        in 3600..86_399 -> {
            count = seconds / 3600
            text = "час"
        }
        in 86_400..172_799 -> {
            count = 1
            text = "день"
        }
        in 172_800..2_678_399 -> text = "несколько дней"
        in 2_678_400..5_270_399 -> text = "месяц"
        in 5_270_400..31_535_999 -> text = "несколько месяцев"
        in 31_536_000..63_071_999 -> text = "год"
        else -> text = "несколько лет"
    }

    val division = count % 10

    if (seconds < 3600) {
        text = when {
            count in 5..20 -> text
            division == 1 -> text + "у"
            division in 2..4 -> text + "ы"
            else -> text
        }
    } else if (seconds in 3600..86399) {
        text = when {
            count in 5..20 -> text + "ов"
            division == 1 -> text
            division in 2..4 -> text + "а"
            else -> text
        }
    }

    return if (count == 0) {
        "Был только что"
    } else {
        "Был $count $text назад"
    }
}



