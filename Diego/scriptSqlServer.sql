CREATE TABLE [users] (
  [id] BIGINT PRIMARY KEY IDENTITY(1, 1),
  [name] VARCHAR(150) NOT NULL,
  [email] VARCHAR(150) UNIQUE NOT NULL,
  [password] VARCHAR(255) NOT NULL,
  [status] nvarchar(255) NOT NULL CHECK ([status] IN ('ACTIVE', 'INACTIVE')) DEFAULT 'ACTIVE',
  [created_at] TIMESTAMP DEFAULT (CURRENT_TIMESTAMP)
)
GO

CREATE TABLE [accounts] (
  [id] BIGINT PRIMARY KEY IDENTITY(1, 1),
  [user_id] BIGINT NOT NULL,
  [name] VARCHAR(100) NOT NULL,
  [account_type] nvarchar(255) NOT NULL CHECK ([account_type] IN ('SAVINGS', 'CHECKING', 'CREDIT_CARD', 'CASH', 'DIGITAL_WALLET')) NOT NULL,
  [balance] DECIMAL(15,2) DEFAULT (0),
  [currency] VARCHAR(10) DEFAULT 'COP',
  [created_at] TIMESTAMP DEFAULT (CURRENT_TIMESTAMP)
)
GO

CREATE TABLE [categories] (
  [id] BIGINT PRIMARY KEY IDENTITY(1, 1),
  [name] VARCHAR(100) NOT NULL,
  [type] nvarchar(255) NOT NULL CHECK ([type] IN ('INCOME', 'EXPENSE')) NOT NULL,
  [color] VARCHAR(20),
  [icon] VARCHAR(100)
)
GO

CREATE TABLE [merchants] (
  [id] BIGINT PRIMARY KEY IDENTITY(1, 1),
  [name] VARCHAR(150) NOT NULL,
  [merchant_type] VARCHAR(100)
)
GO

CREATE TABLE [movements] (
  [id] BIGINT PRIMARY KEY IDENTITY(1, 1),
  [account_id] BIGINT NOT NULL,
  [category_id] BIGINT NOT NULL,
  [merchant_id] BIGINT,
  [amount] DECIMAL(15,2) NOT NULL,
  [movement_type] nvarchar(255) NOT NULL CHECK ([movement_type] IN ('INCOME', 'EXPENSE', 'TRANSFER')) NOT NULL,
  [description] VARCHAR(255),
  [movement_date] DATE NOT NULL,
  [created_at] TIMESTAMP DEFAULT (CURRENT_TIMESTAMP)
)
GO

CREATE TABLE [attachments] (
  [id] BIGINT PRIMARY KEY IDENTITY(1, 1),
  [movement_id] BIGINT NOT NULL,
  [file_name] VARCHAR(255) NOT NULL,
  [file_url] VARCHAR(500) NOT NULL,
  [upload_date] TIMESTAMP DEFAULT (CURRENT_TIMESTAMP)
)
GO

CREATE TABLE [budgets] (
  [id] BIGINT PRIMARY KEY IDENTITY(1, 1),
  [user_id] BIGINT NOT NULL,
  [category_id] BIGINT NOT NULL,
  [amount] DECIMAL(15,2) NOT NULL,
  [month] TINYINT NOT NULL,
  [year] SMALLINT NOT NULL,
  [alert_percentage] INT DEFAULT (80)
)
GO

CREATE TABLE [financial_goals] (
  [id] BIGINT PRIMARY KEY IDENTITY(1, 1),
  [user_id] BIGINT NOT NULL,
  [name] VARCHAR(150) NOT NULL,
  [target_amount] DECIMAL(15,2) NOT NULL,
  [current_amount] DECIMAL(15,2) DEFAULT (0),
  [target_date] DATE,
  [status] nvarchar(255) NOT NULL CHECK ([status] IN ('IN_PROGRESS', 'COMPLETED', 'CANCELLED')) DEFAULT 'IN_PROGRESS',
  [created_at] TIMESTAMP DEFAULT (CURRENT_TIMESTAMP)
)
GO

