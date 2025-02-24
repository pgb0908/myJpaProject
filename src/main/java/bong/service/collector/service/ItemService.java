package bong.service.collector.service;

import bong.service.collector.domain.Item;
import bong.service.collector.repository.ItemRepository;
import bong.service.collector.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;


    public String getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails.getUsername(); // 기본적으로 username이 ID 역할
        }

        return null; // 로그인되지 않은 경우
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


    public void uploadImage(String title,
                            String desc, MultipartFile file){

        var user = userRepository.findByLoginId(getCurrentUserId());

        if(user.isPresent()){
            log.info("유저 로그인 id: " + user.get().getLoginId());

            Item item = Item.createImage(title, desc, file, user.get());
            itemRepository.save(item);
        }else{
            throw new RuntimeException("로그인 되지 않았습니다");
        }
    }
}
