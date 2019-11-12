package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.view.CountAnimals;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    Animal findByAnimaltype(String type);

    @Query(value = "SELECT a.animaltype, COUNT(*) FROM zooanimals z JOIN animal a ON a.animalid = z.animalid GROUP BY a.animaltype", nativeQuery = true)
    ArrayList<CountAnimals> getCountAnimals();
}
