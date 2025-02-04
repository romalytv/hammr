package proj.hammr.hammr.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMethodName(Model model) {
        model.addAttribute("allUserList", userService.getAllUser());
        return "auth";
    }
    

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<String> saveUser(@RequestBody UserEntity user) {
        userService.save(user);
        return ResponseEntity.ok("user saved");
    }

    

}
