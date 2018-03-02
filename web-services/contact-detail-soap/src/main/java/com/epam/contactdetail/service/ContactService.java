package com.epam.contactdetail.service;

import com.epam.contactdetail.soap_web_service.Contact;

import java.util.List;

public interface ContactService {

	Contact getContactById(String id);

	List<Contact> getAllContacts();

	void saveContact(Contact contact);

	void updateContact(Contact contact);

	void deleteContact(Contact contact);
}

