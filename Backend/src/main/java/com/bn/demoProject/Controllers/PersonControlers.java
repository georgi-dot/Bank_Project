package com.bn.demoProject.Controllers;


import com.bn.demoProject.entities.Person;
import com.bn.demoProject.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("person")
public class PersonControlers {
    @Autowired
    PersonRepository personRepository;
    @DeleteMapping("/delete")
    public  ResponseEntity<?> deletePerson(@RequestParam Long id) {
        if (!personRepository.existsById(id))
        {
            return ResponseEntity.ok("Няма такъв човек");
        }
            personRepository.deleteById(id);

        return ResponseEntity.ok("Изтрит успешно");
    }

    @GetMapping("/all")
    public List<Person> getAllPersons()
    {
        return personRepository.findAll();
    }
    @PostMapping("/save")
    public ResponseEntity<?> savePerson(@RequestParam(required = false)Long id,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false) String iban,
                                        @RequestParam(required = false) Integer money)
    {
        boolean isNew = id == null;
        Person person = new Person(id,iban,name,money);
        if (iban.length() != 22)
        {
            return ResponseEntity.ok().body("Грешен айбан");

        }
        else
        {
            person = personRepository.save(person);
            Map<String, Object> response = new HashMap<>();
            response.put("generateId", person.getId());
            if (iban.length() != 22) {
                return ResponseEntity.ok().body("Грешен айбан");

            }
            if (isNew) {
                response.put("Message:", "Успешно записване");
            } else {
                response.put("Message:", "Успешно редактиране");
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<?> getPerson(@RequestParam(required = false)String name)
    {
        if(name == null || name.isBlank())
        {
            return ResponseEntity.ok().body("Не сте въвели име");
        }
        Optional<Person> result = personRepository.findPersonByName(name);
        return result.isPresent()? ResponseEntity.ok(result.get()) : ResponseEntity.ok("Няма намерен човек");
    }
}