CREATE TABLE [recurring_movements] (
  [id] BIGINT PRIMARY KEY IDENTITY(1, 1),
  [user_id] BIGINT NOT NULL,
  [account_id] BIGINT NOT NULL,
  [category_id] BIGINT NOT NULL,
  [amount] DECIMAL(15,2) NOT NULL,
  [description] VARCHAR(255),
  [frequency] nvarchar(255) NOT NULL CHECK ([frequency] IN ('DAILY', 'WEEKLY', 'MONTHLY', 'YEARLY')) NOT NULL,
  [next_execution_date] DATE NOT NULL,
  [active] BOOLEAN DEFAULT (true)
)
GO

CREATE TABLE [notifications] (
  [id] BIGINT PRIMARY KEY IDENTITY(1, 1),
  [user_id] BIGINT NOT NULL,
  [title] VARCHAR(200) NOT NULL,
  [message] TEXT NOT NULL,
  [type] nvarchar(255) NOT NULL CHECK ([type] IN ('INFO', 'WARNING', 'BUDGET_ALERT', 'GOAL_ALERT', 'SPENDING_ALERT')) DEFAULT 'INFO',
  [is_read] BOOLEAN DEFAULT (false),
  [created_at] TIMESTAMP DEFAULT (CURRENT_TIMESTAMP)
)
GO

CREATE INDEX [idx_movements_date] ON [movements] ("movement_date")
GO

CREATE INDEX [idx_movements_category] ON [movements] ("category_id")
GO

CREATE INDEX [idx_movements_account] ON [movements] ("account_id")
GO

CREATE INDEX [idx_budgets_user] ON [budgets] ("user_id")
GO

CREATE INDEX [idx_goals_user] ON [financial_goals] ("user_id")
GO

CREATE INDEX [idx_recurring_user] ON [recurring_movements] ("user_id")
GO

CREATE INDEX [idx_notifications_user] ON [notifications] ("user_id")
GO

ALTER TABLE [accounts] ADD CONSTRAINT [fk_account_user] FOREIGN KEY ([user_id]) REFERENCES [users] ([id]) ON DELETE CASCADE
GO

ALTER TABLE [movements] ADD CONSTRAINT [fk_movement_account] FOREIGN KEY ([account_id]) REFERENCES [accounts] ([id])
GO

ALTER TABLE [movements] ADD CONSTRAINT [fk_movement_category] FOREIGN KEY ([category_id]) REFERENCES [categories] ([id])
GO

ALTER TABLE [movements] ADD CONSTRAINT [fk_movement_merchant] FOREIGN KEY ([merchant_id]) REFERENCES [merchants] ([id])
GO

ALTER TABLE [attachments] ADD CONSTRAINT [fk_attachment_movement] FOREIGN KEY ([movement_id]) REFERENCES [movements] ([id]) ON DELETE CASCADE
GO

ALTER TABLE [budgets] ADD CONSTRAINT [fk_budget_user] FOREIGN KEY ([user_id]) REFERENCES [users] ([id]) ON DELETE CASCADE
GO

ALTER TABLE [budgets] ADD CONSTRAINT [fk_budget_category] FOREIGN KEY ([category_id]) REFERENCES [categories] ([id])
GO

ALTER TABLE [financial_goals] ADD CONSTRAINT [fk_goal_user] FOREIGN KEY ([user_id]) REFERENCES [users] ([id]) ON DELETE CASCADE
GO

ALTER TABLE [recurring_movements] ADD CONSTRAINT [fk_recurring_user] FOREIGN KEY ([user_id]) REFERENCES [users] ([id]) ON DELETE CASCADE
GO

ALTER TABLE [recurring_movements] ADD CONSTRAINT [fk_recurring_account] FOREIGN KEY ([account_id]) REFERENCES [accounts] ([id])
GO

ALTER TABLE [recurring_movements] ADD CONSTRAINT [fk_recurring_category] FOREIGN KEY ([category_id]) REFERENCES [categories] ([id])
GO

ALTER TABLE [notifications] ADD CONSTRAINT [fk_notification_user] FOREIGN KEY ([user_id]) REFERENCES [users] ([id]) ON DELETE CASCADE
GO

ALTER TABLE [movements] ADD FOREIGN KEY ([account_id]) REFERENCES [movements] ([id])
GO
