package kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountServiceShould {


    @Spy
    TransactionRepository transactionRepository;

    @Mock
    ClockGenerator clockGenerator;

    private AccountService accountService;

    @Test
    void add_deposit_100_in_20220505() {

        //given
        int amount = 10;
        LocalDate date = LocalDate.of(2022, 5, 5);
        //when(clockGenerator.getDate()).thenReturn(date);
        given(clockGenerator.getDate()).thenReturn(date);  //same as "when"!
        accountService = new AccountService();


        //when
        accountService.deposit(amount);


        //verify
        Transaction transaction = new Transaction(amount, date);
        verify(transactionRepository, times(1)).add(transaction);
    }

}
