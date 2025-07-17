CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE users (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   email VARCHAR(255) UNIQUE NOT NULL,
   username VARCHAR(255) NOT NULL,
   password TEXT NOT NULL,
   first_name VARCHAR(255),
   last_name VARCHAR(255),
   phone_number VARCHAR(20),
   bio TEXT,
   pfp TEXT,
   is_verified BOOLEAN DEFAULT FALSE,
   is_active BOOLEAN DEFAULT TRUE,
   is_banned BOOLEAN DEFAULT FALSE,
   created_at TIMESTAMP DEFAULT NOW(),
   updated_at TIMESTAMP DEFAULT NOW()
);
