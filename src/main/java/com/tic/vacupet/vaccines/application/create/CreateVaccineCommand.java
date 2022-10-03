package com.tic.vacupet.vaccines.application.create;

import io.jkratz.mediator.core.Command;

public record CreateVaccineCommand(String name) implements Command {
}
