package com.epam.contactdetail.service.impl;

import com.epam.contactdetail.service.ContactService;
import com.epam.contactdetail.soap_web_service.Contact;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * Contact Service.
 */
@Component
public class ContactServiceImpl implements ContactService {

    private static final Map<String, Contact> CONTACTS = Maps.newHashMap();

    @PostConstruct
    public void initData() {
        Contact petya = new Contact();
        petya.setId("1");
        petya.setName("Petya");
        petya.setPhone("+9384938493");

        Contact jane = new Contact();
        jane.setId("2");
        jane.setName("Jane");
        jane.setPhone("+938493348493");

        Contact vasya = new Contact();
        vasya.setId("3");
        vasya.setName("Vasya");
        vasya.setPhone("+938493");

        CONTACTS.put(vasya.getId(), vasya);
        CONTACTS.put(jane.getId(), jane);
        CONTACTS.put(petya.getId(), petya);
    }

    public Contact getContactById(String id) {
        return CONTACTS.get(id);
    }

    public List<Contact> getAllContacts() {
        return Lists.newArrayList(CONTACTS.values());
    }

    public void saveContact(Contact contact) {
        CONTACTS.put(contact.getId(), contact);
    }

    public void updateContact(Contact contact) {
        CONTACTS.put(contact.getId(), contact);
    }

    public void deleteContact(Contact contact) {
        CONTACTS.remove(contact.getId());
    }
}
