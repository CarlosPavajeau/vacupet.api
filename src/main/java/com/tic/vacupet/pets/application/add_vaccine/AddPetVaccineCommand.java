package com.tic.vacupet.pets.application.add_vaccine;

import io.jkratz.mediator.core.Command;

public record AddPetVaccineCommand(Long petId, Long vaccineId) implements Command {
}
