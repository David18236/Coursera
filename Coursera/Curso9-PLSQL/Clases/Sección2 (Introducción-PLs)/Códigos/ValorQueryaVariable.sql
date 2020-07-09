set SERVEROUTPUT ON;

DECLARE

    cantidad number;
    usuario nvarchar2(100);

BEGIN

    /*select user into usuario from dual;
    select count(*) into cantidad from dual;*/
    
    SELECT user,count(*) into usuario,cantidad FROM dual group by user;
    
    dbms_output.put_line('Usuario:' || usuario);
    dbms_output.put_line('Cantidad:' || cantidad);
    
END;
/
