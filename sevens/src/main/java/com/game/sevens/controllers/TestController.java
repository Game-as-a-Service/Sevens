package com.game.sevens.controllers;

import com.game.sevens.domain.LocalCard;
import com.game.sevens.model.Card;
import com.game.sevens.model.Field;
import com.game.sevens.model.Player;
import com.game.sevens.repository.CardTestRepository;
import com.game.sevens.repository.FieldRepository;
import com.game.sevens.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("test")
@CrossOrigin
public class TestController {
    @Autowired
    private CardTestRepository cardTestRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private FieldRepository fieldRepository;
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/create")
    public String testCreate(@RequestBody Card card){
        cardTestRepository.save(card);
        return "create success";
    }

    @GetMapping("/getall")
    public List<Card> getCardsTest(){
        return cardTestRepository.findAll();
    }

    @GetMapping("/findcard")
    public Card getCardTest(){
        return cardTestRepository.findById("63a6763173429c157b52c7cb").get();
    }

    @DeleteMapping("/delete")
    public String deleteCardTest(@PathVariable String id){
        cardTestRepository.deleteById(id);
        return "deleted"+id;
    }


    @PostMapping("/addplayer")
    public String createPlayer(@RequestBody Player player){
        playerRepository.save(player);
        return "player create success";
    }
    @PostMapping("/addcard")
    public String addCard(@RequestBody Player player){
        playerRepository.save(player);
        return "player update success";
    }
    @PostMapping("/addfield")
    public String addField(@RequestBody Field field){
        //same rank
        fieldRepository.save(field);
        return "filed create success";
    }

    @GetMapping("/getline")
    public String getLineByRank(@RequestParam("rank") String rank){
        System.out.println(rank);
        System.out.println(fieldRepository.getLineByRank("spade").get(0));
        System.out.println(fieldRepository.getLineByRank(rank));
        return "line gotten";
    }

    @PostMapping("addtofield")
    public String addToField(@RequestBody Card card){
        if (shownCardIsLegal(card) == true){
            Field field = fieldRepository.getLineByRank(card.getRank()).get(0);
            List<Card> line = field.getLine();
            line.add(card);
            fieldRepository.save(field);
            return "add success";
        }
        return "the card is illegal";

    }

    private Map<String,Integer> suitValMap = new HashMap<>();
    public boolean shownCardIsLegal(Card card) {
        //initialize map
        suitValMap.put("A",1);
        suitValMap.put("2",2);
        suitValMap.put("3",3);
        suitValMap.put("4",4);
        suitValMap.put("5",5);
        suitValMap.put("6",6);
        suitValMap.put("7",7);
        suitValMap.put("8",8);
        suitValMap.put("9",9);
        suitValMap.put("10",10);
        suitValMap.put("J",11);
        suitValMap.put("Q",12);
        suitValMap.put("K",13);


        //find same suit line
        Field field = fieldRepository.getLineByRank(card.getRank()).get(0);
        List<Card> line = field.getLine();
//        System.out.println(line);
//        System.out.println(line.get(0).getSuit());
//        System.out.println(suitValMap.get("7"));
//        System.out.println(suitValMap.get(line.get(0).getSuit()));
//        System.out.println(suitValMap.get(line.get(line.size()-1)));
        //check if previous or next rank

        if (card.getSuit().equals("7")){
            return true;
        }
        else if (suitValMap.get(line.get(0).getSuit()) - suitValMap.get(card.getSuit()) == 1){
            return true;
        }
        else if (suitValMap.get(card.getSuit()) - suitValMap.get(line.get(line.size()-1).getSuit()) == 1){
            return true;
        }
        return false;
    }
}
