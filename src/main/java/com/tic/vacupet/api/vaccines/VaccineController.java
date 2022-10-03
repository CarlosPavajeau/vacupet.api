package com.tic.vacupet.api.vaccines;

import com.tic.vacupet.vaccines.application.VaccineResponse;
import com.tic.vacupet.vaccines.application.create.CreateVaccineCommand;
import com.tic.vacupet.vaccines.application.search_all.SearchAllVaccinesQuery;
import io.jkratz.mediator.core.Mediator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccines")
@CrossOrigin
public class VaccineController {

    private final Mediator mediator;

    public VaccineController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody CreateVaccineCommand command) {
        mediator.dispatch(command);

        return ResponseEntity.ok(true);
    }

    @GetMapping
    public ResponseEntity<List<VaccineResponse>> getAll() {
        var query = new SearchAllVaccinesQuery();
        var vaccines = mediator.dispatch(query);

        return ResponseEntity.ok(vaccines);
    }
}
