package io.kodlama.rentACar.webApi.controllers;

import io.kodlama.rentACar.business.abstracts.ModelService;
import io.kodlama.rentACar.business.requests.CreateModelRequest;
import io.kodlama.rentACar.business.responses.GetAllModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping
    public List<GetAllModelResponse> getAll(){
        return this.modelService.getAll();
    }

    @PostMapping
    public void add(@RequestBody CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
}
