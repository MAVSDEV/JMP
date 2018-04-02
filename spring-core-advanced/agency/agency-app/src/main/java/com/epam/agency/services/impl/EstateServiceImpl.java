package com.epam.agency.services.impl;

import com.epam.agency.beans.Estate;
import com.epam.agency.repositories.EstateRepository;
import com.epam.agency.services.EstateService;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.epam.agency.utils.CommonUtil.sleep;

@Slf4j
@Service
@Transactional
public class EstateServiceImpl implements EstateService {

    @Autowired
    private EstateRepository estateRepository;

    @Override
    public Optional<Estate> getById(Long id) {
        return estateRepository.findById(id);
    }

    @Override
    public List<Estate> getAll() {
        return Lists.newArrayList(estateRepository.findAll());
    }

    @Override
    public void save(Estate estate) {
        estateRepository.save(estate);
    }

    @Override
    public void saveAll(List<Estate> estates) {
        estateRepository.saveAll(estates);
    }

    @Override
    public void delete(Long estateId) {
        estateRepository.deleteById(estateId);
    }

    @Override
    public void incrementEstateViewsCount(Long estateId) {
        estateRepository.findById(estateId).ifPresent(estate -> {
            estate.setViewsCount(estate.getViewsCount() + 1);
            estateRepository.updateViewsCount(estate.getId(), estate.getViewsCount());
            log.info("Estate '{}' was visited '{}' times", estate.getName(), estate.getViewsCount());
            sleep(100);
        });
    }

    @Override
    public void updatePrice(Long estateId, Long newPrice) {
        estateRepository.findById(estateId).ifPresent(estate -> {
            if (!estate.getSold()) {
                estate.setPrice(newPrice);
                log.info("New price '{}' for estate with id: '{}'", newPrice, estateId);
                estateRepository.updatePrice(estate.getId(), estate.getPrice());
                sleep(100);
            }
        });
    }

    @Override
    public void sellEstate(Long estateId) {
        estateRepository.findById(estateId).ifPresent(estate -> {
            if (!estate.getSold()) {
                estate.setSold(Boolean.TRUE);
                estate.setSoldDate(new Date());
                estateRepository.updateSoldProperties(estate.getId(), estate.getSold(), estate.getSoldDate());
                sleep(50);
                log.info("Estate '{}' was sold by agent '{}'!", estate.getName(), estate.getAgent().getName());
            }
        });
    }
}
