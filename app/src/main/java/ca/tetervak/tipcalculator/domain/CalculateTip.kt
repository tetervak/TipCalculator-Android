package ca.tetervak.tipcalculator.domain

fun calculateTip(
    billBeforeTip: Double,
    serviceQuality: ServiceQuality = ServiceQuality.OK,
    roundUpTip: Boolean = true
): Double =
    calculateTip(
        billBeforeTip = billBeforeTip,
        tipPercent = tipForServiceQuality(serviceQuality).toDouble(),
        roundUp = roundUpTip
    )

fun calculateTip(
    billBeforeTip: Double,
    tipPercent: Double = 15.0,
    roundUp: Boolean = true
): Double{
    if(billBeforeTip < 0.0){
        throw  IllegalArgumentException("Negative bill value $billBeforeTip")
    }
    if(tipPercent < 0.0){
        throw  IllegalArgumentException("Negative tip percent $tipPercent")
    }
    var tip = billBeforeTip * tipPercent / 100
    if(roundUp){
        tip = kotlin.math.ceil(tip)
    }
    return tip
}

fun tipForServiceQuality(serviceQuality: ServiceQuality): Int =
    when (serviceQuality) {
        ServiceQuality.OK -> 15
        ServiceQuality.GOOD -> 18
        ServiceQuality.AMAZING -> 20
    }