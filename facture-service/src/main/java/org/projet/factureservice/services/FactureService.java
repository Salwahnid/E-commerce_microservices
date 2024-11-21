package org.projet.factureservice.services;

import org.projet.factureservice.entities.Facture;

import java.util.List;
import java.util.Optional;

public interface FactureService {

    List<Facture> getAllInvoices();

    Optional<Facture> getInvoiceById(Long id);

    List<Facture> getInvoicesByCustomer(String customerName);

    Facture createInvoice(Facture invoice);

    void deleteInvoice(Long id);
}
