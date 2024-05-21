package com.jesusfc.database.entity;

import lombok.*;

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
public class Name {

    private String firstName;
    private String lastName;
}
