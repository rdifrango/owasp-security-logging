package org.owasp.security.logging.mdc;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.MDC;

/**
 * This plugin adds the request's remote IP address to the MDC in the most basic
 * way possible: By calling request.getRemoteAddr(). The value can 
 * be accessed in a PatternLayout by using the specifier: %X{ipAddress}
 * 
 * For environments that determine the request IP address by using the value of a 
 * header appended by a load balancer (e.g. X-Forwarded-For), see ForwardedIPAddressPlugin. 
 * 
 * @author August Detlefsen <augustd@codemagi.com>
 * @see ForwardedIPAddressPlugin
 */
public class IPAddressPlugin implements IPlugin {

    public void execute(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        MDC.put(MDCFilter.IPADDRESS, ipAddress);
    }
    
}
