package org.allen.utility.utils;

import org.junit.Test;

import static org.junit.Assert.*;


public class IpUtilTest {

    @Test
    public void testIsIpV4() {
        assertTrue(IpUtil.isIpV4("127.0.0.1"));
        assertTrue(IpUtil.isIpV4("255.255.255.255"));
        assertFalse(IpUtil.isIpV4("256.255.255.255"));
        assertFalse(IpUtil.isIpV4("fe80::47e:316b:3930:b91f%19"));
    }

    @Test
    public void testIsLocalhost() {
        assertTrue(IpUtil.isLocalhost("127.0.0.1"));
        assertTrue(IpUtil.isLocalhost("127.1.0.1"));
        assertTrue(IpUtil.isLocalhost("localhost"));
        assertTrue(IpUtil.isLocalhost("LOCALHOST"));
        assertFalse(IpUtil.isLocalhost("1.1.1.1"));
    }

    @Test
    public void testPrivateIp() {
        assertTrue(IpUtil.isPrivateIP("10.111.12.13"));
        assertFalse(IpUtil.isPrivateIP("11.111.12.13"));
        assertTrue(IpUtil.isPrivateIP("172.16.9.9"));
        assertTrue(IpUtil.isPrivateIP("172.31.12.13"));
        assertFalse(IpUtil.isPrivateIP("172.32.12.13"));
        assertTrue(IpUtil.isPrivateIP("192.168.1.1"));
        assertFalse(IpUtil.isPrivateIP("192.169.1.1"));
    }
}
