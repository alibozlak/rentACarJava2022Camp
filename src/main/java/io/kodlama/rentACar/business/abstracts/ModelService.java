package io.kodlama.rentACar.business.abstracts;

import io.kodlama.rentACar.business.requests.CreateModelRequest;
import io.kodlama.rentACar.business.responses.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
