package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.CoffeeMaker;
import org.itpu.fopjava_course_work.parser.CsvLineParser;

import java.util.List;

public class CoffeeMakerDAO extends AbstractDao<CoffeeMaker> {
    public CoffeeMakerDAO() {
        super("coffee-makers.csv", new CsvLineParser<>(CoffeeMaker::new, List.of(
                forInt(Appliance::setId),
                forString(Appliance::setName),
                forString(Appliance::setType),
                forString(Appliance::setBrand),
                forString(Appliance::setModelName),
                forString(Appliance::setCategory),
                forLong(Appliance::setPrice),
                forInt(Appliance::setQuantity),
                forInt(CoffeeMaker::setCapacityOfCup),
                forInt(CoffeeMaker::setPowerConsumption),
                forString(Appliance::setColor),
                forDouble(Appliance::setWeight),
                forDouble(Appliance::setHeight),
                forDouble(Appliance::setWidth),
                forDouble(Appliance::setDepth),
                forString(Appliance::setVoltage)
        )));
    }
}