package ca.tetervak.tipcalculator.domain

fun calculateTip(
    billBeforeTip: Double,
    serviceQuality: ServiceQuality = ServiceQuality.OK,
    roundUpTip: Boolean = true
): Double {
    if(billBeforeTip < 0.0){
        throw IllegalArgumentException("Negative bill value $billBeforeTip")
    }
    var tipAmount = billBeforeTip * tipPercentage(serviceQuality)
    if (roundUpTip) {
        tipAmount = kotlin.math.ceil(tipAmount)
    }
    return tipAmount
}

private fun tipPercentage(serviceQuality: ServiceQuality): Double =
    when (serviceQuality) {
        ServiceQuality.OK -> 0.15
        ServiceQuality.GOOD -> 0.18
        ServiceQuality.AMAZING -> 0.20
    }