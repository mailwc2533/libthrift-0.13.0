package org.apache.thrift.test.socket;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LWC
 * @date 2020/8/11 6:01 下午
 */
public class ThriftServer {
    static ThreadLocal<String> local = new ThreadLocal<>();
    public static void main(String[] args) throws TTransportException {
        TProcessor processor = new Hello.Processor<>(new HelloImpl());
        TNonblockingServerSocket socket = new TNonblockingServerSocket(9093);
        TNonblockingServer.Args tArgs = new TNonblockingServer.Args(socket);
        tArgs.processor(processor);

        TServer server = new TNonblockingServer(tArgs);
        server.serve();
        System.out.println("server start...");
    }


}
