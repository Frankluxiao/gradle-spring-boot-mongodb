package com.wanderlust.app.entity;

import dev.morphia.annotations.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embedded
public class Address {

    private String street;
    private String town;
    private String state;
    private String postcode;
}
