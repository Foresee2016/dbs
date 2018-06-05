package org.foresee.dbs.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class SimpleMongo {
	public static void main(String[] args) {
		MongoClient client = new MongoClient("localhost", 27017); //服务器地址(可以远程地址) 和 端口
		MongoDatabase database = client.getDatabase("learn");
		System.out.println("Successful connect to 'learn'");
		// database.createCollection("db_name"); //创建集合
		MongoCollection<Document> collection = database.getCollection("users"); // 获取集合
		// 插入文档
		/**
		 * 1. 创建文档 org.bson.Document 参数为key-value的格式 2. 创建文档集合List<Document> 3.
		 * 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用
		 * mongoCollection.insertOne(Document)
		 */
		Document document = new Document("title", "MongoDB").append("description", "database description")
				.append("likes", 100).append("by", "Fly");
		List<Document> documents = new ArrayList<Document>();
		documents.add(document);
		collection.insertMany(documents);
		//collection.insertOne(document);
		System.out.println("文档插入成功");
		// 检索所有文档
		/**
		 * collection.findOne() 返回单个对象，新版本没了，可以用find().first()代替
		 * find() 返回游标，出于效率考虑，迭代地批量返回查询结果
		 * 1. 获取迭代器FindIterable<Document> 2. 获取游标MongoCursor<Document> 3.
		 * 通过游标遍历检索出的文档集合
		 */
		FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		while (mongoCursor.hasNext()) {
			System.out.println(mongoCursor.next());			
		}
		// 更新文档 将文档中likes=100的文档修改为likes=200
		collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));
		
		// 删除符合条件的第一个文档
		// collection.deleteOne(Filters.eq("likes", 200));
		// 删除所有符合条件的文档
		// collection.deleteMany (Filters.eq("likes", 200));
		client.close();
	}
}
