package lu.cnfpc.grade_submission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ConditionsController {
    
    @GetMapping("/conditions")
    public String getConditions(Model model) {
        model.addAttribute("sales", 20);
        model.addAttribute("product", "chair");
        return "conditions";
    }
    

}
