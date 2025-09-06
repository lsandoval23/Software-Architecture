# 📚 Library System – SOLID Principles (Java 17 + Maven)

This project is a **library management example** built in **Java 17** using **Maven**.  
It demonstrates the application of **SOLID principles** (SRP, OCP, LSP, ISP, DIP) through a simple use case:  
borrowing books, returning them, calculating fines, and sending notifications.

---


---

## ⚙️ Requirements

- **Java 17** (JDK)  
- **Apache Maven 3.8+**

---

## ▶️ How to Run

1. **Clone the repository** (or copy the project folder):  
   ```bash
   git clone https://github.com/your-username/library-system.git
   cd library-system
   mvn clean compile
   mvn exec:java -Dexec.mainClass="com.library.ui.LibrarySystem"

