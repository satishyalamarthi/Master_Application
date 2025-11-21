# Master_Application
Expense Tracker Android App

## Overview
A comprehensive Android application for tracking daily expenses. The app allows users to categorize expenses, set monthly goals, and monitor spending patterns.

## Features

### 1. Expense Type Management
- Create custom expense categories (e.g., Food, Transport, Entertainment)
- View all expense types in a organized list
- Each type displays current monthly goal and actual spending

### 2. Expense Entry
- Add new expenses with ease
- Select expense type from dropdown list
- Enter amount and description
- Automatic date tracking

### 3. Monthly Goals
- Set monthly spending goals for each expense type
- Visual comparison of goal vs. actual spending
- Easy goal updates

### 4. Detailed Expense View
- View complete list of expenses by category
- See total spent per category
- Track expense history with dates and descriptions

## Technical Details

### Architecture
- **Pattern**: MVVM (Model-View-ViewModel)
- **Database**: Room Database for local persistence
- **UI**: Material Design components
- **Async Operations**: Kotlin Coroutines
- **Reactive Updates**: LiveData

### Technologies Used
- **Language**: Kotlin
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 33
- **Key Libraries**:
  - Room Database (2.5.2)
  - Lifecycle Components (2.6.1)
  - Material Components (1.9.0)
  - Coroutines (1.7.1)

## Project Structure

```
app/src/main/java/com/master/expensetracker/
├── model/
│   ├── ExpenseType.kt          # Expense category entity
│   ├── Expense.kt              # Individual expense entity
│   └── ExpenseTypeWithTotal.kt # View model for displaying totals
├── dao/
│   ├── ExpenseTypeDao.kt       # Database operations for expense types
│   └── ExpenseDao.kt           # Database operations for expenses
├── database/
│   └── ExpenseDatabase.kt      # Room database configuration
├── repository/
│   ├── ExpenseTypeRepository.kt # Data layer for expense types
│   └── ExpenseRepository.kt     # Data layer for expenses
├── viewmodel/
│   ├── ExpenseTypeViewModel.kt  # UI logic for expense types
│   └── ExpenseViewModel.kt      # UI logic for expenses
├── adapter/
│   ├── ExpenseTypeAdapter.kt    # RecyclerView adapter for types
│   └── ExpenseAdapter.kt        # RecyclerView adapter for expenses
└── Activities:
    ├── MainActivity.kt              # Main screen with expense types list
    ├── AddExpenseTypeActivity.kt    # Create new expense type
    ├── AddExpenseActivity.kt        # Add new expense
    ├── SetGoalActivity.kt           # Set monthly goals
    └── ExpenseTypeDetailsActivity.kt # View expenses by type
```

## Building the App

### Prerequisites
- Android Studio Arctic Fox or later
- JDK 11 or later
- Android SDK with API Level 33

### Build Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/satishyalamarthi/Master_Application.git
   cd Master_Application
   ```

2. Open the project in Android Studio

3. Sync Gradle files

4. Run the app on an emulator or physical device

### Command Line Build
```bash
./gradlew assembleDebug
```

## Usage

### Getting Started
1. Launch the app
2. Create your first expense type (e.g., "Food", "Transport")
3. Set a monthly goal for the expense type (optional)
4. Add expenses and track your spending!

### Adding Expense Types
1. Click "Add Expense Type" button on the main screen
2. Enter a name for the category
3. Click "Save"

### Adding Expenses
1. Click "Add Expense" button on the main screen
2. Select the expense type from the dropdown
3. Enter the amount
4. Add a description (e.g., "Grocery shopping")
5. Click "Save"

### Setting Goals
1. On the main screen, find your expense type
2. Click "Set Goal" button
3. Enter your monthly budget for this category
4. Click "Save"

### Viewing Details
1. On the main screen, find your expense type
2. Click "Expense Details" button
3. View all expenses for this category with dates and amounts

## Database Schema

### ExpenseType Table
- `id`: Primary key (auto-generated)
- `name`: Expense type name
- `monthlyGoal`: Monthly budget goal

### Expense Table
- `id`: Primary key (auto-generated)
- `typeId`: Foreign key to ExpenseType
- `amount`: Expense amount
- `description`: Expense description
- `date`: Timestamp (auto-generated)

## Future Enhancements
- Monthly/yearly expense reports
- Charts and graphs for spending visualization
- Export data to CSV
- Recurring expense support
- Multi-currency support
- Dark mode theme
- Backup and restore functionality

## License
This project is open source and available under the MIT License.

## Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

