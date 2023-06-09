package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.ClothesSteamer;
import org.itpu.fopjava_course_work.parser.CsvLineParser;

import java.util.List;

public class ClothesSteamerDAO extends AbstractDao<ClothesSteamer> {
    public ClothesSteamerDAO() {
        super("clothes-steamers.csv", new CsvLineParser<>(ClothesSteamer::new, List.of(
                forInt(Appliance::setId),
                forString(Appliance::setName),
                forString(Appliance::setType),
                forString(Appliance::setBrand),
                forString(Appliance::setModelName),
                forString(Appliance::setCategory),
                forLong(Appliance::setPrice),
                forInt(Appliance::setQuantity),
                forInt(ClothesSteamer::setPowerConsumption),
                forDouble(ClothesSteamer::setWaterTankCapacity),
                forInt(ClothesSteamer::setSteamTime),
                forString(Appliance::setColor),
                forDouble(Appliance::setWeight),
                forDouble(Appliance::setHeight),
                forDouble(Appliance::setWidth),
                forDouble(Appliance::setDepth),
                forString(Appliance::setVoltage)
        )));
    }
}