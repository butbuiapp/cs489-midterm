package miu.asd.gardenapp.service;

import miu.asd.gardenapp.model.Plant;

import java.util.List;

public interface PlantService {
    Plant addPlant(Plant plant);
    Plant updatePlant(int id, Plant plant);
    void deletePlant(int id);
    List<Plant> getPlantsSortedByName();
    List<Plant> getPlantsSortedByPlantDate();

    List<Plant> getPlantsInGarden(String gardenName);
}
