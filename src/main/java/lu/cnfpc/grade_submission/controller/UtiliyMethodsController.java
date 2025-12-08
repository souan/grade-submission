package lu.cnfpc.grade_submission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UtiliyMethodsController {
    @GetMapping("/utility_method")
    public String getUtil_Method(Model model) {
        model.addAttribute("menu", "We sell chocolate drinks with bubbles");
        model.addAttribute("name", "Victor");
        return "utility_method";
    }
    
}
