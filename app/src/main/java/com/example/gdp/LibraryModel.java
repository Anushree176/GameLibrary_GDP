package com.example.gdp;

public class LibraryModel {

        private int thumbnail;
        private String title;
        private String company;
        private String time;

        public LibraryModel(int thumbnail, String title, String company, String time) {
            this.thumbnail = thumbnail;
            this.title = title;
            this.company = company;
            this.time = time;
        }

        public int getImage() {
            return thumbnail;
        }

        public void setImage(int thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getTime(){ return time; }

        public void setTime(String time) {
        this.time = time;
    }

}
