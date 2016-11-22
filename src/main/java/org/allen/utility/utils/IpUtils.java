package org.allen.utility.utils;

import sun.net.util.IPAddressUtil;

/**
 * ip地址工具类
 */
public class IpUtils {

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

}
