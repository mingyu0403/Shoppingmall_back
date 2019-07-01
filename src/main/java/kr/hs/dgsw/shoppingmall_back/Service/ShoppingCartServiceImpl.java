package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.ShoppingCart;
import kr.hs.dgsw.shoppingmall_back.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart findById(Long id) {
        return this.shoppingCartRepository.findById(id).orElse(null);
    }

    @Override
    public List<ShoppingCart> findAllByUserId(Long userId) {
        List<ShoppingCart> listAll = this.shoppingCartRepository.findAll();
        List<ShoppingCart> listByUserId = new ArrayList<>();
        for(int i=0; i<listAll.size(); i++){
            if(listAll.get(i).getUserId() == userId){
                listByUserId.add(listAll.get(i));
            }
        }
        return listByUserId;
    }

    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public boolean deleteById(Long id) {
        ShoppingCart found = this.findById(id);
        if(found != null){
            this.shoppingCartRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
