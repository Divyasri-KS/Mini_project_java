SELECT u.name, b.title, t.issue_date, t.due_date
FROM transactions t
JOIN users u ON t.user_id = u.user_id
JOIN books b ON t.book_id = b.book_id;