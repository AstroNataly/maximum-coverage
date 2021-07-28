import kotlin.math.round

fun calculationAlgorithm (
    currentTransferAmount: Int,
    accountCardType: String = "Мир",
    previousAmountOfTransfersThisMonth: Int = 600_00
): Int {

    val startCommissionAmount = round(((currentTransferAmount * cardCommissionSize(accountCardType,
        currentTransferAmount))/100)).toInt()

    val commissionAmount = if (accountCardType == "Mastercard" || accountCardType == "Maestro") {
        if (currentTransferAmount < 7_500_000) startCommissionAmount
        else startCommissionAmount + 20_00
    } else if (accountCardType == "Visa" || accountCardType == "Мир") {
        if (currentTransferAmount >= (100 * 35_00 / 0.75)) startCommissionAmount
        else 35_00
    } else {
        startCommissionAmount
    }

    return when {
        isNoLimits(currentTransferAmount, previousAmountOfTransfersThisMonth) -> commissionAmount
        else -> {
            0
        }
    }
}

fun cardCommissionSize(accountCardType: String, currentTransferAmount: Int): Double {
    return if (accountCardType == "Mastercard" || accountCardType == "Maestro") {
        if (currentTransferAmount < 75_000_00) 0.00
        else 0.6
    } else if (accountCardType == "Visa" || accountCardType == "Мир") 0.75
    else {
        0.0
    }
}

fun isNoLimits(currentTransferAmount: Int, previousAmountOfTransfersThisMonth: Int): Boolean {
    return when {
        (currentTransferAmount < 15_000_00 && previousAmountOfTransfersThisMonth < 40_000_000) -> true
        (currentTransferAmount < 150_000_00 && previousAmountOfTransfersThisMonth < 600_000_00) -> true
        else -> false
    }
}

fun main() {
    val currentTransferAmount = 180_000_00

    println("Коммиссия равна ${calculationAlgorithm(currentTransferAmount) / 100} руб." +
            "${calculationAlgorithm(currentTransferAmount) % 100} коп.")
}
