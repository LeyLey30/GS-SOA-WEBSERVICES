CREATE TABLE IF NOT EXISTS tasks (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(150) NOT NULL,
  description TEXT,
  status VARCHAR(50),
  priority VARCHAR(50),
  due_date DATETIME,
  owner_email VARCHAR(255),
  owner_phone VARCHAR(50)
);
