package krook1024.sharksAPI.shark.service;

import krook1024.sharksAPI.exception.CustomException;
import krook1024.sharksAPI.shark.model.Shark;
import krook1024.sharksAPI.shark.repository.SharkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SharkService {
    @Autowired
    private SharkRepository sharkRepository;

    public Iterable<Shark> getAll() {
        return sharkRepository.findAll();
    }

    public Shark getOne(int id) {
        Optional<Shark> shark = sharkRepository.findById(id);

        if (!shark.isPresent()) {
            throw new CustomException("Shark cannot be found", HttpStatus.NOT_FOUND);
        }

        return shark.get();
    }

    public Shark createOne(Shark shark) {
        try {
            shark = sharkRepository.save(shark);
            return shark;
        } catch (Exception e) {
            throw new CustomException("An unknown error happened", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Shark updateOne(int id, Shark shark) {
        Shark currentShark = getOne(id);

        currentShark.setName(shark.getName());
        currentShark.setSharkLevelId(shark.getSharkLevelId());

        currentShark = sharkRepository.save(currentShark);

        return currentShark;
    }

    public void deleteOne(int id) {
        Shark shark = getOne(id);

        sharkRepository.delete(shark);
    }
}
