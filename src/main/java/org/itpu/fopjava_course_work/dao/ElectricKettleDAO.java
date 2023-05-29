package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.ElectricKettle;
import org.itpu.fopjava_course_work.parser.CsvLineParser;

import java.util.List;

public class ElectricKettleDAO extends AbstractDao<ElectricKettle> {
    public ElectricKettleDAO() {
        super("electric-kettles.csv", new CsvLineParser<>(ElectricKettle::new, List.of(
                forInt(Appliance::setId),
                forString(Appliance::setName),
                forString(Appliance::setType),
                forString(Appliance::setBrand),
                forString(Appliance::setModelName),
                forString(Appliance::setCategory),
                forString(Appliance::setCategory),
                forLong(Appliance::setPrice),
                forInt(Appliance::setQuantity),
                forString(ElectricKettle::setMaterial),
                forDouble(ElectricKettle::setCapacity),
                forString(Appliance::setColor),
                forString(Appliance::setVoltage),
                forInt(ElectricKettle::setPowerConsumption),
                forDouble(Appliance::setWeight),
                forDouble(Appliance::setHeight),
                forDouble(Appliance::setWidth),
                forDouble(Appliance::setDepth)
        )));
    }
}