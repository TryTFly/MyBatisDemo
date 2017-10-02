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
 * �б���ص�ҵ����
 *
 */
public class ListService {

	/**
	 * ����������ѯ
	 */
	public List<Message> queryMessageList(String command, String description)
			throws ClassNotFoundException, SQLException {
		MessageDao md = new MessageDao();
		return md.queryMessageList(command, description);
	}


	/**
	 * ���ݲ�ѯ������ҳ��ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageListByPage(String command,String description,Page page) {
			// ��֯��Ϣ����
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			MessageDao messageDao = new MessageDao();
			// ����������ѯ����
			int totalNumber = messageDao.count(message);
			// ��֯��ҳ��ѯ����
			page.setTotalNumber(totalNumber);
			Map<String,Object> parameter = new HashMap<String, Object>();
			parameter.put("message", message);
			parameter.put("page", page);
			
			// ��ҳ��ѯ�����ؽ��
			return messageDao.queryMessageListByPage(parameter);
		}
	
	
}
