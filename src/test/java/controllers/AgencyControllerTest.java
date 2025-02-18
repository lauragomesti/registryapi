package controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

import com.f1rst.registryapi.ddd.agency.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AgencyControllerTest {

    @InjectMocks
    private AgencyController agencyController;

    @Mock
    private AgencyService agencyService;

    @Test
    void shouldSaveAgencySuccessfully() {
        // Arrange
        AgencyRegisterRecord agencyRecord = new AgencyRegisterRecord("INTERNAL", 1234, AgencyTypeEnum.INTERNAL);
        doNothing().when(agencyService).save(agencyRecord);

        // Act
        ResponseEntity<String> response = agencyController.save(agencyRecord);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Agency successfully registered", response.getBody());
        verify(agencyService, times(1)).save(agencyRecord);
    }

    @Test
    void shouldFindAllAgencies() {
        // Arrange
        Pageable pageable = PageRequest.of(0, 10, Sort.by("name"));
        Page<AgencyRecord> pageMock = new PageImpl<>(List.of(new AgencyRecord(1L, "INTERNAL", 1234, AgencyTypeEnum.INTERNAL)));
        when(agencyService.findAll(pageable)).thenReturn(pageMock);

        // Act
        ResponseEntity<Page<AgencyRecord>> response = agencyController.findAll(pageable);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().getTotalElements());
        verify(agencyService, times(1)).findAll(pageable);
    }

    @Test
    void shouldGetAgencyDetails() {
        // Arrange
        Long agencyId = 1L;
        AgencyRecord agencyRecord = new AgencyRecord(agencyId, "INTERNAL", 1234, AgencyTypeEnum.INTERNAL);
        when(agencyService.detail(agencyId)).thenReturn(Optional.of(agencyRecord));

        // Act
        ResponseEntity<Optional<AgencyRecord>> response = agencyController.detail(agencyId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isPresent());
        assertEquals(agencyRecord, response.getBody().get()); // Corrigido aqui
        verify(agencyService, times(1)).detail(agencyId);
    }
}

