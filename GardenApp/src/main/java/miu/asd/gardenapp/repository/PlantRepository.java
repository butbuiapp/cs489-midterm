package miu.asd.gardenapp.repository;

import miu.asd.gardenapp.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {
    List<Plant> findAllByOrderByName();

    List<Plant> findAllByGardenName(String gardenName);
}
