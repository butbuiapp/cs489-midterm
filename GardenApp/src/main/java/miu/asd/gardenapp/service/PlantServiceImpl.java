package miu.asd.gardenapp.service;

import lombok.RequiredArgsConstructor;
import miu.asd.gardenapp.model.Plant;
import miu.asd.gardenapp.repository.GardenRepository;
import miu.asd.gardenapp.repository.PlantRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {
    private final PlantRepository plantRepository;
    private final GardenRepository gardenRepository;

    @Override
    public Plant addPlant(Plant plant) {
        Plant createdPlant = plantRepository.save(plant);
        return plantRepository.findById(createdPlant.getId()).get();
    }

    @Override
    public Plant updatePlant(int id, Plant plant) {
        Optional<Plant> optionalPlant = plantRepository.findById(id);
        if (optionalPlant.isPresent()) {
            Plant existingPlant = optionalPlant.get();
            existingPlant.setName(plant.getName());
            existingPlant.setPlantDate(plant.getPlantDate());
            existingPlant.setType(plant.getType());

            // get garden
            if (plant.getGarden() != null) {
                gardenRepository.findById(plant.getGarden().getId()).ifPresentOrElse(
                        garden -> {
                            existingPlant.setGarden(garden);
                        },
                        () -> {
                            throw new RuntimeException("Garden not found");
                        }
                );
            }
            plantRepository.save(existingPlant);
            return existingPlant;
        } else {
            throw new RuntimeException("Plant not found");
        }
    }

    @Override
    public void deletePlant(int id) {
        plantRepository.findById(id).ifPresentOrElse(
                plant -> {
                    plantRepository.delete(plant);
                },
                () -> {
                    throw new RuntimeException("Plant not found");
                }
        );
    }

    @Override
    public List<Plant> getPlantsSortedByName() {
        return plantRepository.findAllByOrderByName();
    }

    @Override
    public List<Plant> getPlantsSortedByPlantDate() {
        return plantRepository.findAll(Sort.by("plantDate"));
    }

    @Override
    public List<Plant> getPlantsInGarden(String gardenName) {
        return plantRepository.findAllByGardenName(gardenName);
    }
}
