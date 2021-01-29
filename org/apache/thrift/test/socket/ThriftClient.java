package org.apache.thrift.test.socket;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author LWC
 * @date 2020/8/11 6:05 下午
 */
public class ThriftClient {
    public static void main(String[] args) {

        TTransport tTransport = null;
        TSocket tSocket = null;
        try {
            tSocket = new TSocket("127.0.0.1",9093);
            tTransport = new TFramedTransport(tSocket);
            TProtocol protocol = new TBinaryProtocol(tTransport);

            Hello.Iface client = new Hello.Client(protocol);
            tTransport.open();

            client.sayHello("liweicong");
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != tTransport){
                tTransport.close();
            }
        }
    }
}
