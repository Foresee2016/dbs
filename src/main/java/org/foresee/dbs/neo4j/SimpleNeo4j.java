package org.foresee.dbs.neo4j;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

public class SimpleNeo4j {
	public static final String CYPHER_CREATE_PERSON = "CREATE (p:Person {name: {name}, born: {born}})";
	public static final String CYPHER_CREATE_RELATION = "match (p:Person {name:{name}}),"
			+ "(m:Movie {title:{title}}) create (p)-[:ACTOR {roles:[{roles}]->(m)";
	public static final String CYPHER_QUERY_PERSON = "match (p:Person) where p.name={name} return p.name as name, p.born as born";
	public static final String CYPHER_QUERY_ALL_PERSON = "match (p:Person) return p.name as name, p.born as born";
	public static final String CYPHER_QUERY_ACT_IN = "match (p {name:{name}})-[r:ACTOR]-(m) "
			+ "return p.name as name, r.roles as roles, m.title as movie, m.tagline as tagline";

	public static void queryAllPerson() {
		Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "foresee"));
		Session session = driver.session();
		// Insert Node
		// session.run(CYPHER_CREATE_PERSON,Values.parameters("name","Arthur","born",1975));
		// Find One
		// StatementResult
		// result=session.run(CYPHER_QUERY_PERSON,Values.parameters("name","Arthur"));
		// Find all name and born
		StatementResult result = session.run(CYPHER_QUERY_ALL_PERSON);
		while (result.hasNext()) {
			Record record = result.next();
			System.out.println(record.get("name").asString() + ": " + record.get("born").asInt());
		}
		session.close();
		driver.close();
	}
	public static void createRelation(String actorName, String movieTitle, String roles) {
		Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "foresee"));
		Session session = driver.session();
		session.run(CYPHER_CREATE_RELATION, 
				Values.parameters("name", actorName,"title",movieTitle,"roles",roles));
		session.close();
		driver.close();
	}
	public static void queryActIn(String actorName) {
		Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "foresee"));
		Session session = driver.session();
		StatementResult result = session.run(CYPHER_QUERY_ACT_IN, Values.parameters("name", actorName));
		while (result.hasNext()) {
			Record record = result.next();
			System.out.println(record.get("name").asString() + " act " + record.get("roles").asList().toString()
					+ " in " + record.get("movie").asString() + ", tagline: " + record.get("tagline").asString());
		}
		session.close();
		driver.close();
	}

	public static void main(String[] args) {
		// queryAllPerson();
		queryActIn("Laurence Fishburne");
	}
}
