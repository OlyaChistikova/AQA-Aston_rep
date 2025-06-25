package org.example.task_3;


public class Park {
    String parkName;

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public class Attraction {
        String attractionName;
        String attractionWorkTime;
        String attractionPrice;

        public Attraction(String attractionName, String attractionWorkTime, String attractionPrice) {
            this.attractionName = attractionName;
            this.attractionWorkTime = attractionWorkTime;
            this.attractionPrice = attractionPrice;
        }

        public void getInfo() {
            System.out.println("В парке " + parkName + " есть атракцион под названием " + attractionName + ", который работает в эти часы: " + attractionWorkTime);
        }
    }
}
