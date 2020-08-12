package pl.softwareskill.example.codecov;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FreeShippingTest {

    private final long MAX_DISTANCE = 50_000;
    private final long FAR_DISTANCE = MAX_DISTANCE + 1;
    private final long NEAR_DISTANCE = MAX_DISTANCE;

    FreeShipping freeShipping = new FreeShipping(MAX_DISTANCE);

    @Test
    void freeShippingForPremiumRegardlessDistance() {
        assertThat(freeShipping.isEligible(FAR_DISTANCE, UserType.Premium))
                .isTrue();
    }

    @Test
    void paidShippingAboveTreshold() {
        assertThat(freeShipping.isEligible(FAR_DISTANCE, UserType.Regular))
                .isFalse();
    }

//    @Test
//    void freeShippingBelowTreshold() {
//        assertThat(freeShipping.isEligible(NEAR_DISTANCE, UserType.Regular))
//                .isTrue();
//    }
//
//    @Test
//    void freeShippingBelowTresholdForPremium() {
//        assertThat(freeShipping.isEligible(NEAR_DISTANCE, UserType.Premium))
//                .isTrue();
//    }
}
