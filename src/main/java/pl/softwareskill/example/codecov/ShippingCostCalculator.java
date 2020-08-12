package pl.softwareskill.example.codecov;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShippingCostCalculator {

    private static final long METERS_IN_KILOMETER = 1000;

    private final long freeDeliveryMaxDistance;
    private final long fixedCostDistance;
    private final double fixedCost;
    private final double costPerKm;

    public double calculate(final long distance, final boolean userPremium) {
        if (userPremium || distance <= freeDeliveryMaxDistance) {
            return 0;
        }

        if (distance <= fixedCostDistance) {
            return fixedCost;
        }

        return fixedCost + additionalCostPerKm(distance);
    }

    private double additionalCostPerKm(long distance) {
        long additionalDistanceInKm = (distance - fixedCostDistance) / METERS_IN_KILOMETER;
        return additionalDistanceInKm * costPerKm;
    }
}
