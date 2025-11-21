# App Screens Overview

## Main Screen (MainActivity)
```
┌─────────────────────────────────────┐
│  Expense Tracker           [≡]      │
├─────────────────────────────────────┤
│                                     │
│  ┌───────────────────────────────┐ │
│  │ Food                          │ │
│  │ Goal:   $1000.00              │ │
│  │ Actual:  $750.00              │ │
│  │ ┌──────────┐  ┌─────────────┐│ │
│  │ │Set Goal  │  │  Details    ││ │
│  │ └──────────┘  └─────────────┘│ │
│  └───────────────────────────────┘ │
│                                     │
│  ┌───────────────────────────────┐ │
│  │ Transport                     │ │
│  │ Goal:    $500.00              │ │
│  │ Actual:  $300.00              │ │
│  │ ┌──────────┐  ┌─────────────┐│ │
│  │ │Set Goal  │  │  Details    ││ │
│  │ └──────────┘  └─────────────┘│ │
│  └───────────────────────────────┘ │
│                                     │
│  ┌───────────────────────────────┐ │
│  │ Entertainment                 │ │
│  │ Goal:    $200.00              │ │
│  │ Actual:  $150.00              │ │
│  │ ┌──────────┐  ┌─────────────┐│ │
│  │ │Set Goal  │  │  Details    ││ │
│  │ └──────────┘  └─────────────┘│ │
│  └───────────────────────────────┘ │
│                                     │
├─────────────────────────────────────┤
│  ┌───────────────────────────────┐ │
│  │    Add Expense Type           │ │
│  └───────────────────────────────┘ │
│  ┌───────────────────────────────┐ │
│  │    Add Expense                │ │
│  └───────────────────────────────┘ │
└─────────────────────────────────────┘
```

## Add Expense Type Screen
```
┌─────────────────────────────────────┐
│  ← Add Expense Type                 │
├─────────────────────────────────────┤
│                                     │
│  ┌───────────────────────────────┐ │
│  │ Expense Type Name             │ │
│  │ ┌───────────────────────────┐ │ │
│  │ │ e.g., Food, Transport     │ │ │
│  │ └───────────────────────────┘ │ │
│  └───────────────────────────────┘ │
│                                     │
│  ┌───────────────────────────────┐ │
│  │           Save                │ │
│  └───────────────────────────────┘ │
│                                     │
└─────────────────────────────────────┘
```

## Add Expense Screen
```
┌─────────────────────────────────────┐
│  ← Add Expense                      │
├─────────────────────────────────────┤
│                                     │
│  Select Type                        │
│  ┌───────────────────────────────┐ │
│  │ Food                      ▼   │ │
│  └───────────────────────────────┘ │
│                                     │
│  ┌───────────────────────────────┐ │
│  │ Amount                        │ │
│  │ ┌───────────────────────────┐ │ │
│  │ │ 50.00                     │ │ │
│  │ └───────────────────────────┘ │ │
│  └───────────────────────────────┘ │
│                                     │
│  ┌───────────────────────────────┐ │
│  │ Description                   │ │
│  │ ┌───────────────────────────┐ │ │
│  │ │ Grocery shopping          │ │ │
│  │ │                           │ │ │
│  │ └───────────────────────────┘ │ │
│  └───────────────────────────────┘ │
│                                     │
│  ┌───────────────────────────────┐ │
│  │           Save                │ │
│  └───────────────────────────────┘ │
│                                     │
└─────────────────────────────────────┘
```

## Set Goal Screen
```
┌─────────────────────────────────────┐
│  ← Set Goal                         │
├─────────────────────────────────────┤
│                                     │
│     Set Goal for Food               │
│                                     │
│  ┌───────────────────────────────┐ │
│  │ Monthly Goal                  │ │
│  │ ┌───────────────────────────┐ │ │
│  │ │ 1000.00                   │ │ │
│  │ └───────────────────────────┘ │ │
│  └───────────────────────────────┘ │
│                                     │
│  ┌───────────────────────────────┐ │
│  │           Save                │ │
│  └───────────────────────────────┘ │
│                                     │
└─────────────────────────────────────┘
```

## Expense Details Screen
```
┌─────────────────────────────────────┐
│  ← Expense Details                  │
├─────────────────────────────────────┤
│                                     │
│        Food Expenses                │
│                                     │
│  Monthly Goal:      $1000.00        │
│  Total Spent:        $750.00        │
│                                     │
├─────────────────────────────────────┤
│  ┌───────────────────────────────┐ │
│  │ $50.00         Nov 21, 2024   │ │
│  │ Grocery shopping at Walmart   │ │
│  └───────────────────────────────┘ │
│                                     │
│  ┌───────────────────────────────┐ │
│  │ $35.50         Nov 20, 2024   │ │
│  │ Lunch at restaurant           │ │
│  └───────────────────────────────┘ │
│                                     │
│  ┌───────────────────────────────┐ │
│  │ $120.00        Nov 18, 2024   │ │
│  │ Weekly groceries              │ │
│  └───────────────────────────────┘ │
│                                     │
│  ┌───────────────────────────────┐ │
│  │ $25.00         Nov 15, 2024   │ │
│  │ Coffee and snacks             │ │
│  └───────────────────────────────┘ │
│                                     │
└─────────────────────────────────────┘
```

## Navigation Flow
```
┌─────────────┐
│   Main      │
│   Screen    │
└──────┬──────┘
       │
       ├──────────┬──────────┬──────────┐
       │          │          │          │
       ▼          ▼          ▼          ▼
┌───────────┐ ┌────────┐ ┌────────┐ ┌──────────┐
│   Add     │ │  Add   │ │  Set   │ │ Expense  │
│ Expense   │ │Expense │ │  Goal  │ │ Details  │
│   Type    │ │        │ │        │ │          │
└───────────┘ └────────┘ └────────┘ └──────────┘
```

## User Journey Example

### First Time User
1. **Start App** → See empty state message
2. **Tap "Add Expense Type"** → Enter "Food" → Save
3. **Tap "Add Expense Type"** → Enter "Transport" → Save
4. **Back to Main Screen** → See 2 expense types (goal: $0, actual: $0)
5. **Tap "Set Goal" on Food** → Enter $1000 → Save
6. **Tap "Add Expense"** → Select "Food" → Enter $50 → "Groceries" → Save
7. **Main Screen** → See Food (Goal: $1000, Actual: $50)
8. **Tap "Details" on Food** → See list with one expense

### Daily User Flow
1. **Made a purchase** → Open app
2. **Tap "Add Expense"** → Select category → Enter amount & description → Save
3. **Check progress** → View updated totals on main screen
4. **Monthly review** → Tap "Details" on each category to see spending patterns

## Design Features

### Color Coding (Planned Enhancement)
- **Green**: Under budget (actual < goal)
- **Yellow**: Close to budget (80-100% of goal)
- **Red**: Over budget (actual > goal)

### Material Design Elements
- **Cards**: Expense types and individual expenses
- **FAB**: Could be used for quick expense entry (future)
- **Bottom Navigation**: For multiple sections (future)
- **Chips**: For expense categories (future)

### Empty States
- "No expense types. Please add one first."
- "No expenses found"

### Validation Messages
- "Please enter a name"
- "Please enter an amount"
- "Please select an expense type"
