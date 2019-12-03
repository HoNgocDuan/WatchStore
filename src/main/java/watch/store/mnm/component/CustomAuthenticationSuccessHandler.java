package watch.store.mnm.component;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if(roles.size()==1) {
            if(roles.contains("ROLE_CASHIER")) {
                response.sendRedirect("/cashier");
            }
            if(roles.contains("ROLE_ACCOUNTANT")) {
                response.sendRedirect("/accountant");
            }
            if(roles.contains("ROLE_EMPLOYEE")) {
                response.sendRedirect("/employee");
            }
            if(roles.contains("ROLE_ADMIN")) {
                response.sendRedirect("/admin");
            }
        } else if (roles.size()>1){
            if(roles.contains("ROLE_ADMIN")) {
                response.sendRedirect("/admin");
            }
        }


    }
}

