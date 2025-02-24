package bong.service.collector.service;

import bong.service.collector.domain.Item;
import bong.service.collector.repository.ItemRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public void updateItem(Long itemId, String title, String desc){
        var item = itemRepository.findOne(itemId);
        item.setTitle(title);
        item.setDescription(desc);
        item.setUploadAt(LocalDateTime.now()); // todo zone 설정 나중에
    }

    public List<Item> findItem(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }

    public void addNewOne(String title,
                          String desc, MultipartFile file){

        Item item = new Item();
        item.setTitle(title);
        item.setDescription(desc);

        saveItem(item);
    }
}
