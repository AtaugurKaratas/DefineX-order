package com.order.service.impl;

import com.order.dao.impl.SectorImpl;
import com.order.model.Sector;
import com.order.service.SectorService;

import java.util.List;

public class SectorServiceImpl implements SectorService {
    SectorImpl sectorImpl = new SectorImpl();

    @Override
    public String saveSector(Sector sector) {
        return sectorImpl.saveSector(sector);
    }

    @Override
    public List<Sector> allSectorById(List<Integer> integerList) {
        return sectorImpl.allSectorById(integerList);
    }
}
