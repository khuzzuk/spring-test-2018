CREATE SCHEMA test;

CREATE SEQUENCE test.test_entity_seq;
CREATE TABLE test.test_entity(
  id BIGINT PRIMARY KEY,
  name VARCHAR(255) UNIQUE
);
