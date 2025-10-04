# Database Schema - FitFlow Pro

## Core Tables (Phase 1)

### users
- id, email, password, role, created_at, updated_at

### members
- id, user_id, first_name, last_name, phone, date_of_birth, join_date

### trainers
- id, user_id, specialization, experience, bio, hourly_rate

### membership_plans
- id, name, price, duration_days, features

... (more tables)