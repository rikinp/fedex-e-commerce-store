package com.rikin.fedexecommerce.repository;

import com.rikin.fedexecommerce.model.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<StoreItem,Integer> {
}