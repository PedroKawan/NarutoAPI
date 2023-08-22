package me.pedrokaua.narutoapi.models.repository;

import me.pedrokaua.narutoapi.models.entities.NarutoCharacter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NarutoCharacterRepository extends MongoRepository<NarutoCharacter, ObjectId> {
    public Optional<NarutoCharacter> findFirstByNameLike(String name);

    public List<NarutoCharacter> findAllByNameLike(String name);
}
