package org.db;

public interface MappingEmployees extends Mappings {
    final String SP_ADD_EMPLOYEE =  "sp_AddEmployee(?)";

    // Views (get)
    final String SP_GET_EMPLOYEE = "vw_GetEmployee";

    // Columns
    final String ID_EMPLOYEE = "idEmployee";
    final String NAME_EMPLOYEE = "name";

    // for updated
    final String ADD_EMPLOYEES = CALL_FOR_SP_START+SP_ADD_EMPLOYEE+CALL_FOR_SP_FINAL;
    final String GET_EMPLOYEES = SELECT_FOR_VIEWS+SP_GET_EMPLOYEE;
}
