/**
 * 
 */
package com.sd.service.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.model.Attachment;
import com.sd.service.IAttachmentService;
import com.sd.dao.UploadMapper;

/**
 * @author elang
 *
 */
@Service
public class AttachmentServiceImpl implements IAttachmentService {
    @Autowired
	private UploadMapper uploadMapper;
	/* (non-Javadoc)
	 * @see com.sd.service.IAttachmentService#addAttachment(com.sd.model.Attachment)
	 */
	@Override
	public void addAttachment(Attachment attachment) {
		uploadMapper.insertAttachment(attachment);
	}
	@Override
	public Attachment queryFile(Map<String, Integer> map) {
		return uploadMapper.findFile(map);
	}

}
