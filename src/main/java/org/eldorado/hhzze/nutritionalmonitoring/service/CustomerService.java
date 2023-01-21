package org.eldorado.hhzze.nutritionalmonitoring.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eldorado.hhzze.nutritionalmonitoring.domain.model.AddressEntity;
import org.eldorado.hhzze.nutritionalmonitoring.domain.model.CustomerEntity;
import org.eldorado.hhzze.nutritionalmonitoring.domain.repository.CustomerRepository;
import org.eldorado.hhzze.nutritionalmonitoring.dto.AddressDto;
import org.eldorado.hhzze.nutritionalmonitoring.dto.CustomerDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public CustomerDto saveCustomer(CustomerDto customerDto) {
        var customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
        var customerAddressEntity = modelMapper.map(customerDto.getAddress(), AddressEntity.class);
        customerEntity.setAddressEntity(customerAddressEntity);
        var entitySaved = customerRepository.save(customerEntity);
        customerDto.setId(entitySaved.getId());
        return customerDto;
    }

    public List<CustomerDto> getCustomers() {
        var customersEntities = customerRepository.findAll();

        return customersEntities.stream().map(customer -> {
            var addressDto = modelMapper.map(customer.getAddressEntity(), AddressDto.class);
            var customerDto = modelMapper.map(customer, CustomerDto.class);
            customerDto.setAddress(addressDto);
            return customerDto;
        }).toList();
    }

    public CustomerDto getCustomerById(UUID customerID) {
        var customerEntity = customerRepository.findById(customerID).orElseThrow();
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    public CustomerDto updateCustomer(UUID customerID, CustomerDto customerDto) {
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        var customerEntity = customerRepository.findById(customerID).orElseThrow();
        modelMapper.map(customerDto, customerEntity);
        modelMapper.map(customerDto.getAddress(), customerEntity.getAddressEntity());
        var customerSaved = customerRepository.save(customerEntity);

        return modelMapper.map(customerSaved, CustomerDto.class);
    }

    public void deleteCustomer(UUID customerID) {
        customerRepository.deleteById(customerID);
    }
}
