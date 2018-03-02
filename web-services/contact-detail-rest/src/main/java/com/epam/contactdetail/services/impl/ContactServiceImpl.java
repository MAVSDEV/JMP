package com.epam.contactdetail.services.impl;

import com.epam.contactdetail.models.Contact;
import com.epam.contactdetail.services.ContactService;
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

    public Contact getById(String id) {
        return CONTACTS.get(id);
    }

    public List<Contact> getAll() {
        return Lists.newArrayList(CONTACTS.values());
    }

    public void save(Contact contact) {
        CONTACTS.put(contact.getId(), contact);
    }

    public void update(Contact contact) {
        CONTACTS.put(contact.getId(), contact);
    }

    public void delete(Contact contact) {
        CONTACTS.remove(contact.getId());
    }
}
