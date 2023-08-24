package me.pedrokaua.narutoapi.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.spring.CucumberContextConfiguration;
import me.pedrokaua.narutoapi.models.entities.NarutoCharacter;
import me.pedrokaua.narutoapi.models.services.impl.NarutoCharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@CucumberContextConfiguration
@SpringBootTest
public class CucumberMethods {

    /* ----------------------------- GIVEN WHEN THEN ----------------------------- */
    @Autowired
    private NarutoCharacterService characterService;

    private NarutoCharacter nc;


    @Given("a new character")
    public void a_new_character(){
        nc = new NarutoCharacter("Sasuke Uchiha", 15, 'M', "Uchiha", "Genin");
    }


    @When("the character is persisted to the database")
    public void the_character_is_persisted_in_database(){
        assertDoesNotThrow(() -> {
            characterService.saveCharacter(nc);
        });
    }

    @Then("the list of character grows")
    public void then_the_list_of_character_grows(){
        assertEquals(2, characterService.findAll().size());
    }
}
