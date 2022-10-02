package com.tic.vacupet.pets.application.search_all;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tic.vacupet.pets.application.PetResponse;
import com.tic.vacupet.pets.infrastructure.PetRepository;
import io.jkratz.mediator.core.RequestHandler;
import lombok.val;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchAllPetsQueryHandler implements RequestHandler<SearchAllPetsQuery, List<PetResponse>> {

    private final PetRepository repository;
    private final ObjectMapper mapper;

    public SearchAllPetsQueryHandler(PetRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PetResponse> handle(@NonNull SearchAllPetsQuery query) {
        val pets = repository.findAll();

        return mapper.convertValue(pets, new TypeReference<>() {
        });
    }
}
