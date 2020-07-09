set SERVEROUTPUT ON;

DECLARE
    rand number;

BEGIN
    rand := round(dbms_random.value(0, 5));
    
    dbms_output.put_line(rand);
    
    CASE
        WHEN (rand = 0) THEN
            dbms_output.put_line('CERO');
        WHEN (rand = 1) THEN
            dbms_output.put_line('UNO');
        WHEN (rand = 2) THEN
            dbms_output.put_line('DOS');
        WHEN (rand = 3) THEN
            dbms_output.put_line('TRES');
        WHEN (rand = 4) THEN
            dbms_output.put_line('CUATRO');
        ELSE
            dbms_output.put_line('CINCO');
    END CASE;
END;
/