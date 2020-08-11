package pl.softwareskill.example.codecov;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FreeShipping {

    private final long maximumDistance;

    public boolean isEligible(final long distance, final boolean userPremium) {
        if (userPremium || distance <= maximumDistance) {
            return true;
        }

        return false;
    }
}
