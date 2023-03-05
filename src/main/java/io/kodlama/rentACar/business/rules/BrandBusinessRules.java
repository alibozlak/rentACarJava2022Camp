package io.kodlama.rentACar.business.rules;

import io.kodlama.rentACar.core.utilities.exceptions.BusinessException;
import io.kodlama.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String brandName){
        if (this.brandRepository.existsByName(brandName)){
            throw new BusinessException(brandName + " already exists!"); //Java exception types
        }
    }
}
