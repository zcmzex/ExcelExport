package cn.zhangcm.utils;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

/**
 * @author Administrator
 */
public class Table2JavaBean {

	// 这3个参数不用改
	private String tableMatchPattern = "true"; // 默认为true,数据库表名匹配模式,来自于DatabaseMetaData.getTables()参数里的tableMatchPattern
	private String matchPattern = "%"; // 默认为%,是否启用数据库表名匹配模式功能,启用后tableName属性不被使用
	private int ObjectTypeOrCommonlyType = 0; // 默认为0，如果需要生成的字段类型为对象类型，及将int变为Integer,则改为1
	// 这几个参数只在第一次使用时更改
	private String driver = "com.mysql.jdbc.Driver"; // 驱动
	private String url = "jdbc:mysql://localhost:3306/exam?characterEncoding=UTF-8"; // 数据库访问串
	private String userName = "root"; // 数据库用户名
	private String password = "123"; // 数据库密码

	private String path = "D:\\springsource\\workspace\\exam\\src\\";// src在硬盘上的路径
	private String packagepath = "cn.itshixun.entity";// model包的包路径
	private static String tableName = "user_role_v"; // 要生成jopo对象的表名,使用;进行分割
	private String jspFolderName = "";// 如果不指定，则默认为tableName

	public static void main(String[] args) {
		Table2JavaBean d2j = new Table2JavaBean();
		d2j.genJavaBean();
		System.out.println(tableName + ":OK");
	}

	public void genJavaBean() {
		try {
			Class.forName(this.driver).newInstance();
			Connection conn = DriverManager.getConnection(this.url,
					this.userName, this.password);
			String[] tables = new String[0];
			ArrayList<String> tableal = new ArrayList<String>(20);
			if ("true".equals(this.matchPattern)) {
				DatabaseMetaData dbmd = conn.getMetaData();
				ResultSet dbmdrs = dbmd.getTables(null,
						this.userName.toUpperCase(), this.tableMatchPattern,
						new String[] { "TABLE" });
				while (dbmdrs.next()) {
					tableal.add(dbmdrs.getString(3));
				}
				dbmdrs.close();
				if (tableal.size() == 0) {
					dbmdrs = dbmd.getTables(null, this.userName.toLowerCase(),
							this.tableMatchPattern, new String[] { "TABLE" });
					while (dbmdrs.next()) {
						tableal.add(dbmdrs.getString(3));
					}
					dbmdrs.close();
				}
				if (tableal.size() == 0) {
					dbmdrs = dbmd.getTables(null, this.userName,
							this.tableMatchPattern, new String[] { "TABLE" });
					while (dbmdrs.next()) {
						tableal.add(dbmdrs.getString(3));
					}
					dbmdrs.close();
				}
				tables = new String[tableal.size()];
				for (int ti = 0; ti < tableal.size(); ti++) {
					tables[ti] = tableal.get(ti);
				}
			} else {
				tables = this.tableName.split(";");
			}
			String strType;
			String strName;
			String className;
			String[] nameSect;
			StringBuilder tbn = new StringBuilder();
			StringBuilder tstr1 = new StringBuilder();
			StringBuilder tstr2 = new StringBuilder();

			// if(!file.exists())file.mkdir();
			// if(!file.isDirectory())file.mkdir();
			for (int i = 0; i < tables.length; i++) {
				nameSect = tables[i].split("_");
				for (String ns : nameSect) {
					tbn.append(ns.substring(0, 1).toUpperCase()
							+ ns.substring(1).toLowerCase());
				}

				className = tbn.toString();
				tbn.delete(0, tbn.length());
				tstr1.append("package " + packagepath + "; ");
				tstr1.append("\n");
				tstr1.append("import java.io.*; ");
				tstr1.append("import java.sql.*; ");
				tstr1.append("\n");
				tstr1.append("public class " + className
						+ " implements Serializable{ ");
				tstr1.append("\n");

				tstr1.append("private static final long serialVersionUID = 1L;");
				tstr1.append("\n");
				try {
					System.out.println(tables[i]);
					Statement statement = conn.createStatement();
					ResultSet rs = statement.executeQuery("select * from "
							+ tables[i]);
					ResultSetMetaData rsd = rs.getMetaData();
					int cc = rsd.getColumnCount();
					for (int j = 1; j <= cc; j++) {
						if (ObjectTypeOrCommonlyType == 1) {
							strType = this.getObjectType(rsd.getColumnType(j));
						} else {
							strType = this
									.getCommonlyType(rsd.getColumnType(j));
						}
						if (strType == null) {
							continue;
						}
						strName = rsd.getColumnName(j);
						tstr1.append(" private " + strType + " "
								+ strName.toLowerCase() + ";");
						tstr1.append("\n");
						tstr2.append(" public void set"
								+ strName.substring(0, 1).toUpperCase()
								+ strName.substring(1).toLowerCase() + "("
								+ strType + " " + strName.toLowerCase() + "){");
						tstr2.append("\n");
						tstr2.append("    this." + strName.toLowerCase()
								+ " = " + strName.toLowerCase() + ";");
						tstr2.append("\n");
						tstr2.append(" }");
						tstr2.append("\n");
						tstr2.append(" public " + strType + " get"
								+ strName.substring(0, 1).toUpperCase()
								+ strName.substring(1).toLowerCase() + "(){");
						tstr2.append("\n");
						tstr2.append("    return this." + strName.toLowerCase()
								+ ";");
						tstr2.append("\n");
						tstr2.append(" }");
						tstr2.append("\n");

					}
					rs.close();
					statement.close();

				} catch (Exception tableE) {
					tableE.printStackTrace();
				}
				tstr2.append("} ");
				tstr2.append("\n");
				tstr1.append(tstr2.toString());
				tstr1.append("\n");

				packagepath = packagepath.replace(".", "\\");
				System.out.println(packagepath);
				File file = new File(path + packagepath + "\\" + className
						+ ".java");
				/*
				 * file = new File(className+".java");
				 * 这样写会在D:\workspace\shop目录下生成文件，即src的同级目录
				 */
				System.out.println("filepath:" + file.getAbsolutePath());
				FileWriter fw = new FileWriter(file);
				fw.write(tstr1.toString());
				fw.flush();
				fw.close();
				tstr1.delete(0, tstr1.length());
				tstr2.delete(0, tstr2.length());
			}
			conn.close();
		} catch (Exception driverE) {
			driverE.printStackTrace();
		}

	}

