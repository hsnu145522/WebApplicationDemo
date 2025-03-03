CREATE TABLE IF NOT EXISTS users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (username, email, firstname, lastname) VALUES
('aaa-1234', 'aaa@example.com', 'Alex', 'Huang'),
('bbb-5678', 'bbb@example.com', 'Bob', 'Chen'),
('ccc-9527', 'ccc@example.com', 'Cindy', 'Lee');

CREATE TABLE IF NOT EXISTS audit (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  column_name VARCHAR(50) NOT NULL,
  before_value VARCHAR(255),
  after_value VARCHAR(255),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);