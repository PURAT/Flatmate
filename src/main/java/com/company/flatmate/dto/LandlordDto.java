package com.company.flatmate.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class LandlordDto {

    private UUID id;

    private UUID apartmentId;

    private UUID userId;
}
