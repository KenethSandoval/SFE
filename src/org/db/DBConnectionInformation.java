package org.db;

public interface DBConnectionInformation {
    final String USER = "root";
    final String PASSWORD = "15052002kj";

    final String NO_UTILIZAR_CERTIFICADO_SSL = "?useSSL=false";
    final String CONFIGURACION_ZONA_HORARIA = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/Guatemala";
    final String DB = "SistemaFacturacion2";
    final String HOST = "localhost";
    final String PORT = "3306";
    final String DRIVER = "jdbc";
    final String GESTOR_MYSQL = "mysql";
    final String URL_CONVENTION_FOR_MYSQL = DRIVER + ":" + GESTOR_MYSQL + "://" + HOST + ":" + PORT + "/" + DB;

    //URL
    final String URL = URL_CONVENTION_FOR_MYSQL+CONFIGURACION_ZONA_HORARIA;
}
