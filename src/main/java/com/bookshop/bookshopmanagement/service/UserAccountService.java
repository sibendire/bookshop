import com.bookshop.bookshopmanagement.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    public void registerUser(UserAccount userAccount) {
        // Validate user input
        if (isValidUser(userAccount)) {
            // Hash the password
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));

            // Save the user account
            userAccountRepository.save(userAccount);
        }
    }

    // Add validation logic here...

    private boolean isValidUser(UserAccount userAccount) {
        // Implement user input validation logic (e.g., password requirements)
        return true; // Return true if the user is valid, false otherwise
    }
}
