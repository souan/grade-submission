package lu.cnfpc.grade_submission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SpeedController {
    @GetMapping("/speed_limit")
    public String getSpeedLimit(Model model) {
        model.addAttribute("speed", 90);
        return "sign";
    }
       
}
