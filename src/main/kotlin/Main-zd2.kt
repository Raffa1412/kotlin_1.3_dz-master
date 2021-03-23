// Задача №2 - Разная комиссия

fun main() {
    println(calculateTransfer(transfer = 7800000.0, total = 0.0, bankCard = "Maestro"))
}

fun calculateTransfer(bankCard: String = "VK Pay", transfer: Double, total: Double): String {

    val commissionNull = 0.0
    val percentVisaAndMir = 0.75
    val percentMastercardAndMaestro = 0.6
    val minCommissionVisaAndMir = 3500.0
    val commissionKopVisaAndMir = (transfer * percentVisaAndMir) / 100
    val commissionKopMastercardAndMaestro = (transfer * percentMastercardAndMaestro) / 100 + 2000

    if (transfer <= 150_000_00.0 && total <= 600_000_00.0) {

        val commissionKop = when (bankCard) {
            "VK Pay" -> {
                if (transfer <= 15_000_00 && total <= 40_000_00) {
                    commissionNull
                } else {
                    return "Вы превысили лимит переводов по VK Pay"
                }
            }
            "Visa" -> {
                if (commissionKopVisaAndMir <= minCommissionVisaAndMir) {
                    minCommissionVisaAndMir
                } else {
                    commissionKopVisaAndMir
                }
            }
            "Мир" -> {
                if (commissionKopVisaAndMir <= minCommissionVisaAndMir) {
                    minCommissionVisaAndMir
                } else {
                    commissionKopVisaAndMir
                }
            }
            "Mastercard" -> {
                if (transfer in 0.0..7500000.0) {
                    commissionNull
                } else {
                    commissionKopMastercardAndMaestro
                }
            }
            "Maestro" -> {
                if (transfer in 0.0..7500000.0) {
                    commissionNull
                } else {
                    commissionKopMastercardAndMaestro
                }
            }
            else -> {
                commissionNull
            }
        }
        return "Коммисия $commissionKop копеек"
    } else {
        return "Вы превысили лимит переводов"
    }
}











