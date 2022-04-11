package pl.mateusz.zadanie20;

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
        userRepository.add(new User("Kamil", "Kowalski", 24));
        userRepository.add(new User("Mateusz", "Solecki", 29));
        userRepository.add(new User("Monika", "Nowak", 32));
    }

    @RequestMapping("/add")
    public String hello(@RequestParam(required = false, defaultValue = "") String imie,
                        @RequestParam String nazwisko, @RequestParam Integer wiek) {

        if (imie.equals("")) {
            return "redirect:/err.html";
        } else {
            User user = new User(imie, nazwisko, wiek);
            userRepository.add(user);
            return "redirect:/success.html";
        }
    }

    @ResponseBody
    @RequestMapping("/users")
    public String list() {
        List<User> userList = userRepository.getAll();
        String result = "";
        for (User user4 : userList) {
            result += user4.getFirstName() + " " + user4.getLastName() + " wiek: " + user4.getAge() + " lat" + "<br/>";
        }
        return result;
    }
}
