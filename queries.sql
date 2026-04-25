-- UPDATE OPERATION:
-- Marks a book as returned and assigns a fine for late return
UPDATE transactions
SET return_date = '2024-04-25', fine = 60
WHERE transaction_id = 3;

------------------------------------------------------------

-- DELETE OPERATION:
-- Removes a transaction record (e.g., incorrect or cancelled entry)
DELETE FROM transactions
WHERE transaction_id = 10;

------------------------------------------------------------

-- AGGREGATE QUERY (GROUP BY):
-- Counts how many books each user has taken
SELECT user_id, COUNT(*) AS books_taken
FROM transactions
GROUP BY user_id;

------------------------------------------------------------

-- AGGREGATE FUNCTION (SUM):
-- Calculates total fine collected from all transactions
SELECT SUM(fine) AS total_fine
FROM transactions;

------------------------------------------------------------

-- CONDITIONAL QUERY (FILTERING):
-- Retrieves all overdue books (not returned and past due date)
SELECT *
FROM transactions
WHERE return_date IS NULL
  AND due_date < CURDATE();