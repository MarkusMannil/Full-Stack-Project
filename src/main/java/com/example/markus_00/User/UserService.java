package com.example.markus_00.User;

import com.example.markus_00.Sectors.Sector;
import com.example.markus_00.Web.UserDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 *  Class for frontend to backend communication
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User0> getUsers() {
        return userRepository.findAll();
    }

    /**
     * Function for checking if user with name already exists
     * @param name user's name
     * @return user if exists
     */
    public Optional<User0> getUserByName(String name) {
        return userRepository.findUser0ByName(name);
    }

    /**
     * Add new user to the user0 table
     * @param user User0
     */
    public void addNewUser(User0 user) {
        Optional<User0> find = userRepository.findUser0ByName(user.getName());
        if (find.isEmpty()) {
            userRepository.save(user);
        }
    }
    /**
     * Add new user to the user0 table
     * @param user DataTransferObject
     */
    public void addNewUser(UserDTO user) {
        Optional<User0> find = userRepository.findUser0ByName(user.getName());
        if (find.isEmpty()) {
            userRepository.save(new User0(user.getName(), user.getSelectedSectors(), user.isTerms()));
        }
    }

    /**
     * Updates user's Sectors
     * @param userDTO data transfer object
     */

    @Transactional
    public void updateUser(UserDTO userDTO) {
        User0 user = userRepository.findUser0ByName(userDTO.getName()).orElseThrow(
                () -> new IllegalStateException("Cannot update user because " + userDTO.getName() + " missing")
        );
        if (userDTO.getSelectedSectors() != null)
            user.setUserSectors(userDTO.getSelectedSectors());
        user.setTerms(userDTO.isTerms());
    }

}

