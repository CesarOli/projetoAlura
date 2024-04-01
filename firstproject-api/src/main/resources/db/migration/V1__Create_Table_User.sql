CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    username VARCHAR(20) UNIQUE,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    roles VARCHAR(255),
    date DATE
);
