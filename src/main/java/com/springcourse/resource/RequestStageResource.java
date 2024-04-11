package com.springcourse.resource;

import com.springcourse.domain.RequestStage;
import com.springcourse.service.RequestStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "request-stages")
public class RequestStageResource {

    private final RequestStageService requestStageService;

    @Autowired
    public RequestStageResource(RequestStageService requestStageService) {
        this.requestStageService = requestStageService;
    }

    @PostMapping
    public ResponseEntity<RequestStage> save(@RequestBody RequestStage requestStage) {
        RequestStage createdRequestStage = requestStageService.save(requestStage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequestStage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestStage> getById(@PathVariable(name = "id") Long id) {
        RequestStage requestStage = requestStageService.getById(id);
        return ResponseEntity.ok(requestStage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<RequestStage>> listAllByRequestId(@PathVariable(name = "id") Long id) {
        List<RequestStage> requestStages = requestStageService.listAllByRequestId(id);
        return ResponseEntity.ok(requestStages);
    }
}
