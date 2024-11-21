package org.projet.factureservice.repositories;

import org.projet.factureservice.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FactureRepo extends JpaRepository<Facture, Long> {
    List<Facture> findByCustomerName(String customerName);
}

