package me.pedrokaua.narutoapi.controllers;

import jakarta.validation.Valid;
import me.pedrokaua.narutoapi.exceptions.CharacterAlreadyExistsException;
import me.pedrokaua.narutoapi.exceptions.CharacterNotFoundException;
import me.pedrokaua.narutoapi.exceptions.UpdateCharacterException;
import me.pedrokaua.narutoapi.models.entities.NarutoCharacter;
import me.pedrokaua.narutoapi.models.services.NarutoCharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.FindException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/character")
public class NarutoCharacterController {

    @Autowired
    private NarutoCharacterServiceImpl characterService;


    /* -------------------------------- CREATE -------------------------------- */
    @PostMapping
    public @ResponseBody ResponseEntity<Object> saveCharacter(@Valid @RequestBody NarutoCharacter entity){
       try {
           return ResponseEntity.status(HttpStatus.OK).body(characterService.saveCharacter(entity));
       } catch (NullPointerException e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       } catch (CharacterAlreadyExistsException e) {
           return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
       }
    }



    /* -------------------------------- READ -------------------------------- */
    @GetMapping
    public @ResponseBody ResponseEntity<List<NarutoCharacter>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(characterService.findAll());
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Object> findById(@PathVariable(value = "id") String id){
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(characterService.findById(id));
        } catch (FindException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<Object> findAllByName(@RequestParam String name){
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(characterService.findAllByName(name));
        } catch (FindException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



    /* -------------------------------- UPDATE -------------------------------- */
    @PutMapping
    public @ResponseBody ResponseEntity<Object> updateCharacter(@RequestBody NarutoCharacter entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(characterService.updateCharacter(entity));
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (CharacterNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (UpdateCharacterException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST ).body(e.getMessage());
        }
    }

    /* -------------------------------- DELETE -------------------------------- */
    @DeleteMapping
    public @ResponseBody ResponseEntity<Object> deleteCharacter(@Valid @RequestBody NarutoCharacter entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(characterService.deleteCharacter(entity));
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (CharacterNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<Object> deleteCharacterById(@PathVariable(value = "id") String id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(characterService.deleteCharacterById(id));
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (CharacterNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
