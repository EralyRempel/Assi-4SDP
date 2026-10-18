Assignment #4: Facade Design Pattern
Course: Software Design Patterns  
Topic: Loan Processing System (Banking Domain)

---

Project Structure
The project is structured into clean, logical packages to avoid tight coupling and ensure professional architecture:
- `background` — contains the complex subsystem classes with real non-trivial responsibilities:
  - `FraudDetector` — checks client data against security and fraud databases.
  - `CreditScoreVerifier` — evaluates the client's credit history and score.
  - `AccountManager` — verifies income and financial stability.
  - `ContractGenerator` — creates and formats the official credit contract upon approval.
- `facade` — contains the core simplified interface:
  - `LoanApplicationFacade` — coordinates the subsystem classes in the correct sequence.
- **Root (`src`)** — contains the entry point (`Main.java`) representing the client code.

---

## Getting Started / Instructions
1. Open the project in IntelliJ IDEA or any Java IDE.
2. Ensure the packages `background` and `facade` are located inside the `src` directory.
3. Run the `Main.java` class to see the simulation of successful and rejected loan applications processed through the Facade.

---

## Clean Code Principles

In accordance with the assignment requirements, the following 5 Clean Code principles are implemented and justified in this project:

### 1. Meaningful, intention-revealing names
* **Description:** Class and method names clearly reflect their domain purpose without requiring redundant explanatory comments.
* **Code Example:**
  ```java
 The method name immediately explains its purpose to the client
  public boolean processLoanApplication(String clientName, String passportId, double requestedAmount) { ... }
2. Single Responsibility Principle (SRP)
Description: The Facade class strictly focuses on coordination and workflow orchestration, whereas each subsystem class handles only its specific domain logic (e.g., fraud checking or contract generation).

Code Example:

Java
// FraudDetector handles ONLY security validation, leaving scoring and accounting to other classes
public class FraudDetector {
    public boolean checkClient(String clientName, String passportId) { ... }
}
3. No leaking of subsystem details
Description: The client code interacts exclusively with the LoanApplicationFacade and remains completely unaware of internal subsystem components (FraudDetector, AccountManager, etc.).

Code Example:

Java
// Client talks ONLY to the Facade, never instantiating or calling subsystem classes directly
LoanApplicationFacade loanFacade = new LoanApplicationFacade();
loanFacade.processLoanApplication("John Doe", "KZ1234567", 1500000.0);
4. Small, focused subsystem classes
Description: Each class in the subsystem has a single, well-defined responsibility with high cohesion and low complexity, making unit testing and maintenance straightforward.

5. Correct sequential coordination & validation flow
Description: The Facade enforces strict order execution (e.g., checking fraud and credit score before generating a contract), protecting the system from invalid states and handling failures gracefully.
