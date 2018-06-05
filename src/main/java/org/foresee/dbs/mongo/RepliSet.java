package org.foresee.dbs.mongo;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class RepliSet {
	public static void main(String[] args) {
		// MongoClient has an overloaded function, connect MongoDB replication set.
		List<ServerAddress> seeds=new ArrayList<>();
		seeds.add(new ServerAddress("127.0.0.1", 40000));
		seeds.add(new ServerAddress("127.0.0.1", 40001));
		seeds.add(new ServerAddress("127.0.0.1", 40002));
		MongoClient client=new MongoClient(seeds);
		client.close();
	}
}
