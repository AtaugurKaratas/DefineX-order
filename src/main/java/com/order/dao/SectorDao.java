package com.order.dao;

import com.order.model.Sector;

import java.util.List;

public interface SectorDao {
    String saveSector(Sector sector);
    List<Sector> allSectorById(List<Integer> integerList);
}
