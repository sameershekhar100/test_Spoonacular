package com.example.food;

public class food {

        private final String title;
        private final String imageUrl;
        private final String missed_ind;


        public food(String title,String imageUrl,String missed_ind){
           this.title=title;
           this.imageUrl=imageUrl;
           this.missed_ind=missed_ind;
        }
        public String gettitle(){
            return title;
        }
        public String getImageUrlUrl(){
            return imageUrl;
        }
    public String getMissed_ind(){
        return missed_ind;
    }


    }


