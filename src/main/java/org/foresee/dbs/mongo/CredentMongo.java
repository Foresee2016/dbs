package org.foresee.dbs.mongo;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class CredentMongo {	// 如果需要用户名密码去连接MongoDB
	public static void main(String[] args) {
		ServerAddress address=new ServerAddress("localhost", 27017);	//服务器地址(可以远程地址) 和 端口
		List<ServerAddress> addresses=new ArrayList<>();
		addresses.add(address);
		// 三个参数分别为 用户名 数据库名称(哪里定义的用户) 密码
		MongoCredential credential=MongoCredential.createScramSha1Credential("foresee", "databaseName", "password".toCharArray());
		List<MongoCredential> credentials=new ArrayList<>();
		credentials.add(credential);
		MongoClient client=new MongoClient(addresses, credentials);
		MongoDatabase database=client.getDatabase("learn");
		database.getCollection("users");
		
		System.out.println("Successful connect to 'learn'");
		client.close();
	}
}
