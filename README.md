# Core Java & Multithreading

A hands-on practice repo for Core Java fundamentals, covering **OOP**, **Multithreading**, and **Java 8** features — structured using standard Java package conventions (`com.java8.*`) and runnable directly via `javac` in the terminal (VSCode-friendly, no build tool required).


## 📁 Project Structure

```
./
└── com/
    └── java8/
        ├── MyMain.java                          # Entry point — swap imports to run different examples
        ├── classobject/
        │   └── MyClassObject.java               # OOP: encapsulation, constructors, toString
        └── multithreading/
            └── MultithreadingUsingSynchronized.java  # Odd/even printing using synchronized + wait/notify
```


## ⚡ How to Run (VSCode Terminal / `javac`)

From the **repo root** (wherever you cloned this repo):

```bash
# 1. Compile all Java files
javac -d . com/java8/MyMain.java com/java8/classobject/MyClassObject.java com/java8/multithreading/MultithreadingUsingSynchronized.java

# 2. Run the entry point
java com.java8.MyMain
```

> **Tip:** The `-d .` flag outputs `.class` files into the correct package directory structure automatically.


## 📚 Topics Covered

| Topic | File | Concept |
|-------|------|---------|
| OOP / Class & Object | `classobject/MyClassObject.java` | Encapsulation, constructors, getter/setter, `toString()` |
| Multithreading | `multithreading/MultithreadingUsingSynchronized.java` | `synchronized` block, `wait()`, `notify()`, odd-even thread coordination |

## 🛠️ Environment

- **Language:** Java 8+
- **Editor:** VSCode (lightweight, no IDE overhead)
- **Compiler:** `javac` via terminal
- **Version Control:** Git + GitHub