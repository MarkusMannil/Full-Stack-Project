package com.example.markus_00.Web;

import com.example.markus_00.Sectors.SectorService;
import com.example.markus_00.User.User0;
import com.example.markus_00.User.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

/**
 * Class for user communication
 */
@Controller
public class WebController {
    private final UserService userService;

    private final SectorService sectorService;

    @Autowired
    public WebController(UserService userService, SectorService sectorService) {
        this.userService = userService;
        this.sectorService = sectorService;
    }

    /**
     * Function for showing form and adding sectors to the html page
     * @param model For adding variables to html
     * @return view helmes_index.html
     */
    @RequestMapping(value = "/form")
    public String showForm(Model model) {
        // add all the sectors to the model
        model.addAttribute("sectors", sectorService.getSectors());
        // for retrieving chosen sectors
        model.addAttribute("data_transfer_object", new UserDTO(new HashSet<>()));

        return "helmes_index";
    }

    /**
     * Function for getting user submitted data
     * @param userDTO for user adding and validation
     * @param bindingResult for errors with inputs
     * @param model For adding variables to html
     * @return view based on if there are errors or not
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("data_transfer_object") UserDTO userDTO,
                              BindingResult bindingResult,
                              Model model) {

        model.addAttribute("data_transfer_object", userDTO);
        model.addAttribute("sectors", sectorService.getSectors());

        // if user's name is already used
        if (userService.getUserByName(userDTO.getName()).isPresent()){
            model.addAttribute("user_exists", userDTO.getName());
            return "helmes_index";
        }
        // if there are errors with validation
        if (bindingResult.hasErrors() ) {
            return "helmes_index";
        }
        // add user to database
        userService.addNewUser(userDTO);

        return "helmes_submit";
    }

    /**
     * Function for getting edited user submitted data
     * @param userDTO for user updating and validation
     * @param bindingResult for errors with inputs
     * @param model or adding variables to html
     * @return submit view
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editForm(@Valid @ModelAttribute("data_transfer_object") UserDTO userDTO, BindingResult bindingResult, Model model) {

        model.addAttribute("data_transfer_object", userDTO);
        model.addAttribute("sectors", sectorService.getSectors());

        // if there are errors with validation
        if (bindingResult.hasErrors()) {
            return "helmes_submit";
        }
        // update users data
        userService.updateUser(userDTO);

        return "helmes_submit";
    }





}
