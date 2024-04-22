CREATE TABLE t_category (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL
);

CREATE TABLE t_exchange_rates (
                                  id SERIAL PRIMARY KEY,
                                  kzt DOUBLE PRECISION,
                                  rub DOUBLE PRECISION,
                                  updated_date VARCHAR(255)
);

CREATE TABLE t_monthly_limit (
                                 id SERIAL PRIMARY KEY,
                                 created_date TIMESTAMP(5) WITH TIME ZONE,
                                 limit_amount INT,
                                 limit_balance INT,
                                 category_id INT REFERENCES t_category(id)
);


CREATE TABLE t_transactions (
                                id SERIAL PRIMARY KEY,
                                transaction_date DATE,
                                expense_usd INT,
                                expense_kzt DOUBLE PRECISION,
                                expense_rub DOUBLE PRECISION,
                                limit_exceeded BOOLEAN,
                                category_id INT REFERENCES t_category(id)
);
