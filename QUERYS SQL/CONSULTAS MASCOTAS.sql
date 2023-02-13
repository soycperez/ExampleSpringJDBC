SELECT * 
FROM DUENIO
JOIN MASCOTA ON MASCOTA.ID_DUENIO = DUENIO.ID_DUENIO
JOIN COLONIA ON COLONIA.ID_COLONIA = DUENIO.ID_COLONIA
JOIN RAZA ON RAZA.ID_RAZA = MASCOTA.ID_RAZA; 

SELECT * 
FROM DUENIO
WHERE ID_DUENIO = (SELECT ID_DUENIO FROM MASCOTA);

SELECT FECHA_REGISTRO - FECHA_REGISTRO AS DateDiff
FROM   DUENIO
WHERE ID_DUENIO = 3 AND ID_DUENIO=1;
    
select date '2000-01-02' - date '1999-01-01' as dateDiff
from dual;

select to_date('2000-01-02', 'yyyy-MM-dd')
       - to_date('2000-01-01', 'yyyy-MM-dd')
       datediff
from   dual
;

 SET SERVEROUTPUT ON ;
    DECLARE
        V_VAR NUMBER;
    BEGIN
         V_VAR:=TO_DATE('1999-01-02', 'YYYY-MM-DD') - TO_DATE('2000-01-01', 'YYYY-MM-DD') ;
         DBMS_OUTPUT.PUT_LINE(V_VAR);
    END;
    
/*    
CREATE OR REPLACE PROCEDURE GETDUENIO (
    VL_IDDUENIO      VARCHAR2,
    duenio_refcur    IN OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN duenio_refcur FOR 
        SELECT ID_DUENIO, NOMBRE, APELLIDOS FROM DUENIO WHERE ID_DUENIO = VL_IDDUENIO;
END;
*/
CREATE OR REPLACE FUNCTION GETDUENIOCURSOR (VL_IDDUENIO NUMBER)
    RETURN SYS_REFCURSOR
IS
    rf_cur SYS_REFCURSOR
BEGIN
    OPEN RF_CUR FOR
        SELECT *  
        FROM DUENIO
        WHERE ID_DUENIO = VL_IDDUENIO; 
        
    RETURN RF_CUR; 
END GETDUENIOCURSOR;     

create or replace function GETDUENIO (VL_IDDUENIO number)
   return sys_refcursor
is
   rf_cur   sys_refcursor;
begin
   open rf_cur for
      select *
        from DUENIO
       where ID_DUENIO = VL_IDDUENIO;

   return rf_cur;
end GETDUENIO;

-- Ejemplo recuperado de: https://docs.devart.com/dotconnect/oracle/StoredFunctionsREFCursors.html
CREATE OR REPLACE FUNCTION GETCOLONIA RETURN SYS_REFCURSOR
IS
cur SYS_REFCURSOR;
BEGIN
  OPEN cur FOR
  SELECT *
    FROM COLONIA
    ORDER BY ID_COLONIA;
  RETURN cur;
END;

-- Example: https://oracle-base.com/articles/misc/using-ref-cursors-to-return-recordsets
-- Example good: https://www.oracletutorial.com/plsql-tutorial/plsql-cursor-variables/