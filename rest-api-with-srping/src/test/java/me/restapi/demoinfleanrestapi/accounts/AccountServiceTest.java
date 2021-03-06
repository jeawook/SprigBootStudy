package me.restapi.demoinfleanrestapi.accounts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class AccountServiceTest {

    @Autowired
    AccountService  accountService;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    public void findByUserName() {
        // Given
        String username = "pdj@nate.com";
        String password = "jaewook";
        Account account = Account.builder()
                .email(username)
                .password(password)
                .roles(Set.of(AccountRole.ADMIN, AccountRole.USER)).build();
        this.accountService.saveAccount(account);

        // When
        UserDetailsService userDetailsService = (UserDetailsService) accountService;
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        // Then
        assertThat(this.passwordEncoder.matches(password,userDetails.getPassword())).isTrue();
    }

    @Test
    public void findByUsernameFail() {
        String username = "test@test.com";
        UsernameNotFoundException exception = assertThrows(UsernameNotFoundException.class, () -> accountService.loadUserByUsername(username));
        assertTrue(exception.getMessage().contains(username));
    }
}