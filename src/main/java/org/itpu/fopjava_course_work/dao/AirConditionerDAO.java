package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.entity.AirConditioner;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.parser.CsvLineParser;

import java.util.List;

public class AirConditionerDAO extends AbstractDao<AirConditioner> {
    public AirConditionerDAO() {
        super("air-conditioners.csv", new CsvLineParser<>(AirConditioner::new, List.of(
                forInt(Appliance::setId),
                forString(Appliance::setName),
                forString(Appliance::setType),
                forString(Appliance::setBrand),
                forString(Appliance::setModelName),
                forString(Appliance::setCategory),
                forLong(Appliance::setPrice),
                forInt(Appliance::setQuantity),
                forInt(AirConditioner::setCoolingCapacity),
                forInt(AirConditioner::setHeatingCapacity),
                forInt(AirConditioner::setPowerConsumption),
                forInt(AirConditioner::setNoiseLevel),
                forString(AirConditioner::setEnergyEfficiencyRating),
                forString(Appliance::setColor),
                forDouble(Appliance::setWeight),
                forDouble(Appliance::setHeight),
                forDouble(Appliance::setWidth),
                forDouble(Appliance::setDepth),
                forString(Appliance::setVoltage)
        )));
    }
}