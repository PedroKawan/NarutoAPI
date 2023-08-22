package me.pedrokaua.narutoapi.models.repositories;

import me.pedrokaua.narutoapi.models.entities.NarutoCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NarutoCharacterRepository extends MongoRepository<NarutoCharacter, String> {
    public Optional<NarutoCharacter> findFirstByNameLike(String name);

    public List<NarutoCharacter> findAllByNameLike(String name);
}
