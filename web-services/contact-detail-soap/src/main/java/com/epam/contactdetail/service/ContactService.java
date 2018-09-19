package com.epam.contactdetail.service;

import com.epam.contactdetail.soap_web_service.Contact;

import java.util.List;

public interface ContactService {

	Contact getById(String id);

	List<Contact> getAll();

	void save(Contact contact);

	void update(Contact contact);

	void delete(Contact contact);
}

