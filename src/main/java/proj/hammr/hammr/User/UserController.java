package proj.hammr.hammr.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String userView(Model model) {
        model.addAttribute("allUserList", userService.getAllUser());
        return "home";
    }

    @RequestMapping(value = "createuser", method = RequestMethod.GET)
    public String createUser(Model model) {
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        return "createuser";
    }
    
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") UserEntity user) {
        userService.save(user);
        return "redirect:/home";
    }

    @RequestMapping(value = "updateuser/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable(value="id") long id, Model model) {
        UserEntity userToUpdate = userService.getById(id);
        model.addAttribute("user", userToUpdate);
        return "updateuser";
    }
    
    
    @RequestMapping(value = "deleteuser/{id}", method=RequestMethod.DELETE)
    public String deleteUserThroughId(@PathVariable(value="id") long id, Model model) {
        userService.deleteUserById(id);
        return "redirect:/home";
    }
    

    

}
