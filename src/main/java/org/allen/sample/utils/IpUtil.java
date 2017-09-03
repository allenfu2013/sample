package org.allen.sample.utils;

import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ip地址工具类
 */
public class IpUtil {

    /**
     * 是否IP V4
     *
     * @param ipAddress
     * @return
     */
    public static boolean isIpV4(String ipAddress) {
        return IPAddressUtil.isIPv4LiteralAddress(ipAddress);
    }

    /**
     * 是否本地地址
     *
     * @param ipAddress
     * @return
     */
    public static boolean isLocalhost(String ipAddress) {
        return "localhost".equalsIgnoreCase(ipAddress) || (isIpV4(ipAddress) && ipAddress.startsWith("127."));
    }

    /**
     * 私有IP地址范围：
     * A类：10.0.0.0-10.255.255.255
     * B类：172.16.0.0-172.31.255.255
     * C类：192.168.0.0-192.168.255.255
     *
     * @param ipAddress
     * @return
     */
    public static boolean isPrivateIP(String ipAddress) {
        if (isIpV4(ipAddress)) {
            String[] ipParts = ipAddress.split("\\.");
            String ipPart1 = ipParts[0];
            String ipPart2 = ipParts[1];
            int ipPart2Int = Integer.parseInt(ipPart2);
            return "10".equals(ipPart1)
                    || ("172".equals(ipPart1) && ipPart2Int >= 16 && ipPart2Int <= 31)
                    || ("192".equals(ipPart1) && "168".equals(ipPart2));
        }
        return false;
    }

    /**
     * 获取客户端IP地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ipAddress = null;
        ipAddress = request.getHeader("X-Forwarded-For");
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && !"unKnown".equalsIgnoreCase(ipAddress)) {
            int index = ipAddress.indexOf(",");
            if (index != -1) {
                ipAddress = ipAddress.substring(0, index);
            }
        } else {
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unKnown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("X-Real-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    //根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
        }

        return ipAddress;
    }

}
