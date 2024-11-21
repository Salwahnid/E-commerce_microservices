package org.example.customer.service;

import org.example.customer.model.CustomerModel;
import org.example.customer.repository.CustomerRepo;
import org.example.customer.request.CustomerRequest;
import org.example.customer.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepo customerRepository;

    // Méthode pour créer un nouveau client
    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        // Conversion du CustomerRequest en entité Customer
        CustomerModel customer = new CustomerModel();
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setAddress(customerRequest.getAddress());

        // Sauvegarde en base de données
        CustomerModel savedCustomer = customerRepository.save(customer);

        // Conversion de l'entité Customer en CustomerResponse
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(savedCustomer.getId());
        customerResponse.setName(savedCustomer.getName());
        customerResponse.setEmail(savedCustomer.getEmail());
        customerResponse.setPhoneNumber(savedCustomer.getPhoneNumber());
        customerResponse.setAddress(savedCustomer.getAddress());

        return customerResponse;
    }

    // Méthode pour récupérer un client par ID
    @Override
    public CustomerResponse getCustomerById(Long id) {
        // Vérification si le client existe
        CustomerModel customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

        // Conversion de l'entité Customer en CustomerResponse
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setPhoneNumber(customer.getPhoneNumber());
        customerResponse.setAddress(customer.getAddress());

        return customerResponse;
    }

    // Méthode pour mettre à jour un client
    @Override
    public CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest) {
        // Recherche du client existant
        CustomerModel existingCustomer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

        // Mise à jour des informations du client
        existingCustomer.setName(customerRequest.getName());
        existingCustomer.setEmail(customerRequest.getEmail());
        existingCustomer.setPhoneNumber(customerRequest.getPhoneNumber());
        existingCustomer.setAddress(customerRequest.getAddress());

        // Sauvegarde des modifications en base de données
        CustomerModel updatedCustomer = customerRepository.save(existingCustomer);

        // Conversion de l'entité Customer en CustomerResponse
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(updatedCustomer.getId());
        customerResponse.setName(updatedCustomer.getName());
        customerResponse.setEmail(updatedCustomer.getEmail());
        customerResponse.setPhoneNumber(updatedCustomer.getPhoneNumber());
        customerResponse.setAddress(updatedCustomer.getAddress());

        return customerResponse;
    }

    // Méthode pour supprimer un client
    @Override
    public void deleteCustomer(Long id) {
        // Vérification de l'existence du client
        CustomerModel customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

        // Suppression du client en base de données
        customerRepository.delete(customer);
    }


//    public void saveCustomerOrderData(int customerId, String name, String email, int orderId) {
//        String filePath = "customer_order_data.txt";
//        String customerData = String.format("CustomerID: %d\nName: %s\nEmail: %s\nOrderID: %d",
//                customerId, name, email, orderId);
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//            writer.write(customerData);
//            System.out.println("Customer data written to file by Customer Service.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    // Exemple d'utilisation de cette méthode
//    public static void main(String[] args) {
//        CustomerService customerService = new CustomerService();
//        customerService.saveCustomerOrderData(12345, "John Doe", "john.doe@example.com", 67890);
//    }


}






