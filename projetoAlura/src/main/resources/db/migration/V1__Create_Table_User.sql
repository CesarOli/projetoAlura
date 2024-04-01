CREATE TABLE IF NOT EXISTS users (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Username VARCHAR(20) NOT NULL,
    Email VARCHAR(255) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Role ENUM('STUDENT', 'INSTRUCTOR', 'ADMIN') NOT NULL,
    CreationDate DATE NOT NULL,
    CONSTRAINT check_username_format CHECK (Username REGEXP '^[a-z]{1,20}$'),
    CONSTRAINT check_email_format CHECK (Email LIKE '%@%.%'),
    CONSTRAINT unique_username_email UNIQUE (Username, Email)
);
