package com.y.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.y.db.DBAccess;
import com.y.model.Message;


/**
 * 和message表相关的数据库操作
 *
 */
public class MessageDao {

	/**
	 * JDBC根据查询条件查询消息表的信息
	 */

	public List<Message> queryMessageListJDBC(String command, String description)
			throws ClassNotFoundException, SQLException { // 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message?characterEncoding=utf8", "root", "123456");

		StringBuilder sb = new StringBuilder("select id,command,description,content from message where 1=1");
		List<String> paramList = new ArrayList<String>();
		if (command != null && !"".equals(command)) {
			sb.append(" and command=?");
			paramList.add(command);
		}
		if (description != null && !"".equals(description)) {
			sb.append(" and description like '%' ? '%' ");
			paramList.add(description);
		}
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		// 避免出错
		for (int i = 0; i < paramList.size(); i++) {
			ptmt.setString(i + 1, paramList.get(i));
		}
		ptmt.execute();
		ResultSet rs = ptmt.getResultSet();
		List<Message> messageList = new ArrayList<Message>();
		while (rs.next()) {
			Message message = new Message();
			message.setId(rs.getInt("id"));
			message.setCommand(rs.getString("command"));
			message.setDescription(rs.getString("description"));
			message.setContent(rs.getString("content"));
			messageList.add(message);
		}
		return messageList;
	}

	/**
	 * Mybatis根据查询条件查询消息表的信息
	 */
	public List<Message> queryMessageList(String command, String description) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Message> mList = new ArrayList<Message>();
		try {
			sqlSession = dbAccess.getSqlSession();
			//获取到的值注入给对象
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			// 通过sqlSession执行SQL语句,第二个参数为构造sql语句的对象
			//感觉像回调
			/*IMessage imessage= sqlSession.getMapper(IMessage.class);
			mList = imessage.queryMessageList(message);*/
			mList=sqlSession.selectList("Message.queryMessageList", message);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return mList;
	}

	/**
	 * 根据查询条件查询消息列表的条数
	 */
	public int count(Message message) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			/*IMessage imessage = sqlSession.getMapper(IMessage.class);
			result = imessage.count(message);*/
			result=sqlSession.selectOne("Message.count", message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return result;
	}
	
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			/*IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageList(parameter);*/
			messageList= sqlSession.selectList("Message.queryMessageListByPage",parameter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/**
	 * 单条删除
	 */
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			
			// 通过sqlSession执行SQL语句,第二个参数为构造sql语句的对象
			sqlSession.delete("Message.deleteOne", id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 批量删除
	 */
	public void deleteBatch(List<Integer> list){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			
			// 通过sqlSession执行SQL语句,第二个参数为构造sql语句的对象
			sqlSession.delete("Message.deleteBatch", list);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 添加数据
	 */
	public void insert(String command,String description,String content){
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession =null;
		try {
			sqlSession=dbAccess.getSqlSession();
			//
			Message message=new Message();
			message.setCommand(command);
			message.setDescription(description);
			message.setContent(content);
			sqlSession.insert("Message.insert",message);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 *批量新增
	 */
	public void insertBatch(List<Message> mList){
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession =null;
		try {
			sqlSession=dbAccess.getSqlSession();
			sqlSession.insert("Message.insertBatch", mList);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			
		}finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
	}
	
	
}
