package krook1024.sharksAPI.shark.controller;

import krook1024.sharksAPI.shark.model.SharkLevel;
import krook1024.sharksAPI.shark.service.SharkLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SharkLevelController {
    @Autowired
    SharkLevelService sharkLevelService;

    @GetMapping("/sharklevel")
    public Iterable<SharkLevel> getAll() {
        return sharkLevelService.getAll();
    }

    @GetMapping("/sharklevel/{id}")
    public SharkLevel getOne(@PathVariable int id) {
        return sharkLevelService.getOne(id);
    }

    @PostMapping("/sharklevel")
    public SharkLevel createOne(@RequestBody SharkLevel sharklevel) {
        return sharkLevelService.createOne(sharklevel);
    }

    @PutMapping("/sharklevel/{id}")
    public SharkLevel createOne(@PathVariable int id, @RequestBody SharkLevel sharkLevel) {
        return sharkLevelService.updateOne(id, sharkLevel);
    }

    @DeleteMapping("/sharklevel/{id}")
    public void deleteOne(@PathVariable int id) {
        sharkLevelService.deleteOne(id);
    }
}
