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

import com.f1rst.registryapi.ddd.client.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientControllerTest {

    @InjectMocks
    private ClientController clientController;

    @Mock
    private ClientService clientService;

    @Test
    void shouldSaveClientSuccessfully() {
        // Arrange
        ClientRecord clientRecord = new ClientRecord(1L, "John Doe", "12345678900", TypeClientEnum.PF, null, List.of());
        doNothing().when(clientService).save(clientRecord);

        // Act
        ResponseEntity<String> response = clientController.save(clientRecord);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Client successfully registered", response.getBody());
        verify(clientService, times(1)).save(clientRecord);
    }

    @Test
    void shouldFindAllClients() {
        // Arrange
        Pageable pageable = PageRequest.of(0, 10, Sort.by("name"));
        Page<ClientRecord> pageMock = new PageImpl<>(List.of(
                new ClientRecord(1L, "John Doe", "12345678900", TypeClientEnum.PF, null, List.of())
        ));
        when(clientService.findAll(pageable)).thenReturn(pageMock);

        // Act
        ResponseEntity<Page<ClientRecord>> response = clientController.findAll(pageable);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().getTotalElements());
        verify(clientService, times(1)).findAll(pageable);
    }

    @Test
    void shouldGetClientDetails() {
        // Arrange
        Long clientId = 1L;
        ClientRecord clientRecord = new ClientRecord(clientId, "John Doe", "12345678900", TypeClientEnum.PF, null, List.of());
        when(clientService.detail(clientId)).thenReturn(Optional.of(clientRecord));

        // Act
        ResponseEntity<Optional<ClientRecord>> response = clientController.detail(clientId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isPresent());
        assertEquals(clientRecord, response.getBody().get());
        verify(clientService, times(1)).detail(clientId);
    }

}
