package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager extends ParkingBoy{

    private List<ParkingBoy> managementList;

    public ParkingLotServiceManager() {
        managementList = new ArrayList<>();
    }

    public void addToManagementList(ParkingBoy parkingBoy) {
        managementList.add(parkingBoy);
    }

    public boolean doesParkingBoyInManagementList(ParkingBoy parkingBoy) {
        return managementList.contains(parkingBoy);
    }
}
