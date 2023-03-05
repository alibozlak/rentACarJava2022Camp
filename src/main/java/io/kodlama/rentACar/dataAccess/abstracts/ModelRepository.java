package io.kodlama.rentACar.dataAccess.abstracts;

import io.kodlama.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
