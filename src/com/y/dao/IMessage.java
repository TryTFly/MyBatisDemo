package com.y.dao;

import java.util.List;
import java.util.Map;

import com.y.model.Message;

/**
 * ��Message�����ļ����Ӧ�Ľӿ�
 *
 */
public interface IMessage {

	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageList(Message message);

	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б������
	 */
	public int count(Message message);
	

	/**
	 * ���ݲ�ѯ������ҳ��ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter);
	
}
