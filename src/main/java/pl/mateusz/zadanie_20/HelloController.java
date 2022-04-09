package pl.mateusz.zadanie_20;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class HelloController {

    private UserRepository userRepository;

    public HelloController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    User user1 = new User("Mateusz", "Solecki", 25);
    User user2 = new User("Kamil", "Kowalski", 28);
    User user3 = new User("Mariola", "Kaczyńska", 36);

    @RequestMapping("/add")
    public String hello(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer age) {

        if (firstName.equals("")) {
            return "redirect:/err.html";
        } else {
            User user = new User(firstName, lastName, age);
            userRepository.add(user);
            return "redirect:/success.html";
        }
    }

    @ResponseBody
    @RequestMapping("/users")
    public String list() {
        userRepository.add(user1);
        userRepository.add(user2);
        userRepository.add(user3);

        List<User> userList = userRepository.getAll();
        String result = "";
        for (User user4 : userList) {
            result += user4.getFirstName() + " " + user4.getLastName() + " wiek: " + user4.getAge() + " lat" + "<br/>";
        }
        return result;
    }
}
