package com.ClientBase.ClientBase.Controllers;

import com.ClientBase.ClientBase.Entities.Contact;
import com.ClientBase.ClientBase.Repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @PostMapping("/admin/addContact")
    public String addContact(@RequestBody Contact contact){
        contactRepository.addContact(contact);
        return "Contact Added successfully!";
    }

    @GetMapping("/contactId/{clientId}")
    public List<Contact> getAllContacts(@PathVariable int clientId){
        return contactRepository.showContactForClient(clientId);
    }

    @PutMapping("/admin/updateContact")
    public String updateContact(@RequestBody Contact contact) {
        contactRepository.updateContact(contact);
        return "Contact updated successfully!";
    }

}
