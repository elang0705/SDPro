/**
 * 
 */
package com.sd.service;

import java.util.Map;

import com.sd.model.Attachment;

/**
 * @author elang
 *
 */
public interface IAttachmentService {
	/**
	 * 添加附件
	 * @param attachment
	 */
	void addAttachment(Attachment attachment);
	/**
	 * 查询附件
	 * @param type
	 * @return
	 */
	Attachment queryFile(Map<String, Integer> map);

}
