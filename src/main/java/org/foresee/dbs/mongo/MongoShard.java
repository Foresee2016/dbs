package org.foresee.dbs.mongo;

import java.util.Date;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoShard {
	public static void main(String[] args) {
		MongoClient client = new MongoClient("localhost", 40000); // 服务器地址(可以远程地址)
																	// 和 端口
		MongoDatabase database = client.getDatabase("cloud-docs");
		MongoCollection<Document> collection = database.getCollection("spreadsheets"); // 获取集合
		for (int i = 0; i < 50000; i++) { // insert 200 doc
			String data = new String();
			for (int j = 0; j < 1000; j++) {
				data += "abcde";
			}
			Document doc = new Document("filename", "sheet-" + i).append("updated_at", new Date())
					.append("username", "banks").append("data", data);
			collection.insertOne(doc);
		}
		client.close();
	}
}
