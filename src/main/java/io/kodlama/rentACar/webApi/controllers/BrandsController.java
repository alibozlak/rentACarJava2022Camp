package io.kodlama.rentACar.webApi.controllers;

import java.util.List;

import io.kodlama.rentACar.business.requests.UpdateBrandRequest;
import io.kodlama.rentACar.business.responses.GetByIdBrandRespoonse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.kodlama.rentACar.business.abstracts.BrandService;
import io.kodlama.rentACar.business.requests.CreateBrandRequest;
import io.kodlama.rentACar.business.responses.GetAllBrandsResponse;

import javax.validation.Valid;

@RestController     // <--- Annotation (Bilgilendirme)
@RequestMapping("/api/brands")
public class BrandsController {
    
    private BrandService brandService;

    // @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<GetAllBrandsResponse> getAll() {
        return this.brandService.getAll();
    }

    @GetMapping(path = "/get-by-id/{id}")
    public GetByIdBrandRespoonse getById(@PathVariable int id){
        return this.brandService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping(path = "/delete-by-id/{id}")
    public void deleteById(@PathVariable int id){
        this.brandService.delete(id);
    }
    
}
