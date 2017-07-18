package common.dao.impl;

import common.dao.IBaseDao;
import common.page.Pagination;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * .
 * User: 王星
 * E-Mail:xing_wang@cxsoft.com.cn
 * DateTime: 13-8-5  下午3:01
 * Description:DAO基类
 */
@Service("baseDaoImpl")
public class BaseDaoImpl extends HibernateDaoSupport implements IBaseDao {

    @Resource(name="sessionFactory")
    public void setSF(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public List<?> find(String hql) {
    	Session session =null;
		List<?> list = null;
		try {
			session = currentSession();
		 	Query query = session.createQuery(hql);
			list = query.list();
		} catch(Exception e) {
			logger.error("delete:", e);
		}
		return list;
    }

    public void delete(Object obj) {
    	Session session = null;
		try {
			session = currentSession();
			session.delete(obj);
			session.flush();
		} catch(Exception e) {
			logger.error("delete:", e);
		}
    }

    public Object findById(Class<?> c, Serializable id) {
    	Session session = null;
		Object obj = null;
		try {
			session = currentSession();
            obj = session.get(c,id);
		} catch(Exception e) {
			logger.error("findById:", e);
		}
		return obj;
    }

    public void save(Object obj) {
    	Session session = null;
		try {
			session = currentSession();
			session.save(obj);
			session.flush();
		} catch(Exception e) {
			logger.error("update:", e);
		}
    }

    public void update(Object obj) {
    	Session session = null;
		try {
			session = currentSession();
			session.update(obj);
			session.flush();
		} catch(Exception e) {
			logger.error("update:", e);
		}
    }


    public void executeSQL(String sql) throws SQLException {
        Connection conn = null;
        Statement st = null;
        conn = getConnection();
        st = conn.createStatement();
        st.execute(sql);
        closeStatement(st);
        closeConnection(conn);
    }

    public void executeHQL(String hql) throws SQLException {
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }

    public List<HashMap<String, Object>> executeQuerySQL(String sql)
            throws SQLException {
        List<HashMap<String, Object>> list = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(sql);
            if (rs != null) {
                list = getListDateNoPage(rs);
            }
        } catch (Exception e) {
            System.out.println("执行SQL异常! SQL: " + sql);
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closeStatement(st);
            closeConnection(conn);
        }
        return list;
    }

    /**
     * 获取执行存储过程后返回的参数
     * @param cst
     * @param param
     * @return
     * @throws SQLException
     */
	private HashMap<Integer, Object> getHashMapPRO(CallableStatement cst,
                                                   List<String[]> param) throws SQLException {
        HashMap<Integer, Object> hm = null;
        if (!cst.getMoreResults()) {
            if (null != param && param.size() > 0) {
                hm = new HashMap<Integer, Object>();
                for (int j = 0; j < param.size(); j++) {
                    String[] array = param.get(j);
                    if (array[2] == "out")
                        hm.put(j + 1, cst.getObject(j + 1));
                }
            }
        }
        return hm;
    }

