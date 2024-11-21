package org.projet.factureservice.controllers;

import lombok.RequiredArgsConstructor;
import org.projet.factureservice.entities.Facture;
import org.projet.factureservice.services.FactureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invoices")
public class FactureController {

    private final FactureService invoiceService;


    @GetMapping
    public ResponseEntity<List<Facture>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facture> getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerName}")
    public ResponseEntity<List<Facture>> getInvoicesByCustomer(@PathVariable String customerName) {
        return ResponseEntity.ok(invoiceService.getInvoicesByCustomer(customerName));
    }

    @PostMapping
    public ResponseEntity<Facture> createInvoice(@RequestBody Facture invoice) {
        return ResponseEntity.ok(invoiceService.createInvoice(invoice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}

