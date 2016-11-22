package org.allen.utility.utils;

import org.junit.Test;

import static org.junit.Assert.*;


public class IpUtilsTest {

    @Test
    public void testIsIpV4() {
        assertTrue(IpUtils.isIpV4("127.0.0.1"));
        assertTrue(IpUtils.isIpV4("255.255.255.255"));
        assertFalse(IpUtils.isIpV4("256.255.255.255"));
        assertFalse(IpUtils.isIpV4("fe80::47e:316b:3930:b91f%19"));
    }

    @Test
    public void testIsLocalhost() {
        assertTrue(IpUtils.isLocalhost("127.0.0.1"));
        assertTrue(IpUtils.isLocalhost("127.1.0.1"));
        assertTrue(IpUtils.isLocalhost("localhost"));
        assertTrue(IpUtils.isLocalhost("LOCALHOST"));
        assertFalse(IpUtils.isLocalhost("1.1.1.1"));
    }

    @Test
    public void testPrivateIp() {
        assertTrue(IpUtils.isPrivateIP("10.111.12.13"));
        assertFalse(IpUtils.isPrivateIP("11.111.12.13"));
        assertTrue(IpUtils.isPrivateIP("172.16.9.9"));
        assertTrue(IpUtils.isPrivateIP("172.31.12.13"));
        assertFalse(IpUtils.isPrivateIP("172.32.12.13"));
        assertTrue(IpUtils.isPrivateIP("192.168.1.1"));
        assertFalse(IpUtils.isPrivateIP("192.169.1.1"));
    }
}
