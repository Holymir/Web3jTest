package web.appControler;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppHandler {

    @PostMapping("/register")
    public String handlePostRequest(@RequestBody AppData appData) {
        System.out.println(appData.getData());
        return "registration-done";
    }

//    @GetMapping("/register")
//    public String openReg() {
//        System.out.println();
//        return "registerCar.html";
//
//    }
}
