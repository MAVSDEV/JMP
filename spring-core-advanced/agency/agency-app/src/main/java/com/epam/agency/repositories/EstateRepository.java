package com.epam.agency.repositories;

import com.epam.agency.beans.Estate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Estate Service.
 */
@Repository
public interface EstateRepository extends CrudRepository<Estate, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Estate E SET E.price = :newPrice WHERE E.id = :id")
    void updatePrice(@Param("id") Long id, @Param("newPrice") Long newPrice);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Estate E SET E.sold = :sold, E.soldDate = :soldDate WHERE E.id = :id")
    void updateSoldProperties(@Param("id") Long id, @Param("sold") Boolean sold, @Param("soldDate") Date soldDate);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Estate E SET E.viewsCount = :viewsCount WHERE E.id = :id")
    void updateViewsCount(@Param("id") Long id, @Param("viewsCount") Long viewsCount);
}
