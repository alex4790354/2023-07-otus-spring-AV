CREATE SCHEMA IF NOT EXISTS cbr;

CREATE TABLE IF NOT EXISTS cbr.currency (
    id                  VARCHAR(10),
    frequency           VARCHAR(10)  NOT NULL,
    name_rus            VARCHAR(250) NOT NULL,
    name_eng            VARCHAR(250) NOT NULL,
    nominal             BIGINT       NOT NULL,
    parent_code         VARCHAR(10),
    creation_time       TIMESTAMP WITH TIME ZONE DEFAULT now(),
    update_time         TIMESTAMP WITH TIME ZONE DEFAULT now(),
    instr_name          VARCHAR(250), -- we don't really need them.
    instr_name_eng      VARCHAR(250), -- Ditn't delete
    sid                 VARCHAR(120), -- just to save time
    prod_perm           VARCHAR(250)  -- from refactoring DTO.
    ,CONSTRAINT PK_CURRENCY PRIMARY KEY (ID)
);


    CREATE TABLE IF NOT EXISTS cbr.currency_rate (
    id                  VARCHAR(10),
    effective_date      DATE,
    first_crncy         VARCHAR(10)  NOT NULL,
    second_crncy        VARCHAR(10)  NOT NULL,
    nominal             BIGINT       NOT NULL,
    value               decimal(14,4),
    creation_time       TIMESTAMP WITH TIME ZONE DEFAULT now(),
    update_time         TIMESTAMP WITH TIME ZONE DEFAULT now(),
    CONSTRAINT PK_CURRENCY_RATE PRIMARY KEY (ID),
    CONSTRAINT FK_currency_rate FOREIGN KEY (id) REFERENCES cbr.currency (id)
);

CREATE TABLE IF NOT EXISTS cbr.currency_rate_history (
     id                  VARCHAR(10),
     effective_date      DATE,
     first_crncy         VARCHAR(10)  NOT NULL,
     second_crncy        VARCHAR(10)  NOT NULL,
     nominal             BIGINT       NOT NULL,
     value               decimal(14,4),
     creation_time       TIMESTAMP with time zone DEFAULT now(),
     archived_at         TIMESTAMP with time zone,
     CONSTRAINT PK_CURRENCY_RATE_HISTORY PRIMARY KEY (id, effective_date),
     CONSTRAINT FK_CURRENCY_RATE_HISTORY FOREIGN KEY (id) REFERENCES cbr.currency (id)
);

SELECT * FROM cbr.currency;

