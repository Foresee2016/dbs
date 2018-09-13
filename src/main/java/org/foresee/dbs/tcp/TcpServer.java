package org.foresee.dbs.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) {
		TcpServer server;
		try {
			server = new TcpServer();
			server.service();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int port = 2018;
	private int backlog = 3;
	private ServerSocket serverSocket;

	public TcpServer() throws IOException {
		serverSocket = new ServerSocket(port, backlog);
		System.out.println("TCP Server 开启，port = " + port + ", backlog = " + backlog);
	}

	public void service() {
		Socket sock = null;
		try {
			sock = serverSocket.accept();
			System.out.println("New Connection: " + sock.getInetAddress() + ":" + sock.getPort());
			OutputStream out = sock.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			writer.println("Hello, You success connected.");
			writer.flush();
			InputStream in = sock.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String data = null;
			while ((data = reader.readLine()) != null) {
				System.out.println("Received: " + data);
				writer.println("Received Length: " + data.length());
				writer.flush();
				if (data.trim() == "exit") {
					break;
				}
			}
			reader.close();
			writer.close();
			in.close();
			out.close();
		} catch (IOException e1) {
			System.out.println("Connection Error:" + e1.getMessage());
		} finally {
			if (sock != null && !sock.isClosed()) {
				try {
					sock.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Tcp Server Exit");
	}
}
