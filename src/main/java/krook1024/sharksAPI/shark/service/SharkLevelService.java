package krook1024.sharksAPI.shark.service;

import krook1024.sharksAPI.exception.CustomException;
import krook1024.sharksAPI.shark.model.SharkLevel;
import krook1024.sharksAPI.shark.repository.SharkLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SharkLevelService {
    @Autowired
    SharkLevelRepository sharkLevelRepository;

    public Iterable<SharkLevel> getAll() {
        return sharkLevelRepository.findAll();
    }

    public Iterable<SharkLevel> getAllByIds(Iterable<Integer> ids) {
        return sharkLevelRepository.findAllById(ids);
    }

    public SharkLevel getOne(int id) {
        Optional<SharkLevel> sharkLevel = sharkLevelRepository.findById(id);

        if (!sharkLevel.isPresent()) {
            throw new CustomException("Sharklevel not found", HttpStatus.NOT_FOUND);
        }

        return sharkLevel.get();
    }

    public SharkLevel createOne(SharkLevel sharkLevel) {
        return sharkLevelRepository.save(sharkLevel);
    }

    public SharkLevel updateOne(int id, SharkLevel sharkLevel) {
        SharkLevel currentSharkLevel = getOne(id);

        currentSharkLevel.setName(sharkLevel.getName());

        return sharkLevelRepository.save(currentSharkLevel);
    }

    public void deleteOne(int id) {
        SharkLevel sharkLevel = getOne(id);

        sharkLevelRepository.delete(sharkLevel);
    }
}
