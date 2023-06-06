package org.itpu.fopjava_course_work.converter;

import org.itpu.fopjava_course_work.entity.Appliance;

public enum RawConverters {
    ID(new IdParameterConverter<>()),
    NAME(new NameParameterConverter<>()),
    TYPE(new TypeParameterConverter<>()),
    BRAND(new BrandParameterConverter<>()),
    MODELNAME(new ModelNameParameterConverter<>()),
    CATEGORY(new CategoryParameterConverter<>()),
    PRICE(new PriceParameterConverter<>()),
    WEIGHT(new WeightParameterConverter<>()),
    HEIGHT(new HeightParameterConverter<>()),
    WIDTH(new WidthParameterConverter<>()),
    DEPTH(new DepthParameterConverter<>()),
    QUANTITY(new QuantityParameterConverter<>()),
    COLOR(new ColorParameterConverter<>()),
    VOLTAGE(new VoltageParameterConverter<>());

    private final ParameterConverter<?> converter;

    RawConverters(ParameterConverter<?> converter) {
        this.converter = converter;
    }

    @SuppressWarnings("unchecked")
    public <A extends Appliance<A>> ParameterConverter<A> generic() {
        return (ParameterConverter<A>) converter;
    }
}

