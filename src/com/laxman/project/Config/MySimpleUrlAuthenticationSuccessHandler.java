package com.laxman.project.Config;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.laxman.project.entity.start_end;
import com.laxman.project.entity.user;
import com.laxman.project.service.admin_service;
import com.laxman.project.service.student_service;

public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	
	@Autowired 
	private student_service student_service;
	
	@Autowired 
	private admin_service admin_service;
	
	protected Log logger = LogFactory.getLog(this.getClass());
	 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
   
    public static void infoBox(String infoMessage, String titleBar){
    	System.out.println("came here");
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
    	handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }
 
    protected void handle(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication) throws IOException {
  
        String targetUrl = determineTargetUrl(authentication);
 
        if (response.isCommitted()) {
            logger.debug( "Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }
 
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
 
    protected String determineTargetUrl(Authentication authentication) {
        boolean isStudent = false;
        boolean isAdmin = false;
        boolean isMAC = false;
        
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("student")) {
            	isStudent = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("admin")) {
                isAdmin = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("mac")) {
                isMAC = true;
                break;
            }
        }
 
        if (isStudent) {
        	List<start_end> process=admin_service.get_start_end();
        	if(process.size()>0) {
        		long today=System.currentTimeMillis();
        		if(process.get(0).getEnd()>today) {
        			String user_name=authentication.getName();
                	List<user> student=student_service.get_student_id(user_name);
                	int id=student.get(0).getId();
                    return "/s/student?user_id="+id;
        		}else {
        			return "/login";
        		}
    		}else {
    			infoBox("Application process hasn't started","Sorry");
    			return "/login";
    		}
        } else if (isAdmin) {
            return "/a/admin";
        }else if (isMAC) {
            return "/m/";
        } else {
            throw new IllegalStateException();
        }
    }
 
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}
