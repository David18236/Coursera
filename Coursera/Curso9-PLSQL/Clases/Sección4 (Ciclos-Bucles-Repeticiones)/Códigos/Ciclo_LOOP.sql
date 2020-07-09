set SERVEROUTPUT ON;

DECLARE
    X number;

BEGIN
    x := 10;

    LOOP
        dbms_output.put_line(x);
        x := x +10;
    
        IF(x > 120) THEN
            exit;
            
        END IF;
        
    END LOOP;
END;
/