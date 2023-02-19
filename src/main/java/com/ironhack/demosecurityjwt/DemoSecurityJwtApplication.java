package com.ironhack.demosecurityjwt;

import com.ironhack.demosecurityjwt.models.Role;
import com.ironhack.demosecurityjwt.models.User;
import com.ironhack.demosecurityjwt.models.accounts.Checking;
import com.ironhack.demosecurityjwt.models.accounts.CreditCard;
import com.ironhack.demosecurityjwt.models.accounts.Savings;
import com.ironhack.demosecurityjwt.models.accounts.StudentChecking;
import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import com.ironhack.demosecurityjwt.models.users.Admin;
import com.ironhack.demosecurityjwt.models.users.ThirdParty;
import com.ironhack.demosecurityjwt.repositories.accountsrepository.*;
import com.ironhack.demosecurityjwt.repositories.usersrepository.AccountHolderRepository;
import com.ironhack.demosecurityjwt.repositories.usersrepository.AdminRepository;
import com.ironhack.demosecurityjwt.repositories.usersrepository.ThirdPartyRepository;
import com.ironhack.demosecurityjwt.services.impl.UserService;
import com.ironhack.demosecurityjwt.tools.Address;
import com.ironhack.demosecurityjwt.tools.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@SpringBootApplication
public class DemoSecurityJwtApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoSecurityJwtApplication.class, args);
    }


    @Autowired
    private UserService userService;

    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Override
    public void run(String... args) throws Exception {

        //Método 1

        Collection<Role> roles = new ArrayList<Role>();
        roles.add(userService.saveRole(new Role(1L, "ROLE_ADMIN")));




        Address address = new Address("Calle Mayor", "Barcelona", 80001, "Spain" );



        User user = new User();

        LocalDate date = LocalDate.now();


        AccountHolder accountHolder = new AccountHolder("wololo123", "1234", roles, "Anna", LocalDate.now(), address, null);
        AccountHolder accountHolder2 = new AccountHolder("robinhood", "1234", roles, "George", LocalDate.now(), address, null);

        Admin admin = new Admin("Administrator","1234",roles,"Pepe");

        ThirdParty thirdParty = new ThirdParty("Third","1234",roles,"External",1234);

        accountHolderRepository.save(accountHolder);
        accountHolderRepository.save(accountHolder2);
        adminRepository.save(admin);
        thirdPartyRepository.save(thirdParty);

        Checking checking = new Checking(BigDecimal.valueOf(30.00),accountHolder,null,date, null, Status.ACTIVE,"1234",BigDecimal.valueOf(800.00),BigDecimal.valueOf(600.00));
        checking.setAccountId(1);

        Savings savings = new Savings(BigDecimal.valueOf(20),accountHolder2,accountHolder,BigDecimal.valueOf(40.00),date,date,Status.ACTIVE, BigDecimal.valueOf(6.00), "1234", BigDecimal.valueOf(300.00));
        savings.setAccountId(2);

        CreditCard creditCard = new CreditCard(BigDecimal.valueOf(100.00),accountHolder,accountHolder,BigDecimal.valueOf(150.00),date,date,Status.ACTIVE,BigDecimal.valueOf(100.00),BigDecimal.valueOf(0.20));
        creditCard.setAccountId(3);

        StudentChecking studentChecking = new StudentChecking(BigDecimal.valueOf(30.00),accountHolder,accountHolder,BigDecimal.valueOf(40.00),date,date,Status.ACTIVE,"1234");
        studentChecking.setAccountId(4);

        savingsRepository.save(savings);
        checkingRepository.save(checking);
        creditCardRepository.save(creditCard);
        studentCheckingRepository.save(studentChecking);
    }


    /* @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User(null, "John Doe", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "James Smith", "james", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Jane Carry", "jane", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Chris Anderson", "chris", "1234", new ArrayList<>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("james", "ROLE_ADMIN");
            userService.addRoleToUser("jane", "ROLE_USER");
            userService.addRoleToUser("chris", "ROLE_ADMIN");
            userService.addRoleToUser("chris", "ROLE_USER");
        };
    } */

}
