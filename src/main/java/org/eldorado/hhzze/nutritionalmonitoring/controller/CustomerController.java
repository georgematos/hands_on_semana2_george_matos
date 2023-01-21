package org.eldorado.hhzze.nutritionalmonitoring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eldorado.hhzze.nutritionalmonitoring.dto.CustomerDto;
import org.eldorado.hhzze.nutritionalmonitoring.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/nutritional-monitoring/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto) {
        customerDto.setId(UUID.randomUUID());

        log.info("The customer info: {}", customerDto);
        return ResponseEntity.ok(customerService.saveCustomer(customerDto));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomerList() {
        log.info("GET CUSTOMERS LIST");
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @GetMapping("/{customerID}")
    public ResponseEntity<CustomerDto> getCustomerByID(@PathVariable UUID customerID) {
        log.warn("GET CUSTOMER BY ID {}", customerID);
        return ResponseEntity.ok(customerService.getCustomerById(customerID));
    }

    @PutMapping("/{customerID}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable UUID customerID,
                                                      @RequestBody CustomerDto customerDto) {
        log.info("UPDATE CUSTOMER {}", customerID);
        var savedCustomerDto = customerService.updateCustomer(customerID, customerDto);
        return ResponseEntity.ok(savedCustomerDto);
    }

    @DeleteMapping("/{customerID}")
    public void deleteCustomer(@PathVariable UUID customerID) {
        log.info("DELETE CUSTOMER BY ID {} ", customerID);
        customerService.deleteCustomer(customerID);
    }
}
