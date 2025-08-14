# 📦 Courier Service Management System

The Courier Service Management System is an application designed to  
assist employees of a courier company in efficiently managing packages  
and tracking their statuses. The system enables employees to estimate  
costs, record package details, update delivery statuses, and search or  
display package history. The application will be implemented following  
Object-Oriented Programming principles and storing data in a database.

## Features to be Implemented:

### 1. Cost Estimation
- **Input:** Package weight  
- **Output:** Estimated delivery cost (based on a fixed formula or pricing  
table)

### 2. Add Package Record
- **Input:** Weight, description, destination, mailed date, expected arrival  
date  
- Unique tracking ID  
- Data is saved persistently

### 3. Update Package Status
- Modify package status (e.g., Packed, In Transit, Delivered)  
- Optionally update expected arrival date  
- Update timestamp for last change

### 4. Display All Packages
- Show: Description, weight, destination, current status, expected date,  
last update time  
- Displayed in a table with sortable columns

### 5. Search Package by Tracking ID
- Search bar for ID input  
- Result: Full details + tracking history

### 6. Remove Package
- **Input:** Tracking ID  
- **Action:** Delete from system

## 🛠️ How to Compile and Run

From the root directory of the project (where the `courier/` folder is located):

```bash
javac courier/**/*.java
java courier.App
