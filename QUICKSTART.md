# Quick Start Guide - Expense Tracker Android App

## For Developers

### Prerequisites
- Android Studio (Arctic Fox or later)
- JDK 11+
- Android SDK API Level 33
- Git

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/satishyalamarthi/Master_Application.git
   cd Master_Application
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory
   - Wait for Gradle sync to complete

3. **Run the app**
   - Connect an Android device or start an emulator
   - Click the "Run" button (green play icon)
   - Select your device/emulator
   - The app will install and launch

### Project Configuration

#### Gradle Files
- `build.gradle` (root) - Project-level build configuration
- `app/build.gradle` - App module dependencies and settings
- `settings.gradle` - Project settings
- `gradle.properties` - Gradle JVM settings

#### Key Dependencies
```gradle
// Room Database
androidx.room:room-runtime:2.5.2
androidx.room:room-ktx:2.5.2

// Lifecycle & ViewModel
androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1
androidx.lifecycle:lifecycle-livedata-ktx:2.6.1

// Coroutines
kotlinx-coroutines-android:1.7.1

// Material Design
com.google.android.material:material:1.9.0
```

## For End Users

### How to Use the App

#### First Time Setup
1. **Add Expense Types**
   - Open the app
   - Tap "Add Expense Type"
   - Enter a category name (e.g., "Food", "Transport", "Entertainment")
   - Tap "Save"
   - Repeat for all your expense categories

2. **Set Monthly Goals** (Optional but recommended)
   - On the main screen, find your expense type
   - Tap "Set Goal"
   - Enter your monthly budget for this category
   - Tap "Save"

#### Daily Use

**Adding an Expense:**
1. Tap "Add Expense" on the main screen
2. Select the expense type from dropdown
3. Enter the amount (e.g., 50.00)
4. Add a description (e.g., "Grocery shopping at Walmart")
5. Tap "Save"

**Viewing Your Expenses:**
1. On the main screen, find the expense type
2. Tap "Expense Details"
3. See all your expenses for that category
4. Check total spent vs your goal

**Tracking Progress:**
- The main screen shows:
  - Each expense type
  - Your monthly goal
  - How much you've actually spent
  - Color coding (if over budget)

### Tips for Best Results
- Set realistic monthly goals based on past spending
- Add expenses as soon as you make them (don't wait!)
- Use clear descriptions so you remember what you bought
- Check your progress regularly (weekly is good)
- Adjust goals if they're too high or too low

### Common Questions

**Q: Can I edit or delete expenses?**
A: Currently, the app supports adding and viewing expenses. Future updates will include edit/delete functionality.

**Q: Can I export my expense data?**
A: Not yet, but this feature is planned for a future release.

**Q: Does the app sync across devices?**
A: No, all data is stored locally on your device.

**Q: What happens if I uninstall the app?**
A: All your data will be lost. Make sure to note important information before uninstalling.

## Troubleshooting

### Build Issues
- **Gradle sync fails**: Check internet connection and try again
- **SDK not found**: Install Android SDK through Android Studio SDK Manager
- **Build version issues**: Make sure you have API Level 33 installed

### Runtime Issues
- **App crashes on launch**: Clear app data in device settings
- **Database errors**: Reinstall the app (data will be lost)
- **UI not updating**: Force close and restart the app

## Development Workflow

### Making Changes

1. **Create a new branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. **Make your changes**
   - Follow the existing MVVM architecture
   - Add necessary DAO methods
   - Update ViewModels
   - Create/modify Activities
   - Update layouts

3. **Test thoroughly**
   - Test on different screen sizes
   - Test with various data inputs
   - Check edge cases (empty lists, large numbers, etc.)

4. **Commit and push**
   ```bash
   git add .
   git commit -m "Description of changes"
   git push origin feature/your-feature-name
   ```

### Code Style
- Use Kotlin idioms
- Follow Material Design guidelines
- Keep functions small and focused
- Use meaningful variable names
- Add comments for complex logic

## Next Steps

### Planned Features
- [ ] Edit existing expenses
- [ ] Delete expenses
- [ ] Monthly/yearly reports
- [ ] Charts and graphs
- [ ] Export to CSV
- [ ] Recurring expenses
- [ ] Categories with icons
- [ ] Dark mode
- [ ] Cloud backup

### Contributing
Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request
5. Wait for review

## Support

For issues or questions:
- Open an issue on GitHub
- Check existing issues first
- Provide detailed information about the problem
- Include steps to reproduce
- Mention your device/Android version

## License
MIT License - See LICENSE file for details
