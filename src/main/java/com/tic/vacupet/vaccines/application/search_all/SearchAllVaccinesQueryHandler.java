package com.tic.vacupet.vaccines.application.search_all;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tic.vacupet.vaccines.application.VaccineResponse;
import com.tic.vacupet.vaccines.infrastructure.VaccineRepository;
import io.jkratz.mediator.core.RequestHandler;
import lombok.val;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchAllVaccinesQueryHandler implements RequestHandler<SearchAllVaccinesQuery, List<VaccineResponse>> {

    private final VaccineRepository repository;
    private final ObjectMapper mapper;

    public SearchAllVaccinesQueryHandler(VaccineRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<VaccineResponse> handle(@NonNull SearchAllVaccinesQuery query) {
        val vaccines = repository.findAll();

        return mapper.convertValue(vaccines, new TypeReference<>() {
        });
    }
}
