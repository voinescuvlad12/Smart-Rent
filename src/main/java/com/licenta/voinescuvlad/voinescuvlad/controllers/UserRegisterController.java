package com.licenta.voinescuvlad.voinescuvlad.controllers;

import com.licenta.voinescuvlad.voinescuvlad.controllers.dto.UserRegistrationDto;
import com.licenta.voinescuvlad.voinescuvlad.entities.User;
import com.licenta.voinescuvlad.voinescuvlad.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegisterController {

    @Autowired
    private EmailController emailService;

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {

        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model theModel) {

        UserRegistrationDto usertDto = new UserRegistrationDto();
        if(!theModel.containsAttribute("user")){
            theModel.addAttribute("user", usertDto);
        }
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto user,
                                      BindingResult result, RedirectAttributes attr) {

        User existing = userService.findByUsername(user.getUserName());
        if (existing != null) {

            return "errorRegistrationPage";
        }
        if (result.hasErrors()) {

            attr.addFlashAttribute("org.springframework.validation.BindingResult.user",
                    result);
            attr.addFlashAttribute("user", user);
            return "redirect:/registration";
        }

        try {
            emailService.sendHelloEmail(user.getEmail(), user.getUserName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        userService.save(user);

        return "redirect:/login";
    }

}
