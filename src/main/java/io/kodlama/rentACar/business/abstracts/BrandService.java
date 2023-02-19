package io.kodlama.rentACar.business.abstracts;

import java.util.List;

import io.kodlama.rentACar.business.requests.CreateBrandRequest;
import io.kodlama.rentACar.business.requests.UpdateBrandRequest;
import io.kodlama.rentACar.business.responses.GetAllBrandsResponse;
import io.kodlama.rentACar.business.responses.GetByIdBrandRespoonse;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandRespoonse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
