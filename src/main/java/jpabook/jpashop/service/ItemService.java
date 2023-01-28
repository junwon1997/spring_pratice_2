package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    // 상품 등록
    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    // 상품 수정(준영속성 엔티티 처리하는 방법 -> 변경 감지(merge 쓰지말자!))
    @Transactional
    public void updateItem(Long itemId, int price, String name, int stockQuantity){
        Item findItem = itemRepository.findOne(itemId);
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
    }

    // 상품 조회
    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    // 상품 한 개 조회
    public Item findOne(Long id){
        return itemRepository.findOne(id);
    }


}
