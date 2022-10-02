package com.tic.vacupet.pets.application;

public record PetResponse(Long id, String breed, String name, String birthDate, boolean hasChip, boolean hasMedicalRecord, boolean hasAllergies, String observations, OwnerResponse owner) {
}
