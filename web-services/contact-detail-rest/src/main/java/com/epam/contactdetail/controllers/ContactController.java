package com.epam.contactdetail.controllers;

import com.epam.contactdetail.models.Contact;
import com.epam.contactdetail.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/{contactId}")
    public Contact getById(@PathVariable String contactId) {
        return contactService.getById(contactId);
    }

    @RequestMapping("/all")
    public List<Contact> getAll() {
        return contactService.getAll();
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Contact contact) {
        contactService.save(contact);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Contact contact) {
        contactService.update(contact);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(path = "/delete/{contactId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String contactId) {
        Contact contact = contactService.getById(contactId);
        if (contact != null) {
            contactService.delete(contact);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
