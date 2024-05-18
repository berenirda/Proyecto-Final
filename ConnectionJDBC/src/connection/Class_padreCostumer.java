package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class Class_padreCostumer {
	protected String driver = "com.mysql.cj.jdbc.Driver";
    protected String url ="jdbc:mysql://localhost:3306/sakila";
    protected String user = "root";
    protected String password = "Noviembre2026n";
    protected  Connection conn = null;
    protected Statement st = null;
    protected PreparedStatement  ps = null;
    protected PreparedStatement  psl = null;
    protected PreparedStatement  pse = null;
    protected  ResultSet rs = null;
    
        
}
