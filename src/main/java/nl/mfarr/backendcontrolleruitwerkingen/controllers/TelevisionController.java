package nl.mfarr.backendcontrolleruitwerkingen.controllers;
import nl.mfarr.backendcontrolleruitwerkingen.model.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
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
        var optionalTelevision = findCarById(id);
        if (optionalTelevision==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalTelevision);
    }
    private Television findCarById(Long id) {
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


}