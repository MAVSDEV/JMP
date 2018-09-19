package com.epam.tradesystem.services;

public interface DeliveryService {

    void changeDeliveryStatus(String productId, String newDeliveryStatus);
}
