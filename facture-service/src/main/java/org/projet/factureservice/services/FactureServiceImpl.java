package org.projet.factureservice.services;

import lombok.RequiredArgsConstructor;
import org.projet.factureservice.entities.Facture;
import org.projet.factureservice.repositories.FactureRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService {

    private final FactureRepo factureRepo;

    @Override
    public List<Facture> getAllInvoices() {
        return factureRepo.findAll();
    }

    @Override
    public Optional<Facture> getInvoiceById(Long id) {
        return factureRepo.findById(id);
    }

    @Override
    public List<Facture> getInvoicesByCustomer(String customerName) {
        return factureRepo.findByCustomerName(customerName);
    }

    @Override
    public Facture createInvoice(Facture invoice) {
        return factureRepo.save(invoice);
    }

    @Override
    public void deleteInvoice(Long id) {
        factureRepo.deleteById(id);
    }
}
