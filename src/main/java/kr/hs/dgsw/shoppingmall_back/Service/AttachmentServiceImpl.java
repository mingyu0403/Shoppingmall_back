package kr.hs.dgsw.shoppingmall_back.Service;
import kr.hs.dgsw.shoppingmall_back.Domain.Attachment;
import kr.hs.dgsw.shoppingmall_back.Repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    @PostConstruct
    private void init(){
        String url = "D:/PORTFOLIO/DGSW/3Grade/WebPractice/Shoppingmall/shoppingmall_back/src/Upload/";
        // 상의(남)
        this.attachmentRepository.save(new Attachment("top.jpg",url + "top.jpg"));
        // 하의(남)
        this.attachmentRepository.save(new Attachment("pants.jpg",url + "pants.jpg"));
        // 상의(여)
        this.attachmentRepository.save(new Attachment("top.jpg",url + "top.jpg"));
        // 하의(여)
        this.attachmentRepository.save(new Attachment("pants.jpg",url + "pants.jpg"));
        // 구두
        this.attachmentRepository.save(new Attachment("shoes.jpg",url + "shoes.jpg"));
        // 가방
        this.attachmentRepository.save(new Attachment("bag.jpg",url + "bag.jpg"));
        // 소품
        this.attachmentRepository.save(new Attachment("interior.jpg",url + "interior.jpg"));

        // 맨투맨
        this.attachmentRepository.save(new Attachment("man_to_man.jpg",url + "man_to_man.jpg"));
        // 티셔츠
        this.attachmentRepository.save(new Attachment("t-shirt.jpg",url + "t-shirt.jpg"));
        // 반바지
        this.attachmentRepository.save(new Attachment("short_pants.png",url + "short_pants.png"));
    }

    @Override
    public Attachment findById(Long id) {
        return this.attachmentRepository.findById(id).orElse(null);
    }

    @Override
    public Attachment add(Attachment attachment) {
        return this.attachmentRepository.save(attachment);
    }

    @Override
    public Attachment modify(Attachment attachment) {
        return this.attachmentRepository.findById(attachment.getId())
                .map(a -> {
                    //a.setName(Optional.ofNullable(product.getName()).orElse(p.getName()));

                    return this.attachmentRepository.save(a);
                })
                .orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        Attachment found = this.findById(id);
        if(found != null){
            attachmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

}