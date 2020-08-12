package pl.softwareskill.example.codecov;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddressConverterTest {

    @Test
    void convertsAddressToDto() {
        AddressConverter.Address address = AddressConverter.Address.builder()
                .city("Warsaw")
                .zipcode("00-000")
                .street("a")
                .number("123")
                .build();

        AddressConverter.AddressDto dto = AddressConverter.convert(address);

        assertThat(dto.getCity()).isEqualTo(address.getCity());
        assertThat(dto.getStreet()).isEqualTo(address.getStreet());
        assertThat(dto.getNumber()).isEqualTo(address.getNumber());
        //assertThat(dto.getZipcode()).isEqualTo(address.getZipcode());
    }

}