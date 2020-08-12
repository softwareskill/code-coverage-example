package pl.softwareskill.example.codecov;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShippingCostCalculatorTest {

    private final long FREE_MAX_DISTANCE = 50_000;
    private final long FIXED_COST_DISTANCE = 100_000;
    private final double COST_FIXED = 10;
    private final double COST_PER_KM = 0.2;

    private final long FAR_DISTANCE = FREE_MAX_DISTANCE + 1;

    ShippingCostCalculator shippingCostCalculator = new ShippingCostCalculator(FREE_MAX_DISTANCE, FIXED_COST_DISTANCE, COST_FIXED, COST_PER_KM);

    @Test
    void freeShippingForPremiumRegardlessDistance() {
        assertThat(shippingCostCalculator.calculate(FAR_DISTANCE, true))
                .isZero();
    }

    // ...
//    @Test
//    void freeShippingBelowFreeDeliveryDistance() {
//        assertThat(shippingCostCalculator.calculate(FREE_MAX_DISTANCE, false))
//                .isZero();
//    }
    // ...

    @Test
    void belowFixedCostDistance() {
        long belowFixedCostDistance = FIXED_COST_DISTANCE - 10_000;
        assertThat(shippingCostCalculator.calculate(belowFixedCostDistance, false))
                .isEqualTo(COST_FIXED);
    }

    // ...
    // nothing changes, out algorithm covers that
//    @Test
//    void atFixedCostDistance() {
//        long atFixedCostDistance = FIXED_COST_DISTANCE;
//        assertThat(shippingCostCalculator.calculate(atFixedCostDistance, false))
//                .isEqualTo(COST_FIXED);
//    }
    // ...

    @Test
    void pricePerKmIsAddedForBreachedFixedDistance() {
        long breachedDistanceKm = 10;
        long breachedDistance = breachedDistanceKm * 1_000;
        long distance = FIXED_COST_DISTANCE + breachedDistance;
        assertThat(shippingCostCalculator.calculate(distance, false))
                .isEqualTo(COST_FIXED + (COST_PER_KM * breachedDistanceKm));
    }
}