    /**
     * 设置存储过程的参数
     * @param cst
     * @param param
     * @throws SQLException
     */
	private void setCallableStatementParam(CallableStatement cst,
                                           List<String[]> param) throws SQLException {
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                String[] array = param.get(i);
                if ("in".equals(array[2])) {
                    if ("String".equals(array[0]))
                        cst.setString(i + 1, array[1]);
                    else if ("int".equals(array[0]))
                        cst.setInt(i + 1, Integer.parseInt(array[1]));
                    else if ("double".equals(array[0]))
                        cst.setDouble(i + 1, Double.parseDouble(array[1]));
                } else if (array[2] == "out") {
                    if (array[0] == "String")
                        cst.registerOutParameter(i + 1, Types.VARCHAR);
                    else if (array[0] == "int")
                        cst.registerOutParameter(i + 1, Types.INTEGER);
                }
            }
        }
    }

    /**
     * 将结果集封装到List<HashMap<String, Object>>里面
     * @param rs
     * @return
     * @throws SQLException
     */
	private List<HashMap<String, Object>> getListDate(ResultSet rs)
            throws SQLException {
        ResultSetMetaData rsm = rs.getMetaData();
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        do{
            list.add(getHashMapDate(rs, rsm, list));
        } while (rs.next());
        return list;
    }

    /**
     * 将结果集封装到List<HashMap<String, Object>>里面
     * @param rs
     * @return
     * @throws SQLException
     */
    private List<HashMap<String, Object>> getListDateNoPage(ResultSet rs)
            throws SQLException {
        ResultSetMetaData rsm = rs.getMetaData();
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        while(rs.next()){
            list.add(getHashMapDate(rs, rsm, list));
        }
        return list;
    }

    /**
     * 将结果集封装到List<HashMap<String, Object>>里面(带数据量限制)
     * @param rs
     * @return
     * @throws SQLException
     */
	private List<HashMap<String, Object>> getListDatePage(ResultSet rs, int i)
            throws SQLException {
        ResultSetMetaData rsm = rs.getMetaData();
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        int n = 0;
        do{
            list.add(getHashMapDate(rs, rsm, list));
            n++;
        } while (n < i && rs.next());
        return list;
    }

    /**
     * 将当前记录转换成HashMap<String, Object>对象
     *
     * @param rs
     * @param rsm
     * @param list
     * @return
     * @throws SQLException
     */
    private HashMap<String, Object> getHashMapDate(ResultSet rs,
                                                   ResultSetMetaData rsm, List<HashMap<String, Object>> list)
            throws SQLException {
        HashMap<String, Object> ht2 = new HashMap<String, Object>();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            if (rs.getObject(i) != null) {
                if (rsm.getColumnType(i) == Types.DATE || rsm.getColumnType(i) == Types.TIMESTAMP){
                    ht2.put(rsm.getColumnName(i).toUpperCase(), sdf.format(rs.getTimestamp(i)));
                } else {
                    if (rsm.getColumnType(i) == Types.CLOB) {
                        oracle.sql.CLOB clob = (oracle.sql.CLOB) rs.getClob(i);
                        StringBuffer content = new StringBuffer();
                        if (null != clob) {
                            Reader is = clob.getCharacterStream();
                            BufferedReader br = new BufferedReader(is);

                            try {
                                String s = br.readLine();
                                while (null != s) {
                                    content.append(s);
                                    s = br.readLine();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        ht2.put(rsm.getColumnName(i).toUpperCase(), content.toString());
                    } else {
                        ht2.put(rsm.getColumnName(i).toUpperCase(), rs.getObject(i));
                    }
                }
            }
        }
        return ht2;
    }

    /**
     * 关闭ResultSet
     *
     * @param rs
     * @throws SQLException
     */
    private void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("ResultSet关闭");
            } catch (SQLException e) {
                System.out.println("关闭ResultSet出错！");
                e.printStackTrace();
                throw e;
            }
        }
    }

    /**
     * 关闭CallableStatement
     *
     * @param cst
     * @throws SQLException
     */
	private void closeCallableStatement(CallableStatement cst)
            throws SQLException {
        if (cst != null) {
            try {
                cst.close();
                System.out.println("CallableStatement关闭");
            } catch (SQLException e) {
                System.out.println("关闭CallableStatement出错！");
                e.printStackTrace();
                throw e;
            }
        }
    }

    /**
     * 关闭Statement
     *
     * @param st
     * @throws SQLException
     */
    private void closeStatement(Statement st) throws SQLException {
        if (st != null) {
            try {
                st.close();
                System.out.println("Statement关闭");
            } catch (SQLException e) {
                System.out.println("关闭Statement出错！");
                e.printStackTrace();
                throw e;
            }
        }
    }

    /**
     * 关闭connection
     */
    private void closeConnection(Connection conn){
    	if(conn != null){
    		try {
    			conn.close();
                System.out.println("Connection关闭");
            } catch (SQLException e) {
                System.out.println("关闭Connection出错！");
                e.printStackTrace();
            }
    	}
    }
    /**
     * 获得Connection
     * @return connection
     */
    public Connection getConnection() throws SQLException {
        return SessionFactoryUtils.getDataSource(getSessionFactory()).getConnection();
    }

    @SuppressWarnings("rawtypes")
    public void deleteAll(Collection entities) {
        this.getHibernateTemplate().deleteAll(entities);
    }

	public Pagination find(String hql, int startPage, int pageSize) throws Exception {
		StringBuffer hqlCount = new StringBuffer();
        Pagination p = new Pagination();
        p.setPageNow(startPage);
        p.setPageSize(pageSize);
        if ("select".equals(hql.trim().substring(0, 6).toLowerCase())) {
            hqlCount.append("select count(*) from (").append(hql).append(")");
        } else {
            hqlCount.append("select count(*) ").append(hql);
        }
        p.setRowCount(Integer.valueOf(currentSession().createQuery(hqlCount.toString()).list().get(0).toString()));
        Query q = currentSession().createQuery(hql);
        if (p.getPageSize() != 0) {
            q.setFirstResult(p.getStartRow() - 1);
            q.setFetchSize(p.getPageSize());
            q.setMaxResults(p.getPageSize());
        }
        p.setList(q.list());
        return p;
	}

	public Pagination executeQuerySQL(String sql, int inPage, int inPageSize) throws SQLException {
		Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Pagination p = new Pagination();
        p.setPageNow(inPage);
        p.setPageSize(inPageSize);
        try {
            conn = getConnection();
            st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(sql);
            if (rs != null) {
                rs.last();
                p.setRowCount(rs.getRow());
                rs.first();
                rs.absolute(p.getStartRow());
                if (p.getRowCount() != 0) {
                    if (p.getPageSize() == 0)
                        p.setList(getListDate(rs));
                    else
                        p.setList(getListDatePage(rs, p.getPageSize()));
                }
            }
        } catch (Exception e) {
            System.out.println("执行SQL异常! SQL: " + sql);
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closeStatement(st);
            closeConnection(conn);
        }
        return p;
	}

	public Pagination findProcedure(String sql, List<String[]> param) throws SQLException {
		Connection conn = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        Pagination p = new Pagination();
        try {
            conn = getConnection();
            cst = conn.prepareCall(sql);
            setCallableStatementParam(cst, param);
            cst.execute();
            rs = cst.getResultSet();
            if (rs != null)
                p.setList(getListDateNoPage(rs));
            p.setHashMap(getHashMapPRO(cst, param));
        } catch (Exception e) {
            System.out.println("执行SQL异常! SQL: " + sql);
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closeCallableStatement(cst);
            closeConnection(conn);
        }
        return p;
	}
	
	 public void updateForMerge(Object obj) {
	    	Session session = null;
			try {
				session = currentSession();
				obj = session.merge(obj);
				session.update(obj);
				session.flush();
			} catch(Exception e) {
				logger.error("update:", e);
			}
	    }
}
