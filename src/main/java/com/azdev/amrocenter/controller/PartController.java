package com.azdev.amrocenter.controller;


import com.azdev.amrocenter.model.Parts;
import com.azdev.amrocenter.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api/v1/part")
@RequiredArgsConstructor
public class PartController {

    private final PartService partService;

    @GetMapping("/get")
    public ResponseEntity getAllParts() {
        List<Parts> customers = partService.getAllParts();
        return ResponseEntity.status(200).body(customers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getParts(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(partService.getParts(id));
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity updateParts(@RequestBody Parts part, @PathVariable Integer id) {
        partService.updateParts(part, id);
        return ResponseEntity.status(200).body("Parts updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteParts(@PathVariable Integer id) {
        partService.deleteParts(id);
        return ResponseEntity.status(200).body("deleted");
    }
}


