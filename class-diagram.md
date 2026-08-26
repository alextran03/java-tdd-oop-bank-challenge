```mermaid
classDiagram
    class User {
        <<abstract>>
        -String name
        -String id
        +getName() String
    }

    class Customer {
    }

    class Manager {
        +approveOverdraft(request, account)
        +rejectOverdraft(request)
    }

    class Account {
        <<abstract>>
        -String accountNumber
        -List~Transaction~ transactions
        -Branch branch
        +deposit(amount, date) void
        +withdraw(amount, date) void
        +getBalance() double
        +canWithdraw(amount) boolean
    }

    class SavingsAccount {
        +canWithdraw(amount) boolean
    }

    class CurrentAccount {
        -double overdraftLimit
        +canWithdraw(amount) boolean
    }

    class Transaction {
        -LocalDate date
        -double amount
        -TransactionType type
        +getDate() LocalDate
        +getAmount() double
        +getType() TransactionType
    }

    class TransactionType {
        <<enumeration>>
        CREDIT
        DEBIT
    }

    class Branch {
        -String name
        -String address
    }

    class OverdraftRequest {
        -double requestedAmount
        -OverdraftStatus status
        +approve() void
        +reject() void
    }

    class OverdraftStatus {
        <<enumeration>>
        PENDING
        APPROVED
        REJECTED
    }

    class NotificationService {
        <<interface>>
        +send(message) void
    }

    class SmsNotificationService {
        +send(message) void
    }

    User <|-- Customer
    User <|-- Manager
    Account <|-- SavingsAccount
    Account <|-- CurrentAccount
    NotificationService <|.. SmsNotificationService
    Account "1" *-- "many" Transaction
    Account "1" o-- "1" Branch
    Transaction --> TransactionType
    OverdraftRequest --> OverdraftStatus
    Customer ..> NotificationService : uses
    Manager ..> OverdraftRequest : approves/rejects

