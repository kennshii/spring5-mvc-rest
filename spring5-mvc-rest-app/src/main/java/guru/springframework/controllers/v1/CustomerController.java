package guru.springframework.controllers.v1;

import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.api.v1.model.CustomerListDTO;
import guru.springframework.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(description = "This is my customer controller")
@Controller
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "This will get a list of customers", notes = "These are some notes about API.")
    @GetMapping
    public ResponseEntity<CustomerListDTO> getAllCustomers() {

        return new ResponseEntity<>(
                new CustomerListDTO(customerService.getAllCustomers()), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id){
        return new ResponseEntity<CustomerDTO>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomerDTO>(customerService.createNewCustomer(customerDTO), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id ,@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomerDTO>(customerService.saveCustomerByDTO(id, customerDTO), HttpStatus.OK);
    }

    @PatchMapping({"/{id}"})
    public ResponseEntity<CustomerDTO> patchCustomer(@PathVariable Long id ,@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomerDTO>(customerService.patchCustomer(id, customerDTO), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {

        customerService.deleteCustomerById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
