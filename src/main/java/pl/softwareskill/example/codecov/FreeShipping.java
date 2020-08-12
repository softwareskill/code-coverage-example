package pl.softwareskill.example.codecov;

import lombok.RequiredArgsConstructor;

import static pl.softwareskill.example.codecov.UserType.Premium;

@RequiredArgsConstructor
public class FreeShipping {

    private final long maximumDistance;

    public boolean isEligible(final long distance, final UserType userType) {
        if (userType == Premium || distance <= maximumDistance) {
            return true;
        }

        return false;
    }
}
