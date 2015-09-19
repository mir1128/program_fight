package net.fight.filter;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

public abstract class IgnorableFilter extends GenericFilterBean {
    private String[] ignore = new String[0];

    public void setIgnore(String[] ignore) {
        this.ignore = ignore.clone();
    }

    protected boolean isIgnored(ServletRequest request) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();
        for (String pattern : ignore) {
            if (Pattern.compile(httpServletRequest.getContextPath() + pattern).matcher(requestURI).matches()) {
                return true;
            }
        }
        return false;
    }

    protected boolean isRequestedByAjax(HttpServletRequest httpServletRequest) {
        return "XMLHttpRequest".equals(httpServletRequest.getHeader("X-Requested-With"));
    }
}
