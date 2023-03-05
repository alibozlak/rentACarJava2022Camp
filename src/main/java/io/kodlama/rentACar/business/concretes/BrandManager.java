package io.kodlama.rentACar.business.concretes;

import java.util.List;

import io.kodlama.rentACar.business.requests.UpdateBrandRequest;
import io.kodlama.rentACar.business.responses.GetByIdBrandRespoonse;
import io.kodlama.rentACar.business.rules.BrandBusinessRules;
import io.kodlama.rentACar.core.utilities.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import io.kodlama.rentACar.business.abstracts.BrandService;
import io.kodlama.rentACar.business.requests.CreateBrandRequest;
import io.kodlama.rentACar.business.responses.GetAllBrandsResponse;
import io.kodlama.rentACar.dataAccess.abstracts.BrandRepository;
import io.kodlama.rentACar.entities.concretes.Brand;

@Service    // <-- Bu sınıf bir business katmanı classıdır.
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        // Business kuralları

        List<Brand> brands = brandRepository.findAll();
        /*
        List<GetAllBrandsResponse> brandsResponses = new ArrayList<>();
        for (Brand brand : brands) {
            GetAllBrandsResponse brandsResponse = new GetAllBrandsResponse();
            brandsResponse.setId(brand.getId());
            brandsResponse.setName(brand.getName());

            brandsResponses.add(brandsResponse);
        }
        */

        List<GetAllBrandsResponse> brandsResponses =
                brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
                        .toList();

        return brandsResponses;
    }

    @Override
    public GetByIdBrandRespoonse getById(int id) {
        Brand brand = this.brandRepository.getReferenceById(id);
        GetByIdBrandRespoonse getByIdBrandRespoonse =
                this.modelMapperService.forResponse().map(brand, GetByIdBrandRespoonse.class);
        return getByIdBrandRespoonse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        //Brand brand = new Brand();
        //brand.setName(createBrandRequest.getName());

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }

}
