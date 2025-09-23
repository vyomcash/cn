package com.vit.result_system.controller;

import com.vit.result_system.model.Result;
import com.vit.result_system.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/results")
@CrossOrigin(origins = "http://localhost:3000") // Allows requests from React frontend
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    // Endpoint to add a new student's result
    @PostMapping("/add")
    public Result addResult(@RequestBody Result result) {
        return resultRepository.save(result);
    }

    // Endpoint to get a student's result by registration number
    @GetMapping("/{regNo}")
    public ResponseEntity<?> getResultByRegNo(@PathVariable String regNo) {
        return resultRepository.findByRegNo(regNo)
                .map(result -> {
                    // Calculate final marks and grade on the fly
                    Map<String, Object> response = new HashMap<>();
                    response.put("studentName", result.getStudentName());
                    response.put("regNo", result.getRegNo());

                    // Subject 1
                    double sub1Total = (result.getSub1_mse() * 0.3) + (result.getSub1_ese() * 0.7);
                    response.put("sub1_total", sub1Total);

                    // Subject 2
                    double sub2Total = (result.getSub2_mse() * 0.3) + (result.getSub2_ese() * 0.7);
                    response.put("sub2_total", sub2Total);
                    
                    // Subject 3
                    double sub3Total = (result.getSub3_mse() * 0.3) + (result.getSub3_ese() * 0.7);
                    response.put("sub3_total", sub3Total);
                    
                    // Subject 4
                    double sub4Total = (result.getSub4_mse() * 0.3) + (result.getSub4_ese() * 0.7);
                    response.put("sub4_total", sub4Total);

                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}