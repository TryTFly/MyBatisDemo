package com.y.service;

import java.util.List;

import com.y.dao.MessageDao;
import com.y.model.Message;
import com.y.util.Iconst;

/**
 * 鏌ヨ鐩稿叧鐨勪笟鍔″姛鑳�
 */
public class QueryService {
	public List<Message> queryMessageList(String command,String description) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
	}
	
	/**
	 * 閫氳繃鎸囦护鏌ヨ鑷姩鍥炲鐨勫唴瀹�
	 * @param command 鎸囦护
	 * @return 鑷姩鍥炲鐨勫唴瀹�
	 */
	public String queryByCommand(String command) {
		MessageDao messageDao = new MessageDao();
		List<Message> messageList;
		if(Iconst.HELP_COMMAND.equals(command)) {
			messageList = messageDao.queryMessageList(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < messageList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("鍥炲[" + messageList.get(i).getCommand() + "]鍙互鏌ョ湅" + messageList.get(i).getDescription());
			}
			return result.toString();
		}
		messageList = messageDao.queryMessageList(command, null);
		if(messageList.size() > 0) {
			return messageList.get(0).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
