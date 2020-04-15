
DROP TABLE IF EXISTS token;
CREATE TABLE token (
    token  VARCHAR(128)      NOT NULL ,
    emp_num VARCHAR(128)    NOT NULL,
    PRIMARY KEY (token)
);