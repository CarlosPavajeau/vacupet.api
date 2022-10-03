package com.tic.vacupet.vaccines.application.create;

import com.tic.vacupet.vaccines.domain.Vaccine;
import com.tic.vacupet.vaccines.infrastructure.VaccineRepository;
import io.jkratz.mediator.core.CommandHandler;
import lombok.val;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CreateVaccineCommandHandler implements CommandHandler<CreateVaccineCommand> {

    private final VaccineRepository repository;

    public CreateVaccineCommandHandler(VaccineRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(@NonNull CreateVaccineCommand command) {
        val vaccine = Vaccine.builder()
                .name(command.name())
                .build();

        repository.save(vaccine);
    }
}