	public String getObjectType(int type) {
		switch (type) {
		case Types.ARRAY:
			return null;
		case Types.BIGINT:
			return "Long";
		case Types.BINARY:
			return null;
		case Types.BIT:
			return "Byte";
		case Types.BLOB:
			return "Blob";
		case Types.BOOLEAN:
			return "Boolean";
		case Types.CHAR:
			return "String";
		case Types.CLOB:
			return "Clob";
		case Types.DATALINK:
			return null;
		case Types.DATE:
			return "Date";
		case Types.DECIMAL:
			return "Double";
		case Types.DISTINCT:
			return null;
		case Types.DOUBLE:
			return "Double";
		case Types.FLOAT:
			return "Float";
		case Types.INTEGER:
			return "Integer";
		case Types.NUMERIC:
			return "Integer";
		case Types.JAVA_OBJECT:
			return null;
		case Types.LONGVARBINARY:
			return null;
		case Types.LONGVARCHAR:
			return null;
		case Types.NULL:
			return null;
		case Types.OTHER:
			return null;
		case Types.REAL:
			return null;
		case Types.REF:
			return null;
		case Types.SMALLINT:
			return "Short";
		case Types.STRUCT:
			return null;
		case Types.TIME:
			return "Time";
		case Types.TIMESTAMP:
			return "Timestamp";
		case Types.TINYINT:
			return "Short";
		case Types.VARBINARY:
			return null;
		case Types.VARCHAR:
			return "String";
		default:
			return null;
		}
	}

	public String getCommonlyType(int type) {
		switch (type) {
		case Types.ARRAY:
			return null;
		case Types.BIGINT:
			return "long";
		case Types.BINARY:
			return null;
		case Types.BIT:
			return "byte";
		case Types.BLOB:
			return "String";
		case Types.BOOLEAN:
			return "boolean";
		case Types.CHAR:
			return "String";
		case Types.CLOB:
			return "String";
		case Types.DATALINK:
			return null;
		case Types.DATE:
			return "Date";
		case Types.DECIMAL:
			return "double";
		case Types.DISTINCT:
			return null;
		case Types.DOUBLE:
			return "double";
		case Types.FLOAT:
			return "float";
		case Types.INTEGER:
			return "int";
		case Types.NUMERIC:
			return "int";
		case Types.JAVA_OBJECT:
			return null;
		case Types.LONGVARBINARY:
			return null;
		case Types.LONGVARCHAR:
			return null;
		case Types.NULL:
			return null;
		case Types.OTHER:
			return null;
		case Types.REAL:
			return null;
		case Types.REF:
			return null;
		case Types.SMALLINT:
			return "short";
		case Types.STRUCT:
			return null;
		case Types.TIME:
			return "Time";
		case Types.TIMESTAMP:
			return "Timestamp";
		case Types.TINYINT:
			return "short";
		case Types.VARBINARY:
			return null;
		case Types.VARCHAR:
			return "String";
		default:
			return null;
		}
	}

	/**
	 * set属性定义
	 * */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * set属性定义
	 * */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * set属性定义
	 * */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * set属性定义
	 * */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * set属性定义
	 * */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * set属性定义
	 * */
	public void setTableMatchPattern(String tableMatchPattern) {
		this.tableMatchPattern = tableMatchPattern;
	}

	/**
	 * set属性定义
	 * */
	public void setMatchPattern(String matchPattern) {
		this.matchPattern = matchPattern;
	}

	/**
	 * get属性定义
	 * */
	public String getDriver() {
		return this.driver;
	}

	/**
	 * get属性定义
	 * */
	public String getUrl() {
		return this.url;
	}

	/**
	 * get属性定义
	 * */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * get属性定义
	 * */
	public String getPassword() {
		return this.password;
	}

	/**
	 * get属性定义
	 * */
	public String getTableName() {
		return this.tableName;
	}

	/**
	 * get属性定义
	 * */
	public String getTableMatchPattern() {
		return this.tableMatchPattern;
	}

	/**
	 * get属性定义
	 * */
	public String getMatchPattern() {
		return this.matchPattern;
	}
}
