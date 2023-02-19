package io.kodlama.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdBrandRespoonse {
    private int id;
    private String name;
}
