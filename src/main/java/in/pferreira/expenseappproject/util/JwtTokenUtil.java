package in.pferreira.expenseappproject.util;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {
    public String generateToken(UserDetails userDetails) {
        return null;
    }
}