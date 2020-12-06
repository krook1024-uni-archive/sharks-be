package krook1024.sharksAPI.db;

import com.github.javafaker.Faker;
import krook1024.sharksAPI.shark.model.Shark;
import krook1024.sharksAPI.shark.model.SharkLevel;
import krook1024.sharksAPI.shark.repository.SharkLevelRepository;
import krook1024.sharksAPI.shark.repository.SharkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Seeder {
    @Autowired
    SharkRepository sharkRepository;

    @Autowired
    SharkLevelRepository sharkLevelRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedSharkLevels();
        seedSharks();
    }

    private void seedSharkLevels() {
        Faker faker = new Faker();
        List<SharkLevel> sharkLevels = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            SharkLevel sharkLevel = SharkLevel.builder()
                    .name(faker.name().bloodGroup())
                    .build();
            sharkLevels.add(sharkLevel);
        }

        sharkLevelRepository.saveAll(sharkLevels);
    }

    private void seedSharks() {
        Faker faker = new Faker();
        List<Shark> sharks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Shark shark = Shark.builder()
                    .name(faker.name().lastName())
                    .level(sharkLevelRepository.findById(1).get())
                    .build();
            sharks.add(shark);
        }

        sharkRepository.saveAll(sharks);
    }
}
