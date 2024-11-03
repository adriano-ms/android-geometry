package com.edu.fateczl.geometry.controller;

import com.edu.fateczl.geometry.model.Circle;

/**
 * @author Adriano M Sanchez
 */
public class CircleController implements IGeometryController<Circle> {

    public CircleController(){
        super();
    }

    @Override
    public Float getArea(Circle f) {
        return (float) (Math.PI * (Math.pow(f.getRadius(), 2f)));
    }

    @Override
    public Float getPerimeter(Circle f) {
        return (float) (2f * Math.PI * f.getRadius());
    }
}
