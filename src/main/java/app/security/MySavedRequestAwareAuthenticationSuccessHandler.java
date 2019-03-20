package app.security;

/*import org.springframework.app.security.core.Authentication;
import org.springframework.app.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.app.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.app.security.web.savedrequest.RequestCache;
import org.springframework.app.security.web.savedrequest.SavedRequest;*/
import org.springframework.stereotype.Component;


@Component
public class MySavedRequestAwareAuthenticationSuccessHandler /*extends SimpleUrlAuthenticationSuccessHandler */{

/*
    private RequestCache requestCache = new HttpSessionRequestCache();


    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication)
            throws ServletException, IOException {

        SavedRequest savedRequest
                = requestCache.getRequest(request, response);

        if (savedRequest == null) {
            clearAuthenticationAttributes(request);
            return;
        }
        String targetUrlParam = getTargetUrlParameter();
        if (isAlwaysUseDefaultTargetUrl()
                || (targetUrlParam != null
                && StringUtils.hasText(request.getParameter(targetUrlParam)))) {
            requestCache.removeRequest(request, response);
            clearAuthenticationAttributes(request);
            return;
        }

        clearAuthenticationAttributes(request);
    }


    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }*/
}
