package com.tic.vacupet.vaccines.application.search_all;

import com.tic.vacupet.vaccines.application.VaccineResponse;
import io.jkratz.mediator.core.Request;

import java.util.List;

public record SearchAllVaccinesQuery() implements Request<List<VaccineResponse>> {
}
