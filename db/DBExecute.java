package db;

import db.*;
import java.sql.*;
import java.util.*;

public class DBExecute
{
	private ArrayList dataList = new ArrayList();
	private ArrayList columnNameList = new ArrayList();
	private String queryKinds;

	private Connection con;

	public DBExecute()
	{
		try
		{
			con = ConnectionPoolManager.getConnection();
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}

	public ArrayList execute(String query)
	{
		try
		{
			Statement stmt= con.createStatement();
			System.out.println("Query : " + query);
			String queryKinds = (query.substring(0, query.indexOf(" "))).toUpperCase();

			if(queryKinds.equals("SELECT"))
			{
				ResultSet rs = stmt.executeQuery(query);
				ResultSetMetaData rsmd = rs.getMetaData();
				setResultSetInfo(rsmd);

				while(rs.next())
				{
					Hashtable tempTable = new Hashtable();

					for(int i=0; i<columnNameList.size(); i++)
					{
						String columnName = (String)columnNameList.get(i);
						String value = rs.getString(columnName);
						if(null != value)
						{
							tempTable.put(columnName, value);
						}
						else
						{
							tempTable.put(columnName, "");
						}
					}

					dataList.add(tempTable);
				}

				rs.close();
			}
			else
			{
				int resultCount = stmt.executeUpdate(query);
				Hashtable dataTable = new Hashtable();
				dataTable.put("RESULT_COUNT", resultCount);
				dataList.add(dataTable);
			}
			stmt.close();
			con.close();
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			System.out.println(sqle.getMessage());
		}

		return dataList;
	}

	private void setResultSetInfo(ResultSetMetaData rsmd) throws SQLException
	{
		int columnCount = rsmd.getColumnCount();
		for(int i=0; i<columnCount; i++)
		{
			columnNameList.add(rsmd.getColumnName(i+1));
		}
	}
}