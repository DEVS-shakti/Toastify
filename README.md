# 📢 Toastify - Animated Custom Toasts for Android

`Toastify` is a lightweight, customizable Android library written in **Kotlin** that provides beautiful, animated toast notifications.  
It’s inspired by `react-toastify` and makes showing feedback messages in your app easy and elegant.

---

## ✨ Features
- ✅ Multiple toast types:
  - Success  
  - Error / Alert  
  - Neutral (Info/Message)  
- ✅ Distinct styles and icons per type  
- ✅ Queue management → prevents overlapping toasts  
- ✅ Custom durations (`SHORT`, `LONG`, or manual ms)  
- ✅ Position control (`TOP`, `BOTTOM`)  
- ✅ Swipe-to-dismiss gesture  
- ✅ Smooth entry & exit animations  
- ✅ Simple API for integration  
- ✅ Extensible → add new toast types easily  

---

## 📦 Installation

### Option 1: Local Maven (for testing)
1. In `toastify/build.gradle.kts`, we use `maven-publish`.  
2. Run:
   ```bash
   ./gradlew publishToMavenLocal
Add this in your app’s build.gradle.kts or gradle.build:

```
dependencies {
	        implementation 'com.github.DEVS-shakti:Toastify:Tag'
	}
```

Option 2: JitPack (recommended for sharing)

Push your project to GitHub.

Add JitPack repo in settings.gradle.kts:

```
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```


Add dependency:

```
dependencies {
	        implementation 'com.github.DEVS-shakti:Toastify:Tag'
	}
```

🚀 Usage
Show a Success Toast
```
Toastify.success(context, "Login successful!")
```

Show an Error Toast
```
Toastify.error(context, "Something went wrong!")
```

Show a Neutral Toast
```
Toastify.neutral(context, "This is an info message.")
```

Advanced Options
```
Toastify.show(
    context = this,
    message = "Custom duration & bottom position",
    type = ToastType.SUCCESS,
    duration = 5000, // in ms
    position = ToastPosition.BOTTOM
)
```

🎨 Customization

Change colors, icons, and corner radius via XML (toast_layout.xml).

Add more ToastType in ToastType.kt.

Override animations in res/anim/ folder.

🛠️ Example Layout (toast_layout.xml)
```
<com.google.android.material.card.MaterialCardView
    android:id="@+id/statusCard"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="12dp"
    app:cardBackgroundColor="#2C2C2C"
    app:cardCornerRadius="12dp"
    app:cardElevation="6dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:padding="16dp"
        android:gravity="center_vertical">

        <ImageView
            android:id="@+id/statusIcon"
            android:layout_width="24dp"
            android:layout_height="24dp"
            android:src="@android:drawable/ic_dialog_info" />

        <TextView
            android:id="@+id/statusMessage"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="12dp"
            android:layout_weight="1"
            android:textColor="@android:color/white"
            android:textSize="14sp" />
    </LinearLayout>
</com.google.android.material.card.MaterialCardView>
```

📚 Roadmap

 Add warning toast type

 Support custom layouts

 Add dark/light theme support

 Improve swipe-to-dismiss gestures

 Publish to Maven Central

🤝 Contributing

Fork the repo

Create a feature branch (git checkout -b feature/my-feature)

Commit your changes

Push and create a Pull Request



