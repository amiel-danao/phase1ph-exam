CREATE DATABASE IF NOT EXISTS restapi;
USE restapi;
CREATE TABLE IF NOT EXISTS responses (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  response VARCHAR(100)
);