package com.y.service;

import java.util.ArrayList;
import java.util.List;

import com.y.dao.MessageDao;
import com.y.model.Message;

/**
 * 维护业务
 *
 */
public class MaintainService {

	/**
	 * 单条删除
	 */
	public void deleteOne(String id) {
		if (id != null && !"".equals(id)) {
			MessageDao dao = new MessageDao();
			dao.deleteOne(Integer.parseInt(id));
		}

	}

	/**
	 * 批量删除
	 */
	public void deleteBatch(String[] ids) {
		if (ids != null && ids.length > 0) {
			List<Integer> idlist = new ArrayList<Integer>();
			for (String id : ids) {
				idlist.add(Integer.parseInt(id));
			}
			MessageDao dao = new MessageDao();
			dao.deleteBatch(idlist);
		}

	}

	/**
	 * 插入数据
	 */
	public void insert(String command, String description, String content) {
		MessageDao dao = new MessageDao();
		dao.insert(command, description, content);
	}

	/**
	 * 批量新增
	 */
	public void insertBatch(String command[], String description[], String content[]) {
		MessageDao dao = new MessageDao();
		List<Message> mList = new ArrayList<Message>();
		if (command!=null&&command.length > 0) {
			for (int i = 0; i < command.length; i++) {
				Message message = new Message();
				message.setCommand(command[i]);
				message.setDescription(description[i]);
				message.setContent(content[i]);
				mList.add(message);
			}
			dao.insertBatch(mList);
		}
	}

}
