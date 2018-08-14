CREATE SCHEMA IF NOT EXISTS keywords;
USE keywords;

#######
-- keywords
CREATE SCHEMA IF NOT EXISTS keywords;

DROP TABLE IF EXISTS keywords;

CREATE TABLE IF NOT EXISTS keywords (
  id      SERIAL NOT NULL PRIMARY KEY,
  word    TEXT NOT NULL,
  counts  INT NOT NULL,
  website TEXT NOT NULL,
  day     DATETIME DEFAULT NOW()
);

SELECT MAX(id)
FROM keywords;


SELECT *
FROM keywords
LIMIT 2;
