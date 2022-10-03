package com.tic.vacupet.pets.application;

import com.tic.vacupet.vaccines.application.VaccineResponse;

import java.util.List;

public record PetResponse(
        Long id,
        String breed,
        String name,
        String birthDate,
        boolean hasChip,
        boolean hasMedicalRecord,
        boolean hasAllergies,
        String observations,
        OwnerResponse owner,
        List<VaccineResponse> vaccines) {
}
