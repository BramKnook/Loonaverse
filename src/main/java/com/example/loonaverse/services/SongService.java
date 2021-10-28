package com.example.loonaverse.services;

import org.springframework.stereotype.Service;

@Service
public class SongService {
    public String getSong(final Integer id){
        return "poopie" + id;
    }
    public String getAllSongs(){
        return "poopie";
    }
}
