CREATE KEYSPACE cassandra_poc WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE book (
	isbn text,
	title text,
	author text,
	edition text,
	year int,
	price double,
	PRIMARY KEY (isbn)
);