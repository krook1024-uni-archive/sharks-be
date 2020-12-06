package krook1024.sharksAPI.shark.controller;

import krook1024.sharksAPI.shark.model.Shark;
import krook1024.sharksAPI.shark.service.SharkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SharkController {
    @Autowired
    SharkService sharkService;

    @GetMapping("/shark")
    public Iterable<Shark> getAll() {
        return sharkService.getAll();
    }

    @GetMapping("/shark/{id}")
    public Shark getOne(@PathVariable int id) {
        return sharkService.getOne(id);
    }

    @PostMapping("/shark")
    public Shark createOne(@RequestBody Shark shark) {
        return sharkService.createOne(shark);
    }

    @PutMapping("/shark/{id}")
    public Shark createOne(@PathVariable int id, @RequestBody Shark shark) {
        return sharkService.updateOne(id, shark);
    }

    @DeleteMapping("/shark/{id}")
    public void deleteOne(@PathVariable int id) {
        sharkService.deleteOne(id);
    }
}
