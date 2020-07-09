set SERVEROUTPUT ON;

DECLARE
    nota number;

BEGIN
    nota := 60;
    
    IF(nota >= 90) THEN
        dbms_output.put_line('EXCELENTE');
        
    ELSIF(NOTA >= 80) THEN
        dbms_output.put_line('MUY BIEN');
    
    ELSIF(NOTA >= 70) THEN
        dbms_output.put_line('BIEN');
        
    ELSE
        dbms_output.put_line('REPROBADO');

    END IF;

END;
/