package ro.sci.config;

import javax.servlet.*;
import java.io.IOException;

public class RequestFilter implements Filter {

        @Override
        public void destroy() {
            // ...
        }

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            //
        }

        @Override
        public void doFilter(ServletRequest request,
                             ServletResponse response, FilterChain chain)
                throws IOException, ServletException {

            try {
                chain.doFilter(request, response);
            } catch (Exception ex) {
                request.setAttribute("errorMessage", ex);
                request.getRequestDispatcher("/WEB-INF/views/jsp/error.jsp")
                        .forward(request, response);
            }

        }

}
