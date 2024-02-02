package nl.mfarr.backendcontrolleruitwerkingen.controller;
import nl.mfarr.backendcontrolleruitwerkingen.model.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}