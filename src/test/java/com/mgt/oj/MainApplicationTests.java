package com.mgt.oj;

import com.mgt.oj.config.WxOpenConfig;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * 主类测试
 *
 * 
 * 
 */
@SpringBootTest
class MainApplicationTests {

    @Resource
    private WxOpenConfig wxOpenConfig;

    @Test
    void contextLoads() {
        System.out.println(wxOpenConfig);
    }


    @Test
    void getAllIpAddress() {
        try {
            //get all network interface
            Enumeration<NetworkInterface> allNetworkInterfaces =
                    NetworkInterface.getNetworkInterfaces();
            NetworkInterface networkInterface = null;

            //check if there are more than one network interface
            while (allNetworkInterfaces.hasMoreElements()) {
                //get next network interface
                networkInterface = allNetworkInterfaces.nextElement();
                //output interface's name
                System.out.println("network interface: " +
                        networkInterface.getDisplayName());

                //get all ip address that bound to this network interface
                Enumeration<InetAddress> allInetAddress =
                        networkInterface.getInetAddresses();

                InetAddress ipAddress = null;

                //check if there are more than one ip addresses
                //band to one network interface
                while (allInetAddress.hasMoreElements()) {
                    //get next ip address
                    ipAddress = allInetAddress.nextElement();
                    if (ipAddress != null && ipAddress instanceof Inet4Address) {
                        System.out.println("ip address: " +
                                ipAddress.getHostAddress());
                    }
                }
            }

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }// end method getIpAddrByName
}
