package nl.mfarr.backendcontrolleruitwerkingen.controllers;
import nl.mfarr.backendcontrolleruitwerkingen.model.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/televisions")
public class TelevisionController {
    private Long currentId = 1L;
    private List<Television> televisionList = new ArrayList<Television>();

    @PostMapping
    public ResponseEntity<Television> createTelevision(@RequestBody Television television) {
        television.setId(currentId++);
        televisionList.add(television);
        return ResponseEntity.status(HttpStatus.CREATED).body(television);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable Long id){
        var optionalTelevision = findTelevisionById(id);
        if (optionalTelevision==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalTelevision);
    }
    private Television findTelevisionById(Long id) {
        for (Television television : televisionList) {
            if (television.getId().equals(id)) {
                return television;
            }
        }
        return null;
    }
    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions() {
        List<Television> allTelevisions = getAllTelevisionsFromList();

        if (allTelevisions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(allTelevisions);
    }

    private List<Television> getAllTelevisionsFromList() {
        return televisionList;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television television) {
        var existingTelevision = findTelevisionById(id);
        if (existingTelevision==null) {
            return ResponseEntity.notFound().build();
        }
        existingTelevision.setType(television.getType());
        existingTelevision.setName(television.getName());
        existingTelevision.setBrand(television.getBrand());
        existingTelevision.setPrice(television.getPrice());
        existingTelevision.setOriginalStock(television.getOriginalStock());
        existingTelevision.setSold(television.getSold());
        //geen idee hoe ik de Options lijst update feature zou moeten schrijven. Want deze bevat een lijst van objecten.//
        return ResponseEntity.ok(existingTelevision);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable Long id) {
        var existingTelevision = findTelevisionById(id);
        if (existingTelevision==null) {
            return ResponseEntity.notFound().build();
        }
        televisionList.remove(existingTelevision);
        return ResponseEntity.noContent().build();
    }




}