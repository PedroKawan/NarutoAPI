package me.pedrokaua.narutoapi.entities;

import me.pedrokaua.narutoapi.exceptions.CharacterAlreadyExistsException;
import me.pedrokaua.narutoapi.models.entities.NarutoCharacter;
import me.pedrokaua.narutoapi.models.services.NarutoCharacterServiceImpl;
import org.bson.types.ObjectId;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class EntitiesTests {

    @Autowired
    NarutoCharacterServiceImpl characterService;

    @Test
    void test1_creatingEntity(){
        assertDoesNotThrow(() -> {
            NarutoCharacter char1
                    = new NarutoCharacter("Naruto Uzumaki", 18, 'M', "Uzumaki", "Genin");
        });
    }

    @Test
    void test2_postEntity(){
        assertDoesNotThrow(() -> {
            NarutoCharacter char1
                    = new NarutoCharacter("Naruto Uzumaki", 18, 'M', "Uzumaki", "Genin");
            characterService.saveCharacter(char1);
        });
    }

    @Test
    void test3_postEntityWithException(){
        new Thread(() -> {
            assertThrowsExactly(CharacterAlreadyExistsException.class, () -> {
                NarutoCharacter char1
                        = new NarutoCharacter("Naruto Uzumaki", 18, 'M', "Uzumaki", "Genin");
                characterService.saveCharacter(char1);
            });
        });
    }

    @Test
    void test4_getEntity(){
        new Thread(() -> {
            assertDoesNotThrow(() -> {
                var char1 = characterService.findByName("Naru");
                assertEquals("Naruto Uzumaki", char1.getName());
            });
        });

    }


    @Test
    void test6_deleteEntity(){
        new Thread(() -> {
            assertDoesNotThrow(() -> {
                characterService.deleteCharacter(characterService.findByName("Naruto Uzumaki"));
            });
        });
    }
}
