package com.epam.agency.services;

import com.epam.agency.beans.Estate;

import java.util.List;
import java.util.Optional;

public interface EstateService {

    Optional<Estate> getById(Long id);

    List<Estate> getAll();

    void save(Estate estate);

    void saveAll(List<Estate> estates);

    void delete(Long estateId);

    void incrementEstateViewsCount(Long estateId);

    void updatePrice(Long estateId, Long newPrice);

    void sellEstate(Long estateId);
}
