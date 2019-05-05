package dao;

import com.smartcity.DAO.UserDAOImpl;
import com.smartcity.domain.User;
import com.smartcity.exception.DBOperationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserDaoImplTest {
    private UserDAOImpl userDAO;
    private User user;
    private DriverManagerDataSource dataSource;

    @BeforeEach
    public void setup(){
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.99.100:3306/smartcity?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        userDAO = new UserDAOImpl(dataSource);

        user = new User();
        user.setName("John");
        user.setSurname("Smith");
        user.setEmail("JohnSmith@gmail.com");
        user.setPassword("password");
        user.setPhoneNumber("0123456789");
    }

    @Test
    public void whenCreatingUser_ReturnsUser(){
        assertEquals(user, userDAO.create(user).get());
    }


    @Test
    public void whenCreatingUser_GetUserReturnsCorrectUser(){
        userDAO.create(user);

        User resulUser = userDAO.get(1).get();

        assertEquals(user, resulUser);
    }

    @Test
    public void whenUpdateUser_GetUserWithIdOneReturnsUpdatedUser() {
        // Creating user
        userDAO
                .create(user);

        // Creating updated user
        User updatedUser = new User();
        updatedUser.setId(1L);
        updatedUser.setName("Den");
        updatedUser.setSurname("Smith");
        updatedUser.setEmail("updated@gmail.com");
        updatedUser.setPassword("pass");
        updatedUser.setPhoneNumber("987654321");
        updatedUser.setCreatedDate(user.getCreatedDate());

        // Updating
        userDAO
                .update(updatedUser);

        // Getting user from db
        User resultUser = userDAO
                .get(1).get();

        // Checking if both are equal
        assertEquals(updatedUser, resultUser);
    }

    @Test
    public void whenDeleteUser_GetUserWithIdOneThrowsException() {
        // Creating user
        userDAO
                .create(user);

        // Deleting 1-st user from db
        userDAO
                .delete(1);

        // Exception, because there are no user with id 1
        assertThrows(DBOperationException.class, () -> userDAO
                .get(1).get());
    }

    @Test
    public void whenDeleteExistingUser_ReturnsTrue() {
        // Creating user
        userDAO
                .create(user);

        // Deleting 1-st user from db
        assertTrue(userDAO
                .delete(1));
    }

    @Test
    public void whenDeleteNotExistingUser_ReturnsTrue() {
        // Deleting not existing user from db
        assertFalse(userDAO
                .delete(1));
    }


    @AfterEach
    public void tearDown() {
        // Cleaning up db
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("DELETE FROM Users");
        template.update("ALTER TABLE Users AUTO_INCREMENT = 1");
    }



}
