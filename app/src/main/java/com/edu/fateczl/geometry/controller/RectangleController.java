package com.edu.fateczl.geometry.controller;

import com.edu.fateczl.geometry.model.Rectangle;

/**
 * @author Adriano M Sanchez
 */
public class RectangleController implements IGeometryController<Rectangle> {

    public RectangleController(){
        super();
    }

    @Override
    public Float getArea(Rectangle f) {
        return f.getBase() * f.getHeight();
    }

    @Override
    public Float getPerimeter(Rectangle f) {
        return (f.getBase() * 2f) + (f.getHeight() * 2f);
    }
}
