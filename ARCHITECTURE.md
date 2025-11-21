# Expense Tracker App - User Flow & Architecture

## User Flow Diagram

```
┌─────────────────────────────────────────┐
│          MainActivity                    │
│  ┌────────────────────────────────┐    │
│  │   Expense Types List            │    │
│  │   ┌──────────────────────┐     │    │
│  │   │ Food                 │     │    │
│  │   │ Goal: $1000          │     │    │
│  │   │ Actual: $750         │     │    │
│  │   │ [Set Goal] [Details] │     │    │
│  │   └──────────────────────┘     │    │
│  │   ┌──────────────────────┐     │    │
│  │   │ Transport            │     │    │
│  │   │ Goal: $500           │     │    │
│  │   │ Actual: $300         │     │    │
│  │   │ [Set Goal] [Details] │     │    │
│  │   └──────────────────────┘     │    │
│  └────────────────────────────────┘    │
│  [Add Expense Type]                     │
│  [Add Expense]                          │
└─────────────────────────────────────────┘
         │              │              │
         │              │              │
         ▼              ▼              ▼
    ┌─────────┐  ┌──────────┐  ┌──────────────┐
    │ Add     │  │ Add      │  │ Set Goal     │
    │ Expense │  │ Expense  │  │ Activity     │
    │ Type    │  │ Activity │  │              │
    └─────────┘  └──────────┘  └──────────────┘
                      │
                      ▼
              ┌────────────────┐
              │ Expense Type   │
              │ Details        │
              │ Activity       │
              │                │
              │ List of all    │
              │ expenses for   │
              │ this type      │
              └────────────────┘
```

## Architecture Layers

```
┌─────────────────────────────────────────────────────────┐
│                    UI Layer (Activities)                 │
│  MainActivity | AddExpenseTypeActivity | AddExpenseActivity│
│  SetGoalActivity | ExpenseTypeDetailsActivity            │
└─────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────┐
│                  ViewModel Layer                         │
│         ExpenseTypeViewModel | ExpenseViewModel          │
│              (LiveData + Coroutines)                     │
└─────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────┐
│                 Repository Layer                         │
│    ExpenseTypeRepository | ExpenseRepository             │
└─────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────┐
│                   DAO Layer                              │
│           ExpenseTypeDao | ExpenseDao                    │
└─────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────┐
│                Room Database                             │
│         ExpenseType Table | Expense Table                │
└─────────────────────────────────────────────────────────┘
```

## Data Flow

### Adding a New Expense Type
```
User Input → AddExpenseTypeActivity → ExpenseTypeViewModel.insert()
→ ExpenseTypeRepository.insert() → ExpenseTypeDao.insert()
→ Room Database → LiveData Update → MainActivity UI Refresh
```

### Adding a New Expense
```
User Input → AddExpenseActivity → Select Type from Spinner
→ Enter Amount & Description → ExpenseViewModel.insert()
→ ExpenseRepository.insert() → ExpenseDao.insert()
→ Room Database → LiveData Update → UI Refresh
```

### Setting a Goal
```
User Input → SetGoalActivity → ExpenseTypeViewModel.updateMonthlyGoal()
→ ExpenseTypeRepository.updateMonthlyGoal() → ExpenseTypeDao.updateMonthlyGoal()
→ Room Database → LiveData Update → MainActivity UI Refresh
```

### Viewing Details
```
Click Details → ExpenseTypeDetailsActivity → Observe LiveData
→ ExpenseViewModel.getExpensesByType() → Room Query
→ Update RecyclerView with Expense List
```

## Key Components

### Database Schema
```
ExpenseType
├── id (Long, Primary Key)
├── name (String)
└── monthlyGoal (Double)

Expense
├── id (Long, Primary Key)
├── typeId (Long, Foreign Key → ExpenseType)
├── amount (Double)
├── description (String)
└── date (Long, Timestamp)
```

### RecyclerView Adapters
- **ExpenseTypeAdapter**: Displays expense types with goals and actual amounts
- **ExpenseAdapter**: Displays individual expenses with date and description

## Features Implementation Status

✅ Create expense types
✅ Add expenses with type selection
✅ Set monthly goals per type
✅ View expense types with goal vs actual
✅ View detailed expense list per type
✅ Automatic date tracking
✅ Currency formatting
✅ Input validation
✅ Material Design UI
✅ Back navigation support
