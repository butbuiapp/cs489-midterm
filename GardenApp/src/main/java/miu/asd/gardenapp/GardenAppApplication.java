package miu.asd.gardenapp;

import lombok.RequiredArgsConstructor;
import miu.asd.gardenapp.model.Garden;
import miu.asd.gardenapp.model.Plant;
import miu.asd.gardenapp.service.GardenService;
import miu.asd.gardenapp.service.PlantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class GardenAppApplication {
    private final GardenService gardenService;
    private final PlantService plantService;

    public static void main(String[] args) {
        SpringApplication.run(GardenAppApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
//            // create garden
//            Garden g = Garden.builder()
//                    .name("Herb Garden")
//                    .size(20)
//                    .build();
//            Garden createdGarden = gardenService.addGarden(g);
//            System.out.println(createdGarden);

            // update garden
//            Garden g2 = new Garden(3, "Herb Garden", 30);
//            Garden updatedGarden = gardenService.updateGarden(3, g2);
//            System.out.println(updatedGarden);

            // get all gardens sorted by name
//            List<Garden> gardens = gardenService.getAllGardens();
//            gardens.stream().forEach(System.out::println);

            // delete garden
//            gardenService.deleteGarden(3);
//
//            List<Garden> gardens = gardenService.getAllGardens();
//            gardens.stream().forEach(System.out::println);

            // create plant
//            Garden garden = Garden.builder().id(4).build();
//            Plant plant = Plant.builder()
//                    .name("Mint")
//                    .type("Herb")
//                    .plantDate(LocalDate.of(2024, 3, 12))
//                    .garden(garden)
//                    .build();
//            Plant createdPlant = plantService.addPlant(plant);
//            System.out.println(createdPlant);

            // update tomato
//            Plant tomato = Plant.builder()
//                    .id(1)
//                    .name("Tomato")
//                    .type("Fruit")
//                    .plantDate(LocalDate.of(2024, 3, 10))
//                    .build();
//
//            Plant updatedPlant = plantService.updatePlant(1, tomato);
//            System.out.println(updatedPlant);

            // get plants sorted by name
//            List<Plant> plants = plantService.getPlantsSortedByName();
//            plants.stream().forEach(System.out::println);

            // get plants sorted by plantDate
//            List<Plant> plants = plantService.getPlantsSortedByPlantDate();
//            plants.stream().forEach(System.out::println);

            // delete mint
//            plantService.deletePlant(4);
//            List<Plant> plants = plantService.getPlantsSortedByPlantDate();
//            plants.stream().forEach(System.out::println);

            // get plants in a garden
            List<Plant> plants = plantService.getPlantsInGarden("Vegetable Patch");
            plants.stream().forEach(System.out::println);
        };
    }
}
