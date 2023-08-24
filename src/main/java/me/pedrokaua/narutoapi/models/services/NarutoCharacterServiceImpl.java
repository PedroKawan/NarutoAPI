package me.pedrokaua.narutoapi.models.services;

import me.pedrokaua.narutoapi.exceptions.CharacterAlreadyExistsException;
import me.pedrokaua.narutoapi.exceptions.CharacterNotFoundException;
import me.pedrokaua.narutoapi.models.entities.NarutoCharacter;
import me.pedrokaua.narutoapi.models.repositories.NarutoCharacterRepository;
import me.pedrokaua.narutoapi.models.services.impl.NarutoCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;
import java.util.UUID;

@Service
public class NarutoCharacterServiceImpl implements NarutoCharacterService {

    @Autowired
    private NarutoCharacterRepository characterRepository;



    /* -------------------------------- CREATE -------------------------------- */
    @Override
    public NarutoCharacter saveCharacter(NarutoCharacter entity)
                throws NullPointerException, CharacterAlreadyExistsException {

        var list = findAll();

        if (entity == null){
            throw new NullPointerException("Entity is null!");
        }
        if (list.contains(entity)) {
            throw new CharacterAlreadyExistsException();
        }

        this.characterRepository.save(entity);
        return entity;
    }


    /* -------------------------------- READ -------------------------------- */
    @Override
    public List<NarutoCharacter> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public NarutoCharacter findById(String id) throws FindException {
        try {
            return characterRepository.findById(UUID.fromString(id)).get();
        } catch (Exception e) {
            throw new FindException("Character not found by id: " + id);
        }

    }

    @Override
    public List<NarutoCharacter> findAllByName(String name) throws FindException {
        name = name == null ? "" : name;

        try {
            return characterRepository.findByNameContainingIgnoreCase(name);
        } catch (Exception e) {
            throw new FindException("Ninja is not present in database with the name: " + name);
        }
    }

    /* -------------------------------- UPDATE -------------------------------- */

    /* -------------------------------- DELETE -------------------------------- */
    @Override
    public NarutoCharacter deleteCharacter(NarutoCharacter entity)
            throws NullPointerException, CharacterNotFoundException {

        if (entity == null){
            throw new NullPointerException("Entity is null!");
        }

        try {
            this.findById(entity.getId().toString());
            characterRepository.delete(entity);
            return entity;
        } catch (Exception e) {
            throw new CharacterNotFoundException();
        }
    }

    @Override
    public NarutoCharacter deleteCharacterById(String id)
            throws NullPointerException, CharacterNotFoundException {

        if (id == null){
            throw new NullPointerException("Id is null!");
        }
        try {
            NarutoCharacter char1 = findById(id);
            characterRepository.deleteById(UUID.fromString(id));
            return char1;
        } catch (Exception e) {
            throw new CharacterNotFoundException("Id not found in database!");
        }
    }
}
