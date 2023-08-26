package me.pedrokaua.narutoapi.models.services.impl;

import me.pedrokaua.narutoapi.models.entities.NarutoCharacter;

import java.util.List;

public interface NarutoCharacterService {
    /* -- CREATE -- */
    public abstract NarutoCharacter saveCharacter(NarutoCharacter entity);

    /* -- READ -- */
    public abstract List<NarutoCharacter> findAll();

    public abstract NarutoCharacter findById(String id);

    public abstract List<NarutoCharacter> findAllByName(String name);

    /* -- UPDATE -- */

    public abstract NarutoCharacter updateCharacter(NarutoCharacter entity);

    /* -- DELETE -- */
    public abstract NarutoCharacter deleteCharacter(NarutoCharacter entity);

    public abstract NarutoCharacter deleteCharacterById(String id);
}
