CREATE SCHEMA test;

CREATE SEQUENCE test.test_entity_seq;
CREATE TABLE test.test_entity (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255) UNIQUE
);

CREATE TABLE test.address(
  id BIGINT PRIMARY KEY,
  city VARCHAR(255)
);

CREATE TABLE test.test_address (
  test_id BIGINT REFERENCES test.test_entity,
  address_id BIGINT REFERENCES test.address,
  PRIMARY KEY (test_id, address_id)
);
