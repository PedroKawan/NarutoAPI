package me.pedrokaua.narutoapi.entities;

import me.pedrokaua.narutoapi.controllers.NarutoCharacterController;
import me.pedrokaua.narutoapi.exceptions.CharacterAlreadyExistsException;
import me.pedrokaua.narutoapi.models.entities.NarutoCharacter;
import me.pedrokaua.narutoapi.models.services.NarutoCharacterServiceImpl;
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
    NarutoCharacterController characterController;

    @Autowired
    NarutoCharacterServiceImpl characterService;

    @Test
    void test1_creatingEntity() {
        assertDoesNotThrow(() -> {
            NarutoCharacter char1
                    = new NarutoCharacter("Naruto Uzumaki", 15, 'M', "Uzumaki", "Genin");
        });
    }

    @Test
    void test3_postEntity() {
        assertDoesNotThrow(() -> {
            NarutoCharacter char1
                    = new NarutoCharacter("Naruto Uzumaki", 15, 'M', "Uzumaki", "Genin");
            characterService.saveCharacter(char1);
        });
    }

    @Test
    void test5_postEntityWithNullException() {
        new Thread(() -> {
            assertThrowsExactly(NullPointerException.class, () -> {
                characterService.saveCharacter(null);
            });
        });
    }

    @Test
    void test6_postEntityWithException() {
        new Thread(() -> {
            assertThrowsExactly(CharacterAlreadyExistsException.class, () -> {
                NarutoCharacter char1
                        = new NarutoCharacter("Naruto Uzumaki", 15, 'M', "Uzumaki", "Genin");
                characterService.saveCharacter(char1);
            });
        });
    }

    @Test
    void test7_getEntity() {
        new Thread(() -> {
            assertDoesNotThrow(() -> {
                var char1 = characterService.findAllByName("Naruto");
                assertEquals("Naruto Uzumaki", char1.get(0).getName());
            });
        });

    }

}



/*
    --> OBS: Delete verb doesn't work! <--

    @Test
    void test6_deleteEntity(){
        new Thread(() -> {
            var char1 = characterService.findAllByName("Naruto").get(0);
            assertDoesNotThrow(() -> {
                characterController.deleteCharacterById("a3265c45-6ffe-427e-8cc8-e149b6dd3c61");
            });
        });
    }

 */

