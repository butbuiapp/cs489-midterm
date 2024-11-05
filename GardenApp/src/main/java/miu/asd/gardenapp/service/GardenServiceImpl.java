package miu.asd.gardenapp.service;

import lombok.RequiredArgsConstructor;
import miu.asd.gardenapp.model.Garden;
import miu.asd.gardenapp.repository.GardenRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GardenServiceImpl implements GardenService {
    private final GardenRepository gardenRepository;

    @Override
    public Garden addGarden(Garden garden) {
        return gardenRepository.save(garden);
    }

    @Override
    public Garden updateGarden(int id, Garden garden) {
        Optional<Garden> optionalGarden = gardenRepository.findById(id);
        if (optionalGarden.isPresent()) {
            Garden existingGarden = optionalGarden.get();
            existingGarden.setName(garden.getName());
            existingGarden.setSize(garden.getSize());
            gardenRepository.save(existingGarden);
            return existingGarden;
        } else {
            throw new RuntimeException("Garden not found");
        }
    }

    @Override
    public void deleteGarden(int id) {
        gardenRepository.findById(id).ifPresentOrElse(
                garden -> {
                    gardenRepository.delete(garden);
                },
                () -> {
                    throw new RuntimeException("Garden not found");
                }
        );
    }

    @Override
    public List<Garden> getAllGardens() {
        return gardenRepository.findAll(Sort.by("name"));
    }
}
