package pl.softwareskill.example.codecov;

import lombok.RequiredArgsConstructor;

import static pl.softwareskill.example.codecov.UserType.Premium;

@RequiredArgsConstructor
public class ShippingCostCalculator {

    private static final long METERS_IN_KILOMETER = 1000;

    private final long freeDeliveryMaxDistance;
    private final long fixedCostDistance;
    private final double fixedCost;
    private final double costPerKm;

    public double calculate(final long distanceInMeters, final UserType userType) {
        if (userType == Premium || distanceInMeters <= freeDeliveryMaxDistance) {
            return 0;
        }

        if (distanceInMeters <= fixedCostDistance) {
            return fixedCost;
        }

        return fixedCost + additionalCostPerKm(distanceInMeters);
    }

    private double additionalCostPerKm(long distanceInMeters) {
        long additionalDistanceInKm = (distanceInMeters - fixedCostDistance) / METERS_IN_KILOMETER;
        return additionalDistanceInKm * costPerKm;
    }
}
