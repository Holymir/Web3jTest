package web.appControler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppHandler {


    @PostMapping("/register")
    public String handlePostRequest(@RequestBody AppData appData) {
        System.out.println();
        //appDataService.saveAppData(appData);
        return "registration-done";
    }

//    @PostMapping("/register")
//    public ResponseEntity reg() {
//        AppData appData = new AppData();
//        appData.setData("kur");
//        return ResponseEntity.ok().build();
//    }
//    @GetMapping("/register")
//    public String openReg() {
//        System.out.println();
//        return "registerCar.html";
//
//    }
}
