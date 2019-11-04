package com.wanderlust.app.entity;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;
import lombok.*;


import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @Property("_id")
    private UUID employeeId;
    private String employName;
    private String position;
    private LocalDateTime creationTime;
    @Embedded
    private Address address;
}
