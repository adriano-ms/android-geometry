package com.edu.fateczl.geometry;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.edu.fateczl.geometry.controller.IGeometryController;
import com.edu.fateczl.geometry.model.Circle;
import com.edu.fateczl.geometry.model.Rectangle;

/**
 * @author Adriano M Sanchez
 */
public class RectangleFragment extends Fragment {

    private View view;
    private EditText etBaseRectangle;
    private EditText etHeightRectangle;
    private TextView tvResultRectangle;
    private Button btAreaRectangle;
    private Button btPerimeterRectangle;
    private IGeometryController<Rectangle> controller;

    public RectangleFragment(IGeometryController<Rectangle> controller) {
        this.controller = controller;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rectangle, container, false);
        etBaseRectangle = view.findViewById(R.id.etBaseRectangle);
        etHeightRectangle = view.findViewById(R.id.etHeightRectangle);
        tvResultRectangle = view.findViewById(R.id.tvResultRectangle);
        btAreaRectangle = view.findViewById(R.id.btAreaRectangle);
        btAreaRectangle.setOnClickListener(b -> calculateArea());
        btPerimeterRectangle = view.findViewById(R.id.btPerimeterRectangle);
        btPerimeterRectangle.setOnClickListener(b -> calculatePerimeter());
        return view;
    }

    @SuppressLint("DefaultLocale")
    private void calculateArea(){
        try {
            Rectangle rectangle = new Rectangle();
            rectangle.setBase(Float.parseFloat(etBaseRectangle.getText().toString()));
            rectangle.setHeight(Float.parseFloat(etHeightRectangle.getText().toString()));
            tvResultRectangle.setText(String.format("%s: %.2f", getString(R.string.bt_area), controller.getArea(rectangle)));
            etBaseRectangle.getText().clear();
            etHeightRectangle.getText().clear();
        } catch (NumberFormatException e) {
            new AlertDialog.Builder(view.getContext()).setTitle(getString(R.string.error_alert_title)).setMessage(getString(R.string.invalid_input_message)).show();
        }
    }

    @SuppressLint("DefaultLocale")
    private void calculatePerimeter(){
        try {
            Rectangle rectangle = new Rectangle();
            rectangle.setBase(Float.parseFloat(etBaseRectangle.getText().toString()));
            rectangle.setHeight(Float.parseFloat(etHeightRectangle.getText().toString()));
            tvResultRectangle.setText(String.format("%s: %.2f", getString(R.string.bt_perimeter), controller.getPerimeter(rectangle)));
            etBaseRectangle.getText().clear();
            etHeightRectangle.getText().clear();
        } catch (NumberFormatException e) {
            new AlertDialog.Builder(view.getContext()).setTitle(getString(R.string.error_alert_title)).setMessage(getString(R.string.invalid_input_message)).show();
        }
    }
}