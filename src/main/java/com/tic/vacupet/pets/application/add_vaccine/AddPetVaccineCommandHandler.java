package com.tic.vacupet.pets.application.add_vaccine;

import com.tic.vacupet.pets.infrastructure.PetRepository;
import com.tic.vacupet.vaccines.infrastructure.VaccineRepository;
import io.jkratz.mediator.core.CommandHandler;
import lombok.val;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class AddPetVaccineCommandHandler implements CommandHandler<AddPetVaccineCommand> {

    private final PetRepository petRepository;
    private final VaccineRepository vaccineRepository;

    public AddPetVaccineCommandHandler(PetRepository petRepository, VaccineRepository vaccineRepository) {
        this.petRepository = petRepository;
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public void handle(@NonNull AddPetVaccineCommand command) {
        val pet = petRepository.findById(command.petId()).orElseThrow();
        val vaccine = vaccineRepository.findById(command.vaccineId()).orElseThrow();

        if (pet.getVaccines().contains(vaccine)) {
            throw new IllegalArgumentException("Pet already has this vaccine");
        }

        pet.getVaccines().add(vaccine);

        petRepository.save(pet);
    }
}
