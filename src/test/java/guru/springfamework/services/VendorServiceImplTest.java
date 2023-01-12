package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.VendorMapper;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.controllers.v1.VendorController;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class VendorServiceImplTest {

    @Mock
    VendorRepository vendorRepository;

    VendorMapper vendorMapper = VendorMapper.INSTANCE;

    VendorService vendorService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        vendorService = new VendorServiceImpl(vendorMapper, vendorRepository);
    }

    @Test
    public void getAllVendors() {

        //given
        Vendor vendor1 = new Vendor();
        vendor1.setId(1L);
        vendor1.setName("Western Tasty Fruits Ltd.");

        Vendor vendor2 = new Vendor();
        vendor2.setId(2L);
        vendor2.setName("Exotic Fruits Company");

        Vendor vendor3 = new Vendor();
        vendor3.setId(3L);
        vendor3.setName("DOMUS");

        when(vendorRepository.findAll()).thenReturn(Arrays.asList(vendor1, vendor2, vendor3));

        //when
        List<VendorDTO> vendorDTOS = vendorService.getAllVendors();

        //then
        assertEquals(3, vendorDTOS.size());
    }

    @Test
    public void getVendorById() {
        //given
        Vendor vendor1 = new Vendor();
        vendor1.setId(1L);
        vendor1.setName("a pohui");

        when(vendorRepository.findById(anyLong())).thenReturn(Optional.ofNullable(vendor1));

        VendorDTO vendorDTO = vendorService.getVendorById(1L);

        assertEquals("a pohui", vendorDTO.getName());
    }

    @Test
    public void createNewVendor() {
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName("Vendor");

        Vendor savedVendor = new Vendor();
        savedVendor.setName(vendorDTO.getName());
        savedVendor.setId(1L);

        when(vendorRepository.save(any(Vendor.class))).thenReturn(savedVendor);

        //when
        VendorDTO savedDto = vendorService.createNewVendor(vendorDTO);

        //then
        assertEquals(vendorDTO.getName(), savedDto.getName());
        assertEquals(VendorController.BASE_URL + "/1", savedDto.getVendorUrl());
    }
}