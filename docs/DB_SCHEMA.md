# Database Schema - FitFlow Pro

## Core Tables (Phase 1)

## Phase 1 Tables

### users
- id (BIGINT, PK)
- email (VARCHAR(255), UNIQUE)
- password (VARCHAR(255))
- role (ENUM: MEMBER, TRAINER, ADMIN)
- created_at (TIMESTAMP)
- updated_at (TIMESTAMP)

### members
- id (BIGINT, PK)
- user_id (BIGINT, FK to users)
- first_name (VARCHAR(100))
- last_name (VARCHAR(100))
- phone (VARCHAR(20))
- date_of_birth (DATE)
- join_date (DATE)


### trainers
- id, user_id, specialization, experience, bio, hourly_rate

### membership_plans
- id, name, price, duration_days, features

... (more tables)