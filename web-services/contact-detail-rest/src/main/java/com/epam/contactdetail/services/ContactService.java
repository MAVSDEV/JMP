package com.epam.contactdetail.services;


import com.epam.contactdetail.models.Contact;

import java.util.List;

public interface ContactService {

	Contact getById(String id);

	List<Contact> getAll();

	void save(Contact contact);

	void update(Contact contact);

	void delete(Contact contact);
}

