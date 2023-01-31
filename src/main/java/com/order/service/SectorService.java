package com.order.service;

import com.order.model.Sector;

import java.util.List;

public interface SectorService {
    String saveSector(Sector sector);

    List<Sector> allSectorById(List<Integer> integerList);
}
