package io.kodlama.rentACar.business.concretes;

import io.kodlama.rentACar.business.abstracts.ModelService;
import io.kodlama.rentACar.business.requests.CreateModelRequest;
import io.kodlama.rentACar.business.responses.GetAllModelResponse;
import io.kodlama.rentACar.core.utilities.mappers.ModelMapperService;
import io.kodlama.rentACar.dataAccess.abstracts.ModelRepository;
import io.kodlama.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = this.modelRepository.findAll();
        List<GetAllModelResponse> getAllModelResponses =
                models.stream().map(model -> modelMapperService.forResponse().map(model, GetAllModelResponse.class))
                        .toList();
        return getAllModelResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
}
