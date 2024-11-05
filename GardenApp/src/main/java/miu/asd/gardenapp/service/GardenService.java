package miu.asd.gardenapp.service;

import miu.asd.gardenapp.model.Garden;

import java.util.List;

public interface GardenService {
    Garden addGarden(Garden garden);
    Garden updateGarden(int id, Garden garden);
    void deleteGarden(int id);
    List<Garden> getAllGardens();

}
