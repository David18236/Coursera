set SERVEROUTPUT ON;

DECLARE
    nombre nvarchar2(100);
    nombre2 nvarchar2(100);
    apellido nvarchar2(100);
    nombreCompleto NVARCHAR2(200);
    fecha date;

BEGIN
    nombre := '  David';
    apellido := 'Ospina';
    nombreCompleto := trim(nombre) || ' ' || apellido;
    fecha := SYSDATE;
    
    --Funciones con String
    dbms_output.put_line('Largo: ' || length(nombre));
    dbms_output.put_line('Trim: ' || trim(nombre) || ';');
    dbms_output.put_line('Min�sculas: ' || lower(nombre) || ';');
    dbms_output.put_line('Mayusculas: ' || upper(nombre) || ';');
    dbms_output.put_line('Cortar: ' || substr(nombre,2,3) || ';'); 
    dbms_output.put_line('Reemplazo: ' || replace(nombre,'D','N') || ';');
    dbms_output.put_line('Nombre Completo: ' || nombreCompleto || ';');
        
    --Func�n de fecha
    dbms_output.put_line('Hoy: ' || fecha);
    dbms_output.put_line('agregar mes: ' || add_months(fecha,1));    
    dbms_output.put_line('agregar d�a: ' || (fecha + 1));
    dbms_output.put_line('D�a: ' || to_char(fecha, 'dd'));
    dbms_output.put_line('D�a y Mes: ' || to_char(fecha, 'dd-MM'));
    dbms_output.put_line('A�o: ' || to_char(fecha, 'yyyy'));
    dbms_output.put_line('NVL: ' || NVL(nombre2, 'Es Nulo'));
END;
/