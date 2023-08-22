package me.pedrokaua.narutoapi.models.services.impl;

import me.pedrokaua.narutoapi.models.entities.NarutoCharacter;
import me.pedrokaua.narutoapi.models.repository.NarutoCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface NarutoCharacterService {
    /* -- CREATE -- */
    public abstract NarutoCharacter saveCharacter(NarutoCharacter entity);

    /* -- READ -- */
    public abstract List<NarutoCharacter> findAll();

    public abstract NarutoCharacter findById(String id);

    public abstract NarutoCharacter findByName(String name);

    /* -- UPDATE -- */

    /* -- DELETE -- */
    public abstract NarutoCharacter deleteCharacter(NarutoCharacter entity);

    public abstract NarutoCharacter deleteCharacterById(String id);
}
