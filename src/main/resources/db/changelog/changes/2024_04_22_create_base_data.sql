INSERT INTO t_category (name) VALUES ('goods'), ('services');

INSERT INTO t_monthly_limit (created_date, limit_amount, limit_balance, category_id)
VALUES
    (NOW(), 1000, 1000, 1),
    (NOW(), 1000, 1000, 2);

