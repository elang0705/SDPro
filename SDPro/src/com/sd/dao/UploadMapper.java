/**
 * 
 */
package com.sd.dao;

import java.util.Map;

import com.sd.model.Attachment;

/**
 * @author elang *
 */
public interface UploadMapper {
	void insertAttachment(Attachment attachment);
	Attachment findFile(Map<String, Integer> map);
}
