package db;

import snaq.db.*;
import java.sql.*;

public class ConnectionPoolManager
{
	private static ConnectionPoolManager cpm = new ConnectionPoolManager();
	private static ConnectionPool pool;

	/**
	 * 내용		: private Constructor
	 * 입력 값	:
	 * 출력 값	:
	 */
	private ConnectionPoolManager()
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String poolName = "DB_POOL";
		int maxPool = 10;
		int maxConnection = 30;
		int maxTime = 180000;
		String dbUrl = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String userId = "DAY";
		String userPass = "day1234";

		System.out.println("### NEW DB Connection Pool Creation ##########################################");

		System.out.println("..... POOL_NAME = " + poolName);
		System.out.println("..... MAX_POOL = " + maxPool);
		System.out.println("..... MAX_CONNECTION = " + maxConnection);
		System.out.println("..... CONNECTION_TIME = " + maxTime);
		System.out.println("..... URL = " + dbUrl);
		System.out.println("..... ID = " + userId);
		System.out.println("..... PASS = " + userPass);

		try
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException cnf)
		{
			cnf.printStackTrace();
		}
		pool = new ConnectionPool(poolName, maxPool, maxConnection, maxTime, dbUrl, userId, userPass);

		System.out.println("##############################################################################\n");
	}

	/**
	 * 내용		: ConnectionPool에서 Connection객체를 하나 return한다.
	 * 입력 값	:
	 * 출력 값	: Connection confListKeyList
	 */
	public static Connection getConnection() throws SQLException
	{
		return pool.getConnection();
	}
}