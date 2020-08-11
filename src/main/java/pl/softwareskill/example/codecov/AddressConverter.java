package pl.softwareskill.example.codecov;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class AddressConverter {

    @Value
    @Builder
    public static class Address {
        String city;
        String zipcode;
        String street;
        String number;
    }

    @Value
    @Builder
    public static class AddressDto {
        private String city;
        private String zipcode;
        private String street;
        private String number;
    }

    public static AddressDto convert(Address address) {
        return AddressDto.builder()
                .city(address.getCity())
                .zipcode(address.getZipcode())
                .street(address.getStreet())
                .number(address.getNumber())
                .build();
    }
}
