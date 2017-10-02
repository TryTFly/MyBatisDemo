package com.y.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.y.dao.MessageDao;
import com.y.entity.Page;
import com.y.model.Message;

/**
 * 
 * 列表相关的业务功能
 *
 */
public class ListService {

	/**
	 * 根据条件查询
	 */
	public List<Message> queryMessageList(String command, String description)
			throws ClassNotFoundException, SQLException {
		MessageDao md = new MessageDao();
		return md.queryMessageList(command, description);
	}


	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(String command,String description,Page page) {
			// 组织消息对象
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			MessageDao messageDao = new MessageDao();
			// 根据条件查询条数
			int totalNumber = messageDao.count(message);
			// 组织分页查询参数
			page.setTotalNumber(totalNumber);
			Map<String,Object> parameter = new HashMap<String, Object>();
			parameter.put("message", message);
			parameter.put("page", page);
			
			// 分页查询并返回结果
			return messageDao.queryMessageListByPage(parameter);
		}
	
	
}
