package io.kodlama.rentACar.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
// import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "brands")
// @Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    
    private int id;
    private String name;
    
}
