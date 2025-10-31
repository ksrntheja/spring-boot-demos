package io.theja.saga.orchestrator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.theja.saga.orchestrator.service.SagaService;
import io.theja.saga.orchestrator.dto.OrderRequest;

// TODO 06: Add controller.
@RestController
@RequestMapping("/sagas")
public class SagaController {

    private final SagaService saga;

    public SagaController(SagaService saga) {
        this.saga = saga;
    }

    @PostMapping
    public ResponseEntity<String> startSaga(@RequestBody OrderRequest req) {
        try {
            saga.process(req);
            return ResponseEntity.ok("Saga completed successfully");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Saga failed: " + e.getMessage());
        }
    }

}
