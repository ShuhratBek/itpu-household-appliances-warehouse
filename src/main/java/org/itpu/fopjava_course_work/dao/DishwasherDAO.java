package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.Dishwasher;
import org.itpu.fopjava_course_work.parser.CsvLineParser;

import java.util.List;

public class DishwasherDAO extends AbstractDao<Dishwasher> {
    public DishwasherDAO() {
        super("dishwashers.csv", new CsvLineParser<>(Dishwasher::new, List.of(
                forInt(Appliance::setId),
                forString(Appliance::setName),
                forString(Appliance::setType),
                forString(Appliance::setBrand),
                forString(Appliance::setModelName),
                forString(Appliance::setCategory),
                forLong(Appliance::setPrice),
                forInt(Appliance::setQuantity),
                forInt(Dishwasher::setPlaceSettings),
                forString(Dishwasher::setEnergyEfficiencyRating),
                forInt(Dishwasher::setWashingPrograms),
                forString(Appliance::setColor),
                forDouble(Appliance::setWeight),
                forDouble(Appliance::setHeight),
                forDouble(Appliance::setWidth),
                forDouble(Appliance::setDepth),
                forString(Appliance::setVoltage)
        )));
    }
}