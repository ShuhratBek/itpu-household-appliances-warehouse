package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.Dryer;
import org.itpu.fopjava_course_work.parser.CsvLineParser;

import java.util.List;

public class DryerDAO extends AbstractDao<Dryer> {
    public DryerDAO() {
        super("dryers.csv", new CsvLineParser<>(Dryer::new, List.of(
                forInt(Appliance::setId),
                forString(Appliance::setName),
                forString(Appliance::setType),
                forString(Appliance::setBrand),
                forString(Appliance::setModelName),
                forString(Appliance::setCategory),
                forLong(Appliance::setPrice),
                forInt(Appliance::setQuantity),
                forDouble(Dryer::setCapacity),
                forInt(Dryer::setPowerConsumption),
                forDouble(Dryer::setBoilTime),
                forString(Dryer::setMaterial),
                forString(Appliance::setColor),
                forDouble(Appliance::setWeight),
                forDouble(Appliance::setHeight),
                forDouble(Appliance::setWidth),
                forDouble(Appliance::setDepth),
                forString(Appliance::setVoltage)
        )));
    }
}