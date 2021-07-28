package ru.netology

import calculationAlgorithm
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculationAlgorithm_shouldAddDiscount() {
        val transferAmount = 80_000_00
        val cardType = "Visa"
        val amountOfTransfersThisMonth = 10_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(600_00, result)
    }

    @Test
    fun calculationAlgorithm_shouldNotAddDiscount() {
        val transferAmount = 8_000_00
        val cardType = "Vk Pay"
        val amountOfTransfersThisMonth = 10_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }

    @Test
    fun calculationAlgorithm_shouldAddDiscountVisa() {
        val transferAmount = 80_000_00
        val cardType = "Visa"
        val amountOfTransfersThisMonth = 100_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(600_00, result)
    }

    @Test
    fun calculationAlgorithm_shouldAddDiscountVisa_min() {
        val transferAmount = 800_00
        val cardType = "Visa"
        val amountOfTransfersThisMonth = 10_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(35_00, result)
    }

    @Test
    fun calculationAlgorithm_shouldAddDiscountMastercard() {
        val transferAmount = 80_000_00
        val cardType = "Mastercard"
        val amountOfTransfersThisMonth = 10_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(500_00, result)
    }

    @Test
    fun calculationAlgorithm_shouldNotAddDiscountMastercard() {
        val transferAmount = 74_000_00
        val cardType = "Mastercard"
        val amountOfTransfersThisMonth = 10_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }

    @Test
    fun calculationAlgorithm_shouldNotAddDiscountCardLimit() {
        val transferAmount = 180_000_00
        val cardType = "Mastercard"
        val amountOfTransfersThisMonth = 600_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }

    @Test
    fun calculationAlgorithm_shouldAddDiscountCardLimit() {
        val transferAmount = 80_000_00
        val cardType = "Mastercard"
        val amountOfTransfersThisMonth = 100_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(500_00, result)
    }

    @Test
    fun calculationAlgorithm_shouldNotAddDiscountVkPayLimit() {
        val transferAmount = 74_000_00
        val cardType = "Vk Pay"
        val amountOfTransfersThisMonth = 60_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }
}


