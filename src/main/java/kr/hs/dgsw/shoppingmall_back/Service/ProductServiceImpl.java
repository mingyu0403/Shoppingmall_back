package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.Product;
import kr.hs.dgsw.shoppingmall_back.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    private void init(){
        this.productRepository.save(new Product("맨투맨",
                "기장이 짧은 오버핏",
                "부드러운 가모가공이 된 원단을 사용했습니다.\n" +
                        "디테일은 캐주얼한 룩부터 모던한 룩까지 다양한 스타일연출이 가능합니다.\n" +
                        "소매부분에는 깔끔한 느낌에 포인트를 더해주며 뒷면에 절개를 더하여 완성도를 높였습니다.",
                "상품에 대한 문의나 배송문의는 저에게 바로 연락을 주세요\n" +
                        "고객 한 분 한 분을 소중히 여기며 최고의 서비스를 약속 드립니다.\n" +
                        "직통전화번호:080-0000-0000",
                "맨투맨 잘 만드는 회사",
                25900,
                13900,
                1,
                8));
        this.productRepository.save(new Product("티셔츠",
                "통풍이 잘 되는 티셔츠",
                "단체티 / 반티 / 동아리 / 동호회\n"+
                "30년 전통의 노하우\n"+
                "국내산 면 사용!! 품질에 대한 자부심 甲!",
                "상품 수령 후 7일 이내에 신청하실 수 있습니다.\n" +
                        "단, 제품이 표시광고 내용과 다르거나 불량 등 계약과 다르게 이행된 경우는\n" +
                        "제품 수령일부터 3개월 이내, 그 사실을 안 날 또는 알 수 있었던 날부터 30일이내에 교환/반품이 가능합니다",
                "티셔츠만드는회사",
                14900,
                9900,
                1,
                9));
        this.productRepository.save(new Product("반바지",
                "시원한 반바지",
                "100% 폴리에스테르\n"+
                "찬물 세탁 가능, 원색의 경우 이염의 위험이 있으니 단독 세탁을 권장합니다.\n"+
                "현 상품은 제조국에 따라 택이 다를 수 있습니다.\n"+
                "이로 인한 무상 교환 환불은 어려운점 양해바랍니다.",
                "결제일을 기준으로 평균 2~4일 이내 상품이 준비 되어 발송됩니다. (일, 공휴일 제외)\n"+
                "주문 폭주로 재고가 충분치 않은 경우 시간이 더 걸릴 수 있는 점 양해 부탁드립니다.",
                "바지 잘 만드는 회사",
                12900,
                9900,
                2,
                10));
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Long productId) {
        return this.productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        Optional<Product> found = this.productRepository.findById(product.get_id());
        if(found.isPresent()){
            return null;
        }
        return this.productRepository.save(product);
    }

    @Override
    public Product editProduct(Product product) {
        return this.productRepository.findById(product.get_id())
                .map(p -> {
                    p.setName(Optional.ofNullable(product.getName()).orElse(p.getName()));
                    p.setInfo(Optional.ofNullable(product.getInfo()).orElse(p.getInfo()));
                    p.setDetailInfo(Optional.ofNullable(product.getDetailInfo()).orElse(p.getDetailInfo()));
                    p.setPurchaseInfo(Optional.ofNullable(product.getPurchaseInfo()).orElse(p.getPurchaseInfo()));
                    p.setManufacturer(Optional.ofNullable(product.getManufacturer()).orElse(p.getManufacturer()));
                    p.setFullPrice(Optional.ofNullable(product.getFullPrice()).orElse(p.getFullPrice()));
                    p.setSalePrice(Optional.ofNullable(product.getSalePrice()).orElse(p.getSalePrice()));

                    return this.productRepository.save(p);
                })
                .orElse(null);
    }

    @Override
    public boolean deleteById(Long productId) {
        Product found = this.findById(productId);
        if(found != null){
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }
}
