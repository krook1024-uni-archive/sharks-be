package krook1024.sharksAPI.user.controller;

import krook1024.sharksAPI.exception.CustomException;
import krook1024.sharksAPI.user.dto.UserDTO;
import krook1024.sharksAPI.user.model.User;
import krook1024.sharksAPI.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/name/{name}")
    public UserDTO getOneByName(@PathVariable String name) {
        return convertToDTO(userService.findByUsername(name));
    }

    @PostMapping("/user/register")
    public UserDTO saveOne(@RequestBody User user) {
        return convertToDTO(userService.saveOne(user));
    }

    @GetMapping("/user")
    public List<UserDTO> getAll() {
        return StreamSupport.stream(userService.getAll().spliterator(), false)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/user/{id}")
    public UserDTO getOne(@PathVariable String id) {
        try {
            int id_ = Integer.parseInt(id);
            return convertToDTO(userService.getOne(id_));
        } catch (Exception e) {
             throw new CustomException("Id is not a number", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user")
    public UserDTO createOne(@RequestBody User user) {
        return convertToDTO(userService.saveOne(user));
    }

    @PutMapping("/user/{id}")
    public UserDTO updateOne(@PathVariable int id, @RequestBody User user) {
        return convertToDTO(userService.updateOne(id, user));
    }

    @DeleteMapping("/user/{id}")
    public void deleteOne(@PathVariable int id) {
        userService.deleteOne(id);
    }

    private UserDTO convertToDTO(User u) {
        ModelMapper mm = new ModelMapper();
        return mm.map(u, UserDTO.class);
    }
}
