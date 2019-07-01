package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.Attachment;

public interface AttachmentService {
    Attachment findById(Long id);
    Attachment add(Attachment attach);
    Attachment modify(Attachment attach);
    boolean deleteById(Long id);
}