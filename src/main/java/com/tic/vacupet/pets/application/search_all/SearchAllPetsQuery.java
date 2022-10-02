package com.tic.vacupet.pets.application.search_all;

import com.tic.vacupet.pets.application.PetResponse;
import io.jkratz.mediator.core.Request;

import java.util.List;

public record SearchAllPetsQuery() implements Request<List<PetResponse>> {
}
