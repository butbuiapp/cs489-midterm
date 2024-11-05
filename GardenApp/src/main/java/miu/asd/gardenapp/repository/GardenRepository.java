package miu.asd.gardenapp.repository;

import miu.asd.gardenapp.model.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenRepository extends JpaRepository<Garden, Integer> {
}
