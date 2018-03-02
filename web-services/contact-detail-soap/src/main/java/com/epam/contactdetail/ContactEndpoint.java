package com.epam.contactdetail;

import com.epam.contactdetail.service.ContactService;
import com.epam.contactdetail.soap_web_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ContactEndpoint {
    private static final String NAMESPACE_URI = "http://epam.com/contactdetail/soap-web-service";

    private ContactService contactService;

    @Autowired
    public ContactEndpoint(ContactService contactService) {
        this.contactService = contactService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getContactByIdRequest")
    @ResponsePayload
    public GetContactByIdResponse getContact(@RequestPayload GetContactByIdRequest request) {
        GetContactByIdResponse response = new GetContactByIdResponse();
        response.setContact(contactService.getContactById(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllContactsRequest")
    @ResponsePayload
    public GetAllContactsResponse getAllContacts() {
        GetAllContactsResponse response = new GetAllContactsResponse();
        response.getContact().addAll(contactService.getAllContacts());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addContactRequest")
    @ResponsePayload
    public AddContactResponse addContact(@RequestPayload AddContactRequest request) {
        AddContactResponse response = new AddContactResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Contact contact = new Contact();
        contact.setId(request.getId());
        contact.setName(request.getName());
        contact.setPhone(request.getPhone());

        contactService.saveContact(contact);
        response.setContact(contact);
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateContactRequest")
    @ResponsePayload
    public UpdateContactResponse updateContact(@RequestPayload UpdateContactRequest request) {
        Contact contact = new Contact();
        contact.setId(request.getContact().getId());
        contact.setName(request.getContact().getName());
        contact.setPhone(request.getContact().getPhone());

        contactService.updateContact(contact);
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("SUCCESS");
        serviceStatus.setMessage("Content Updated Successfully");
        UpdateContactResponse response = new UpdateContactResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteContactRequest")
    @ResponsePayload
    public DeleteContactResponse deleteContact(@RequestPayload DeleteContactRequest request) {
        Contact contact = contactService.getContactById(request.getContactId());
        ServiceStatus serviceStatus = new ServiceStatus();
        if (contact != null) {
            contactService.deleteContact(contact);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Deleted Successfully");
        } else {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Content Not Available");
        }
        DeleteContactResponse response = new DeleteContactResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

}
