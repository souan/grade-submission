package lu.cnfpc.grade_submission.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lu.cnfpc.grade_submission.model.Record;


@Controller
public class RecordController {

    //ArrayList of grade POJO objects
    List<Record> records = Arrays.asList(
        new Record("Chair", new BigDecimal("20.99"), new BigDecimal("5.99")),
        new Record("Table", new BigDecimal("40.99"), new BigDecimal("8.99")),
        new Record("Couch", new BigDecimal("100.99"), new BigDecimal("105.99")),
        new Record("Fridge", new BigDecimal("200.99"), new BigDecimal("59.99")),
        new Record("Bed", new BigDecimal("150.99"), new BigDecimal("205.99"))
    );

    @GetMapping("/records")
    public String getRecords(Model model) {
        model.addAttribute("records", records);
        return "records";
    }
    
}
