ALTER TABLE repairs ADD active BOOLEAN;
UPDATE repairs SET active = TRUE;