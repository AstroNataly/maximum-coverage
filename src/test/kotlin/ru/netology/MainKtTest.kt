package ru.netology

import calculationAlgorithm
import cardCommissionSize
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculationAlgorithm_shouldAddCommission() {
        val transferAmount = 60_000_00
        val cardType = "Visa"
        val amountOfTransfersThisMonth = 10_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(450_00, result)
    }

    @Test
    fun calculationAlgorithm_shouldNotAddCommission() {
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
    fun calculationAlgorithm_shouldAddCommissionVisa() {
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
    fun calculationAlgorithm_shouldCommissionVisa_min() {
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
    fun calculationAlgorithm_shouldAddCommissionWorld() {
        val transferAmount = 50_000_00
        val cardType = "Мир"
        val amountOfTransfersThisMonth = 120_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(375_00, result)
    }

    @Test
    fun calculationAlgorithm_shouldAddCommissionWorld_min() {
        val transferAmount = 300_00
        val cardType = "Мир"
        val amountOfTransfersThisMonth = 120_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(35_00, result)
    }

    @Test
    fun calculationAlgorithm_shouldAddCommissionMaestro() {
        val transferAmount = 80_000_00
        val cardType = "Maestro"
        val amountOfTransfersThisMonth = 10_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(500_00, result)
    }

    @Test
    fun calculationAlgorithm_shouldNotAddCommissionMaestro() {
        val transferAmount = 74_000_00
        val cardType = "Maestro"
        val amountOfTransfersThisMonth = 10_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }

    @Test
    fun calculationAlgorithm_shouldAddCommissionMastercard() {
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
    fun calculationAlgorithm_shouldNotAddCommissionMastercard() {
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
    fun calculationAlgorithm_shouldNotAddCommissionCardCurrentLimit() {
        val transferAmount = 180_000_00
        val cardType = "Mastercard"
        val amountOfTransfersThisMonth = 600_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }

    @Test
    fun calculationAlgorithm_shouldNotAddDiscountCardMonthLimit() {
        val transferAmount = 18_880_00
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
    fun calculationAlgorithm_shouldAddDiscountCardCurrentLimit() {
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
    fun calculationAlgorithm_shouldAddDiscountCardMonthLimit() {
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
    fun calculationAlgorithm_shouldNotAddDiscountVkPayCurrentLimit() {
        val transferAmount = 74_000_00
        val cardType = "Vk Pay"
        val amountOfTransfersThisMonth = 0

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }

    @Test
    fun calculationAlgorithm_shouldNotAddDiscountVkPayMonthLimit() {
        val transferAmount = 740_00
        val cardType = "Vk Pay"
        val amountOfTransfersThisMonth = 60_000_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }

    @Test
    fun calculationAlgorithm_shouldNotAddDiscountVkPay() {
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

    @Test
    fun calculationAlgorithm_shouldAddDiscountVkPayCurrentLimit() {
        val transferAmount = 74_00
        val cardType = "Vk Pay"
        val amountOfTransfersThisMonth = 0

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }

    @Test
    fun calculationAlgorithm_shouldAddDiscountVkPayMonthLimit() {
        val transferAmount = 740_00
        val cardType = "Vk Pay"
        val amountOfTransfersThisMonth = 39_000_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }


    @Test
    fun calculationAlgorithm_shouldNotAddDiscountTElseCardType() {
        val transferAmount = 74_000_00
        val cardType = "ghffhgfhj"
        val amountOfTransfersThisMonth = 10_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }

    @Test
    fun calculationAlgorithm_shouldNotAddDiscountTElseCardTypeLimit() {
        val transferAmount = 180_000_00
        val cardType = "ghffhgfhj"
        val amountOfTransfersThisMonth = 10_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }

    @Test
    fun calculationAlgorithm_shouldNotAddDiscountTElseCardTypeMonthLimit() {
        val transferAmount = 180_00
        val cardType = "ghffhgfhj"
        val amountOfTransfersThisMonth = 100_010_00

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }

    @Test
    fun calculationAlgorithm_shouldNotDiscount() {
        val transferAmount = - 1
        val cardType = " "
        val amountOfTransfersThisMonth = 0

        val result = calculationAlgorithm(
            currentTransferAmount = transferAmount,
            accountCardType = cardType,
            previousAmountOfTransfersThisMonth = amountOfTransfersThisMonth
        )
        assertEquals(0, result)
    }



}


