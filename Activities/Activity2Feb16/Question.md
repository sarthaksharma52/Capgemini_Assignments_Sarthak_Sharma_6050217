# Real-Time Practice Problem

## Banking Transaction Logging System

### Problem Title

Secure Banking Log Manager

---

## Background Story

A digital banking platform is facing issues in tracking and auditing user activities such as deposits, withdrawals, transfers, login attempts, and suspicious activities.

The bank wants to build an **in-memory logging system** that:

- Records every user activity
- Allows fast searching of logs
- Maintains logs in chronological order
- Flags suspicious transactions
- Supports extensibility for future log types

As a backend developer, your task is to design and implement this system using **Object-Oriented Programming and Data Structures in Java**.

---

## Functional Requirements

### 1. Log Entry Creation

Each log must contain:

- logId (auto-increment)
- accountNumber
- actionType (DEPOSIT, WITHDRAW, TRANSFER, LOGIN, FAILED_LOGIN)
- amount (0 for non-monetary actions)
- timestamp
- status (SUCCESS or FAILED)

---

### 2. Core Features to Implement

Students must implement the following:

#### Feature 1: Add Log

Add a new log entry to the system.

Requirements:

- Must be stored efficiently
- Must maintain insertion order
- Duplicate logId must not occur

---

#### Feature 2: Get Logs by Account

Given an account number, return all logs for that account.

Performance requirement:

- Should be faster than linear scan if possible

---

#### Feature 3: Recent N Logs

Return the most recent N logs in reverse chronological order.

Hint expectation for students:

- Use appropriate data structure for fast retrieval

---

#### Feature 4: Suspicious Activity Detection

A transaction is suspicious if:

- More than 3 FAILED_LOGIN within last 5 logs of same account
  OR
- Withdrawal amount greater than 50,000

Return list of suspicious logs.

---

#### Feature 5: Search by Action Type

Return all logs of a given action type.

Example:

- All TRANSFER logs
- All FAILED_LOGIN logs

---

## Design Constraints (Important for Students)

Students must:

- Use proper OOP design
- Use encapsulation
- Use at least one interface or abstract class
- Use appropriate data structures (expected but not forced):
  - HashMap for fast account lookup
  - ArrayList or LinkedList for log storage
  - Stack or Deque for recent logs

- No database allowed (in-memory only)
- No built-in logging frameworks

---

## Expected Class Design (Guideline Only)

Students should design something similar to:

- LogEntry (model class)
- LogManager (main service)
- ActionType (enum)
- SuspiciousDetector (separate responsibility preferred)
- Main (driver)

But they are free to improve the design.

---

## Input Simulation (Driver)

Your program should support menu-based simulation:

1. Add Log
2. Get Logs by Account
3. Get Recent Logs
4. Detect Suspicious Activity
5. Search by Action
6. Exit

---

## Sample Scenario

Example flow:

- User adds multiple logs
- System stores them
- Auditor queries account logs
- Fraud system checks suspicious activity
- Admin fetches recent logs

---

## Evaluation Criteria

Students will be evaluated on:

- OOP design quality
- Proper use of enums and classes
- Data structure choice
- Time complexity awareness
- Clean code and modularity
- Edge case handling
- Real-world thinking

---

## Bonus Challenges (For Advanced Students)

Optional but recommended:

1. Make system thread-safe
2. Add log deletion by logId
3. Add pagination support
4. Add memory limit with eviction policy (LRU style)
5. Export logs to file

---