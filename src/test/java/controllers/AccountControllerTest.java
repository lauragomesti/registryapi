package controllers;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
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

import com.f1rst.registryapi.ddd.account.*;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {


        @InjectMocks
        private AccountController accountController;

        @Mock
        private AccountService accountService;

        @Test
        void shouldSaveAccountSuccessfully() {
            // Arrange
            AccountRecord accountRecord = new AccountRecord(1L, 12345, 1000.0, StatusAccountEnum.ACTIVE, 2L);
            doNothing().when(accountService).save(accountRecord);

            // Act
            ResponseEntity<String> response = accountController.save(accountRecord);

            // Assert
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals("Account successfully registered", response.getBody());
            verify(accountService, times(1)).save(accountRecord);
        }

        @Test
        void shouldFindAllAccounts() {
            // Arrange
            Pageable pageable = PageRequest.of(0, 10, Sort.by("statusAccountEnum"));
            Page<AccountRecord> pageMock = new PageImpl<>(List.of(new AccountRecord(1L, 12345, 1000.0, StatusAccountEnum.ACTIVE, 2L)));
            when(accountService.findAll(pageable)).thenReturn(pageMock);

            // Act
            ResponseEntity<Page<AccountRecord>> response = accountController.findAll(pageable);

            // Assert
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
            assertEquals(1, response.getBody().getTotalElements());
            verify(accountService, times(1)).findAll(pageable);
        }

    @Test
    void shouldGetAccountDetails() {
        // Arrange
        Long accountId = 1L;
        AccountRecord accountRecord = new AccountRecord(1L, 12345, 1000.0, StatusAccountEnum.ACTIVE, 2L);
        when(accountService.detail(accountId)).thenReturn(Optional.of(accountRecord));

        // Act
        ResponseEntity<Optional<AccountRecord>> response = accountController.detail(accountId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(Optional.of(accountRecord), response.getBody()); // Comparação correta
        verify(accountService, times(1)).detail(accountId);
    }

    }


