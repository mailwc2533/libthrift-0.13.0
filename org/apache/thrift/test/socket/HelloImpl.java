package org.apache.thrift.test.socket;

import org.apache.thrift.TException;

/**
 * @author LWC
 * @date 2020/8/11 6:01 下午
 */
public class HelloImpl implements Hello.Iface{
    @Override
    public void sayHello(String s) throws TException {
        System.out.println("server：" + s);
    }
}
