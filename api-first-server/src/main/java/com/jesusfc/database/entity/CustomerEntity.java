package com.jesusfc.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
@Setter
@Getter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "char(36)", updatable = false, nullable = false)
    private UUID id;

    @Embedded
    private Name name;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity shipToAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity billingAddress;

    private String email;
    private String phoneNumber;

}
